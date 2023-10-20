package com.example.application.api;

import com.example.application.domain.Application;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

public class ApplicationApi {
    private RestTemplate restTemplate = new RestTemplate();

    private String url = "http://localhost:50789/capstonegroup7/application";

    private boolean bankStatement;
    private boolean paySlip;
    private String status;
    private String adress;
    private String email;
    private String contactNumber;
    private int id;
    private String firstName;
    private String lastName;
    private LocalDate applicationDate;
    private String propertyId;
    private String tenantId;
    private boolean copyOfId;
    private String references;

    public Application save(){
        HttpEntity<Application> saveRequest = new HttpEntity<>(new Application(bankStatement,paySlip, status
        , adress, email, contactNumber, id, firstName, lastName, applicationDate, propertyId, tenantId
        , copyOfId, references));
        return null;
    }

    public Application read(){
        return null;
    }

    public Application update(){
        return null;
    }

    public Application delete(){
        return null;
    }

    public Application findAll(){
        return null;
    }
}
