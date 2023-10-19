package com.example.application.views.main;

import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;

@Route(value = "application")
@UIScope
public class ApplicationView extends VerticalLayout {
    private TextField applicationId = new TextField("Application Id");
    private Checkbox bankStatement = new Checkbox("Bank statement");

    private Checkbox paySlip = new Checkbox("Pay slip");

    private TextField status = new TextField("Status");

    private TextField adress = new TextField("Address");

    private TextField email = new TextField("Email");

    private TextField contactNumber = new TextField("Contact number");

    private int id;

    private TextField firstName = new TextField("First name");

    private TextField lastName = new TextField("Last name");

    private DatePicker applicationDate = new DatePicker("Date of application");

    private TextField propertyId = new TextField("Property Id");

    private TextField tenantId = new TextField("Tenant Id");

    private Checkbox copyOfId = new Checkbox("Copy of Id");

    private TextField references = new TextField("References");
}
