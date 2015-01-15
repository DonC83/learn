package com.donc.docstore;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.FileContent;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import com.google.api.services.oauth2.Oauth2;
import com.google.api.services.oauth2.Oauth2Scopes;
import com.google.api.services.oauth2.model.Userinfoplus;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * Date: 2014/12/15
 * <p/>
 *
 * @author <a href="mailto:donovan.chong@gmail.com">Donovan</a>
 */
public class GDService implements DocService {

    private static final String CLIENT_ID = "68738376005.apps.googleusercontent.com";
    private static final String CLIENT_SECRET = "M7jUHu_COKn8FOvU4ugZH2Ax";

    private static final String REDIRECT_URI = "urn:ietf:wg:oauth:2.0:oob";

    private static GoogleAuthorizationCodeFlow flow;
    private JsonFactory jsonFactory;
    private HttpTransport httpTransport;

    private Drive driveService;
    private Properties properties;

    {
        jsonFactory = new JacksonFactory();
        httpTransport = new NetHttpTransport();
        properties = new Properties();
        try {
            properties.load(GDService.class.getClassLoader().getResourceAsStream("tokens.properties"));

            GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(jsonFactory,
                    new InputStreamReader(GDService.class.getClassLoader().getResourceAsStream("client_secrets.json")));

            flow = new GoogleAuthorizationCodeFlow.Builder(httpTransport, jsonFactory, clientSecrets, Arrays.asList(DriveScopes.DRIVE,
                    DriveScopes.DRIVE_FILE, DriveScopes.DRIVE_READONLY, DriveScopes.DRIVE_APPDATA, DriveScopes.DRIVE_APPS_READONLY,
                    DriveScopes.DRIVE_METADATA_READONLY,
                    Oauth2Scopes.USERINFO_PROFILE, Oauth2Scopes.USERINFO_EMAIL))
                    .setAccessType("offline")
                    .setApprovalPrompt("force").build();
            driveService = createService();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        flow = new GoogleAuthorizationCodeFlow.Builder(httpTransport, jsonFactory,
//                CLIENT_ID, CLIENT_SECRET, Arrays.asList(DriveScopes.DRIVE))
//                .setAccessType("offline")
//                .setApprovalPrompt("auto").build();


    }

    @Override
    public String getAuthorizeURL() {
        return null;
    }

    public Drive createService() throws IOException {
        Credential credentials = null;
        Drive service;

        if ((properties.getProperty("gd.refresh.token")==null || properties.getProperty("gd.refresh.token").equals("")) ||
                (properties.getProperty("gd.access.token")==null || properties.getProperty("gd.access.token").equals(""))) {

            String url = flow.newAuthorizationUrl().setRedirectUri(REDIRECT_URI).build();
            System.out.println("Please open the following URL in your browser then type the authorization code:");
            System.out.println("  " + url);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String code = br.readLine();

            GoogleTokenResponse response = flow.newTokenRequest(code).setRedirectUri(REDIRECT_URI).execute();
            credentials = flow.createAndStoreCredential(response, null);

            Oauth2 oauth2 = new Oauth2.Builder(new NetHttpTransport(), new JacksonFactory(), credentials)
                    .setApplicationName("API Project").build();
            Userinfoplus userInfo = oauth2.userinfo().get().execute();
            userInfo.getId();
            System.out.println(userInfo);

            //Create a new authorized API client
            System.out.println(credentials.getRefreshToken());
            System.out.println(credentials.getAccessToken());
            properties.put("refresh.token", credentials.getRefreshToken());
            //TODO store the refresh and access tokens

        } else {
            credentials = new GoogleCredential();
            credentials.setAccessToken(properties.getProperty("access.token"));
            //        credentials.setRefreshToken(properties.getProperty("refresh.token"));
        }

        service = new Drive.Builder(httpTransport, jsonFactory, credentials).build();
        return service;
    }

    public void getFolderListing() throws IOException{


        //Insert a file
//        File body = new File();
//        body.setTitle("My document");
//        body.setDescription("A test document");
//        body.setMimeType("text/plain");
//
//        java.io.File fileContent = new java.io.File("document.txt");
//        FileContent mediaContent = new FileContent("text/plain", fileContent);
//
//        File file = service.files().insert(body, mediaContent).execute();
//        System.out.println("File ID: " + file.getId());


        Drive.Files.List list = driveService.files().list();
        FileList fileList = list.execute();
        List<File> files = fileList.getItems();
        for (File f : files) {
            System.out.println(f.getTitle());
        }

    }

    public void addFile(java.io.File fileContent) throws IOException{
        // Insert a file
             File body = new File();
        body.setTitle("My document");
        body.setDescription("A test document");
        body.setMimeType("text/plain");

        FileContent mediaContent = new FileContent("text/plain", fileContent);

        File file = driveService.files().insert(body, mediaContent).execute();
        System.out.println("File ID: " + file.getId());
    }

    public static void main(String[] args) {
        GDService service = new GDService();
        try {
            service.getFolderListing();
        } catch (IOException e) {
            System.err.println("Could not retrieve file listing " + e.getMessage());
        }
    }

}
