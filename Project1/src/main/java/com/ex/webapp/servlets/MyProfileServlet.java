package com.ex.webapp.servlets;

import com.ex.webapp.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MyProfileServlet extends HttpServlet {
    /**
     * this servlet allows me to grab current information about the user and display it to the profile page
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.getAttribute("User");

        req.getRequestDispatcher("myProfile.jsp").forward(req,resp);
    }
}