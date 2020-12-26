package com.ex.webapp.servlets;

import com.ex.webapp.DAO.UserDAOImpl;
import com.ex.webapp.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class LoginServlet extends HttpServlet {
    /**
     * if a user is already in the system, the employee page will be displayed.
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("user") != null) {
            req.getRequestDispatcher("employeehome.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }

    /**
     * the doPost method is used in order to grab information from the user and process it into hql
     * using my get by employee method, i am able to check my database and grab associated information about the user
     * the get parameter methods are used to asign the strings employee id and password.
     * first, the password is checked in order to determine if the user is valid, then if the user is a manager.
     * The boolean value manager in my user table allows me to send the user to either the manager or employee home page
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String employeeId = req.getParameter("employeeId");
        String password = req.getParameter("password");

        UserDAOImpl impl = new UserDAOImpl();
        User user = impl.getByEmployeeId(employeeId);


        req.setAttribute("user", user);

        System.out.println(user);
        if (user.getPassword().equals(password)) {
            if (user.getIsManager()) {
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                req.getRequestDispatcher("managerhome.jsp").forward(req, res);
            } else {
                req.getRequestDispatcher("employeehome.jsp").forward(req, res);
            }

            }
        }
}






