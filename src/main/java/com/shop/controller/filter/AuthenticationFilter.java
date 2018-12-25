package com.shop.controller.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.LogRecord;

@WebFilter("/*")
public class AuthenticationFilter implements Filter {

    public void init( FilterConfig fConfig) throws ServletException{

    }

    public void doFilter( ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession(false);

        String loginURI = req.getContextPath() + "/login";
        String registerURI = req.getContextPath() + "/register";

        boolean loggedIn = session != null && session.getAttribute("user") != null;
        boolean isLoginRequest = req.getRequestURL().equals(loginURI);
        boolean isRegisterRequest = req.getRequestURL().equals(registerURI);

        if (loggedIn || isLoginRequest || isRegisterRequest){
            chain.doFilter(request,response);
        } else {
            res.sendRedirect(loginURI);
        }
    }

    @Override
    public void destroy() {

    }


}
