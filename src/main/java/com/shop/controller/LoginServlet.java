package com.shop.controller;

import com.shop.model.User;
import com.shop.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private UserService userService = new UserService();
    private Logger logger = null;

    @Override
    public void init() throws ServletException {
        logger = LoggerFactory.getLogger(this.getClass());
    }

    @Override
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = userService.getUserByUserNameAndPassword(username, password);
        boolean isUserExists = userService.isUserExists(user);


        if (!isUserExists) {
            request.setAttribute("errorMessage", "Credentials are invalid!");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("user", user.getUsername());
            session.setAttribute("role", user.getRole());
            session.setMaxInactiveInterval(2 * 60);

//            Cookie userName = new Cookie("user", username);
//
//            userName.setMaxAge(30 * 60);
//            response.addCookie(userName);
            response.sendRedirect("loginsuccess.jsp");

        }

    }

}
