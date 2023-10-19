package com.example.application.views.main;

import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;

@PageTitle("Lease")
@Route("lease")
@UIScope
public class Lease extends FormLayout {
    private TextField leaseId = new TextField("Lease Id");

    private TextField terms = new TextField("Terms");

    private DatePicker startDate = new DatePicker("Start date");

    private DatePicker endDate = new DatePicker("End date");

    public Lease(){
        leaseId.setPlaceholder("Enter a lease Id");
        terms.setPlaceholder("Enter in the terms");
        startDate.setPlaceholder("Select the start date");
        endDate.setPlaceholder("Select the end date");

        VerticalLayout leaseForm = new VerticalLayout();
        leaseForm.add(leaseId);
        leaseForm.add(terms);
        leaseForm.add(startDate);
        leaseForm.add(endDate);

        leaseForm.setAlignItems(FlexComponent.Alignment.CENTER);
        leaseForm.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        setSizeFull();

        add(leaseForm);
    }
}
