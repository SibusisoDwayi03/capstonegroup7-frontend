package com.example.application.api;

import com.example.application.domain.Lease;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class LeaseApi {
    private RestTemplate restTemplate = new RestTemplate();

    private String url = "http://localhost:50789/capstonegroup7/lease";

    private String terms = "skop";
    private LocalDate startDate = LocalDate.parse("2023-10-20");
    private LocalDate endDate = LocalDate.parse("2023-10-20");

    public Lease save() {
        HttpEntity<Lease> saveRequest = new HttpEntity<>(new Lease(terms, startDate, endDate));
        return null;
    }

    public Lease read() {
        return null;
    }

    public Lease update() {
        return null;
    }

    public Lease delete() {
        String deleteRequest = url + "/delete/"; //+ Lease.getLeaseId();
        restTemplate.delete(deleteRequest);
        return null;
    }

    public Set<Lease> findALl() {
//        String apiUrl = url + "getAll";
//        ResponseEntity<Lease[]> response1 = restTemplate.getForEntity(apiUrl, Lease[].class);
//
//        if (response1.getStatusCode().is2xxSuccessful()) {
//            Lease[] lease = response1.getBody();
//            return new HashSet<>(lease);//Arrays.asList(lease));
//        } else {
//            return Collections.emptySet();
//        }
        return null;
    }
}