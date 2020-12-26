package com.ex.webapp.servlets;

import com.ex.webapp.DAO.UserDAOImpl;
import com.ex.webapp.models.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ViewAllEmployeesServlet extends HttpServlet {
    /**
     * this servlet uses the get all users method to display all users in the database
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User)(session.getAttribute("User"));


        UserDAOImpl impl = new UserDAOImpl();
        List<User> list = impl.getAllUsers();

        req.getRequestDispatcher("viewEmployees.jsp").forward(req,res);
    }
}
