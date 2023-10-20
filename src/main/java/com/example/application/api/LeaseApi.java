package com.example.application.api;

import com.example.application.domain.Lease;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

public class LeaseApi {
    private RestTemplate restTemplate = new RestTemplate();

    private String url = "http://localhost:50789/capstonegroup7/lease";

    private String terms  = "skop";
    private LocalDate startDate = LocalDate.parse("2023-10-20");
    private LocalDate endDate = LocalDate.parse("2023-10-20");

    public Lease save(){
        HttpEntity<Lease> saveRequest = new HttpEntity<>(new Lease(terms, startDate, endDate));
    return null;
    }

    public Lease read(){
        return null;
    }

    public Lease update(){
        return null;
    }

    public Lease delete(){
        return null;
    }

    public Lease findAll(){
        return null;
    }
}
