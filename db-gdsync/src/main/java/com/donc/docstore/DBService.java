package com.donc.docstore;

import com.dropbox.core.*;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Properties;

/**
 * Date: 2014/12/15
 * <p/>
 *
 * @author <a href="mailto:donovan.chong@gmail.com">Donovan</a>
 */
public class DBService implements DocService {

    private static final String APP_KEY = "hoe3gjp6xjqqj4c";
    private static final String APP_SECRET = "m2b0vskkq1f2ngz";

    private Properties properties;
    private DbxClient client;


    {
        properties = new Properties();
        try {
            properties.load(DBService.class.getClassLoader().getResourceAsStream("tokens.properties"));
            client = createClient();
            System.out.println("Linked account: " + client.getAccountInfo().displayName);
        } catch (IOException | DbxException e) {
            e.printStackTrace();
        }
    }


    private DbxWebAuthNoRedirect webAuth;


    public String getAuthorizeURL() {
        DbxRequestConfig config = new DbxRequestConfig("DB-GDSync/1.0", Locale.getDefault().toString());
        DbxAppInfo appInfo = new DbxAppInfo(APP_KEY, APP_SECRET);

        webAuth = new DbxWebAuthNoRedirect(config, appInfo);
        String authorizeUrl = webAuth.start();
        System.out.println("Please open the following URL in your browser then type the authorization code:");
        System.out.println("  " + authorizeUrl);

        return authorizeUrl;
    }

    private DbxClient createClient(String code) throws DbxException {
        webAuth.finish(code);
        return null;
    }


    private DbxClient createClient() throws IOException, DbxException {
        String accessToken = properties.getProperty("dbx.access.token");

        DbxRequestConfig config = new DbxRequestConfig(
                "DB-GDSync/1.0", Locale.getDefault().toString());
        if (accessToken==null || accessToken.equals("")) {
            DbxAppInfo appInfo = new DbxAppInfo(APP_KEY, APP_SECRET);


            DbxWebAuthNoRedirect webAuth = new DbxWebAuthNoRedirect(config, appInfo);
            String authorizeUrl = webAuth.start();
            System.out.println("Please open the following URL in your browser then type the authorization code:");
            System.out.println("  " + authorizeUrl);

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String code = br.readLine().trim();

            DbxAuthFinish authFinish = webAuth.finish(code);
            accessToken = authFinish.accessToken;
            System.out.println(accessToken);
        }

        return new DbxClient(config, accessToken);
    }

    public void getFileListing() throws DbxException {
        DbxEntry.WithChildren listing = client.getMetadataWithChildren("/");

        for (DbxEntry entry : listing.children) {
            try {
                if (!entry.isFolder()) {
                    FileOutputStream fis = new FileOutputStream(entry.name);
                    System.out.println(entry.name);
                    client.getFile(entry.path, null, fis);
                } else {
                    DbxEntry.Folder folder = entry.asFolder();
                    DbxEntry.WithChildren subListing = client.getMetadataWithChildren(folder.path);


                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    public static void main(String[] args) throws IOException, DbxException {


        DBService service = new DBService();
        service.getFileListing();

    }


}
