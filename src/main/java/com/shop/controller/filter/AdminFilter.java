package com.shop.controller.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/admin/*")
public class AdminFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public void init(FilterConfig fConfig) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.debug("Admin filter");

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession(false);

        if (session != null && session.getAttribute("user") != null) {

            String role = (String) session.getAttribute("role");
            logger.debug(String.format("User role : %s", role));
            boolean isAdmin = role != null && role.equals("admin");

            if (isAdmin) {
                logger.debug("User is admin - allow access");
                chain.doFilter(request, response);
            } else {
                logger.debug("User is not admin - deny access");
                res.sendError(403, "Access denied");
            }
        } else {
            String loginURI = req.getContextPath() + "/login";
            res.sendRedirect(loginURI);
        }
    }

    public void destroy() {
        //close any resources here
    }
}