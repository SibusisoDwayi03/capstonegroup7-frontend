package com.example.application.views.main;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.TextField;

import java.time.LocalDate;


public class Maintenance extends FormLayout {


    private TextField descriptionField = new TextField("Description");
    private TextField propertyIdField = new TextField("PropertyId");
    private TextField requestIdField = new TextField("RequestId");
    private DatePicker datePicker = new DatePicker("RequestDate");
    private Button submitButton = new Button("Submit");

    public Maintenance() {



        descriptionField.setPlaceholder("Enter a description");

        propertyIdField.setPlaceholder("Enter a propertyId");

        requestIdField.setPlaceholder("Enter a requestId");


        add(descriptionField,propertyIdField, requestIdField,datePicker, submitButton);

        submitButton.addClickListener(e -> {

            String description = descriptionField.getValue();
            String propertyId = descriptionField.getValue();
            String requestId = descriptionField.getValue();

            LocalDate selectedDate = datePicker.getValue();


            Notification.show("Description: " + description + ", Date: " + selectedDate);
            Notification.show("PropertyId: "+ propertyId + ",RequestId "+requestId);




        });



    }


}
