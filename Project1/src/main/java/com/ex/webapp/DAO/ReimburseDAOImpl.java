package com.ex.webapp.DAO;

import com.ex.webapp.models.ReimbursementRequest;
import com.ex.webapp.models.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ReimburseDAOImpl extends AbstractDAO implements ReimburseDAO{
    private Session session;
    User user = null;

    /**
     * the addReimbursement method is used to save a transaction given from the form provided and store the information as a transaction
     * the session searches for a transaction object, which is created in the ReimbursementRequestservlet
     * @param reimbursement
     * @return
     */
    @Override
    public boolean addReimbursement(ReimbursementRequest reimbursement) {

        Transaction tx = null;
        AbstractDAO.configure();
        try{
            session = this.sessionFactory.openSession();
            tx= session.beginTransaction();
            session.save(reimbursement);
            tx.commit();
        }finally {
            session.close();
        }
        return true;
    }

    /**
     * the getAllReimbursementPendingById uses hql to check for reimbursements associated with an employeeId and
     * if the status of the reimbursement is pending.
     * @param requestId
     * @return
     */
    @Override
    public List<ReimbursementRequest> getAllReimbursePendingByID(int requestId) {
        AbstractDAO.configure();
        List<ReimbursementRequest> reimbursements;
        try{
            session = this.sessionFactory.openSession();
            String hql = "from ReimbursementRequest where user_id = :user_id and status = 'pending'";
            Query query = session.createQuery(hql);
            query.setInteger("user_id", requestId);
            reimbursements = query.list();
        }
        finally {
            session.close();
        }
        return reimbursements;
    }

    /**
     * the getAllReimbursePending gets every single pending reimbursement request and searches by employeeId.
     * a join is made between the reimbursement request table and the user table to display all associated information
     * and make the connection between users and reimbursements
     * @return
     */
    @Override
    public List<ReimbursementRequest> getAllReimbursePending() {
        AbstractDAO.configure();
        List<ReimbursementRequest> reimbursements;
        try {
            session = this.sessionFactory.openSession();
            String hql = "from ReimbursementRequest r, User u where r.userid = u.userid and status = 'pending'";
            Transaction t = session.beginTransaction();
            Query query = session.createQuery(hql);

            reimbursements= query.list();

            t.commit();

        }finally {
            if (session != null) {
                session.close();
            }
        }
        return reimbursements;
    }

    /**
     * the getAllReimburseResolved uses hql to search through my database to find a reimbursement request with the status approved
     * and searches by userid.
     * a join is made between the reimbursement request table and the user table to display all associated information
     * and make the connection between users and reimbursements
     * @return
     */
    @Override
    public List<ReimbursementRequest> getAllReimburseResolved() {
        AbstractDAO.configure();
        List<ReimbursementRequest> reimbursements;
        try {
            session = this.sessionFactory.openSession();
            String hql = "from ReimbursementRequest r, User u where r.userid = u.userid and status = 'approved'";
            Transaction t = session.beginTransaction();
            Query query = session.createQuery(hql);

            reimbursements= query.list();

            t.commit();

        }finally {
            if (session != null) {
                session.close();
            }
        }
        return reimbursements;
    }

}
