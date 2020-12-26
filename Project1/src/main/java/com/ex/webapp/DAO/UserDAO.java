package com.ex.webapp.DAO;

import com.ex.webapp.models.User;

import java.util.List;

/**
 * this interface is what we will use to hold our methods for getting employees
 * by email or employee id
 */

public interface UserDAO {
    public List<User> getAllUsers();
    public User getByEmployeeId(String employeeId);
    public User getByEmail(String email);

}
