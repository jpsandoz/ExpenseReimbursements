package com.ex.webapp.models;

import com.sun.javafx.beans.IDProperty;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Set;

@Entity
@Table(name="users")
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userid;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "employee_id", unique = true, nullable = false)
    private String employeeId;


    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "hash", nullable = false)
    private String password;

    @Column(name = "manager", nullable = false)
    private boolean isManager;


    //not sure if this is needed
//    @ManyToOne
//    @JoinColumn(name = )

    public User(){}

//    public User(String firstName, String lastName, String employeeId, int phone, String email, String password, boolean isManager) {
//
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.employeeId = employeeId;
//        this.phone = phone;
//        this.email = email;
//        this.password = password;
//        this.isManager = isManager;
//    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getIsManager() {
        return isManager;
    }

    public void setManager(boolean manager) {
        isManager = manager;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", isManager=" + isManager +
                '}';
    }
}



