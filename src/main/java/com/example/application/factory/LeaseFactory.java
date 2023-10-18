package com.example.application.factory;

import com.example.application.domain.Lease;
import com.example.application.util.Helper;
import java.time.LocalDate;

/* LeaseFactory.java
 *  This is a factory class for Lease entity.
 *  Zachariah Matsimella 220097429
 */
public class LeaseFactory {
    public static Lease createLease(String terms, LocalDate startDate, LocalDate endDate){
        if(Helper.isNullOrEmpty(terms)
        ||Helper.isDateNull(startDate)
        ||Helper.isDateNull(endDate)){
            return null;
        }


        String leaseId = Helper.generateId();

        Lease lease = new Lease.Builder().setLeaseId(leaseId)
                .setTerms(terms)
                .setStartDate(startDate)
                .setEndDate(endDate)
                .build();
        return lease;
    }

    public static Lease createLeaseWId(String leaseId, String terms, LocalDate startDate, LocalDate endDate){
        if(Helper.isNullOrEmpty(leaseId)
                ||Helper.isNullOrEmpty(terms)
                ||Helper.isDateNull(startDate)
                ||Helper.isDateNull(endDate)){
            return null;
        }

        Lease lease = new Lease.Builder().setLeaseId(leaseId)
                .setTerms(terms)
                .setStartDate(startDate)
                .setEndDate(endDate)
                .build();
        return lease;
    }
}
