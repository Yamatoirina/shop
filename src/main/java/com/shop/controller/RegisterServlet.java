package com.shop.controller;

import com.shop.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

    private UserService userService = new UserService();
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    protected void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        logger.debug("Got register request with username " +username );

        if(userService.isUserWithUsernameExists(username)){
            logger.error("Username with " + username + " exists!");
            request.setAttribute("errorMessage", "User with such username exists!");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
        } else{
            logger.debug("Will register username " + username);
            userService.createNewUser(username,password);
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }
}
