package com.ex.webapp.models;

import javax.persistence.*;

@Entity
@Table(name="reimbursement_requests")
public class ReimbursementRequest {
    //11/24 1hr 45min for joins
    @Id
    @Column(name = "request_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int requestid;

    @Column(name="user_id")
    private int userid;

    @Column(name="reimbursement_amount")
    private String amount;

    @Column(name = "account_type")
    private  String account;

    @Column(name = "submission_date")
    private String date;

    @Column(name = "status")
    private String status;


    public ReimbursementRequest() {
    }

    public ReimbursementRequest(int userid, String amount, String account, String date, String status) {
        this.userid = userid;
        this.amount = amount;
        this.date = date;
        this.status = status;

    }

    public int getRequestId() {
        return requestid;
    }

    public void setRequestid(int requestid) {
        this.requestid = requestid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String  amount) {
        this.amount = amount;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ReimbursementRequest{" +
                "requestId=" + requestid +
                ", userId=" + userid +
                ", amount=" + amount +
                ", account='" + account + '\'' +
                ", date='" + date + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
