package com.ex.webapp.DAO;

import com.ex.webapp.models.User;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.Collections;
import java.util.List;

public class UserDAOImpl extends AbstractDAO implements UserDAO {
    public static User user = null;
    Session session = null;

    /**
     * this function uses an hql query to grab all users from a database.
     * @return
     */
    @Override
    public List<User> getAllUsers() {
        AbstractDAO.configure();
        List user = Collections.EMPTY_LIST;
        try {
            session = sessionFactory.openSession();
            String hql = "from user";
            Query query = session.createQuery(hql);
            user = query.list();
        } finally {
            session.close();
            return user;
        }
    }

    /**
     * the function getByEmployeeId uses hql to take user input from the form on the login page.
     * from the login page, hql grabs the form employeeId and matches it to my database. password matching is done in the servlet
     * @param employeeId
     * @return
     */
    @Override
    public User getByEmployeeId(String employeeId) {
        AbstractDAO.configure();
        try {
            session = this.sessionFactory.openSession();
            String hql = "from User where employee_id = :employee_id";
            Query query = session.createQuery(hql);
            query.setString("employee_id",employeeId);

            List<User> result = query.list();
            for(User u:result) {
                user = u;
            }
        } finally {
            session.close();
        } return user;
    }

    /**
     * the method getByEmail uses hql to match an email provided and checks if the fields match correctly
     * @param email
     * @return
     */
    @Override
    public User getByEmail(String email) {
        AbstractDAO.configure();
        try{
            session = this.sessionFactory.openSession();
            String hql = "from User where email = :email";
            Query query = session.createQuery(hql);
            query.setString("email",email);

            List<User> result = query.list();
            for(User u:result){
                user = u;
            }
        }
        finally {
            session.close();
        }return user;
    }
}


