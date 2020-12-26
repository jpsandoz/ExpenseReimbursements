package com.ex.webapp.servlets;

import com.ex.webapp.DAO.ReimburseDAOImpl;
import com.ex.webapp.DAO.UserDAOImpl;
import com.ex.webapp.models.ReimbursementRequest;
import com.ex.webapp.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestReimbursementServlet extends HttpServlet {
    /**
     * the doPost method is used since we are taking information from the user to enter in to our database.
     * we grab the data to be added to the database by grabbing the user's id from the current session,
     * the amount entered, the account to be added to, the date done, and automatically assigns the pending status
     * using the reimbursementRequest constructor defined in that class, we create the reimbursement with the associated
     * information.
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        ReimburseDAOImpl rimpl = new ReimburseDAOImpl();
        User user = new User();
        req.getAttribute("user");

        int userid = user.getUserid();
        String amount = req.getParameter("amount");
        String account = req.getParameter("account");
        String date = req.getParameter("date");
        String status = "pending";
        ReimbursementRequest reimbursement = new ReimbursementRequest(userid, amount, account, date, status);
        rimpl.addReimbursement(reimbursement);
        req.getRequestDispatcher("requestSubmit.jsp").forward(req,res);

    }
}
