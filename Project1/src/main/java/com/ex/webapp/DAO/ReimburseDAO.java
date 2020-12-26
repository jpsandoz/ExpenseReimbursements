package com.ex.webapp.DAO;

import com.ex.webapp.models.ReimbursementRequest;

import java.util.List;

/**
 *
 * this interface is what we will use to hold our methods for searching for reimbursement
 * requests or searching through them
 */
public interface ReimburseDAO {

    boolean addReimbursement(ReimbursementRequest reimb);
    List<ReimbursementRequest> getAllReimbursePendingByID(int requestId);
    List<ReimbursementRequest> getAllReimbursePending();
    List<ReimbursementRequest> getAllReimburseResolved();

}
