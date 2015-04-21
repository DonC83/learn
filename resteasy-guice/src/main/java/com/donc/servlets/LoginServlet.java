package com.donc.servlets;

import com.donc.entities.User;
import com.donc.service.LoginService;
import com.google.common.io.Closer;
import org.apache.commons.codec.binary.Base64;
import org.jasypt.util.binary.StrongBinaryEncryptor;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by donovan on 15/04/14.
 */
@Singleton
public class LoginServlet extends HttpServlet {

    @Inject
    private LoginService loginService;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getParameter("username");
        req.getParameter("password");


        byte [] data;
        User user = new User();
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeObject(user);
            data = baos.toByteArray();
        }
        StrongBinaryEncryptor binaryEncryptor = new StrongBinaryEncryptor();
        byte [] encrypted = binaryEncryptor.encrypt(data);

        String encodeUser = Base64.encodeBase64String(encrypted);

        Cookie cookie = new Cookie("_session_cookie", encodeUser);
        resp.addCookie(cookie);


        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
