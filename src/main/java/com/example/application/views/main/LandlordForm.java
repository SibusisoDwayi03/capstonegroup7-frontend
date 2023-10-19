package com.example.application.views.main;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;


public class LandlordForm extends FormLayout {


    private TextField firstNameField = new TextField("First Name");
    private TextField surnameField = new TextField("Surname");
    private EmailField emailField = new EmailField("Email");
    private TextField landlordIdField = new TextField("Landlord ID");
    private TextField contactField = new TextField("Contact");
    private PasswordField passwordField = new PasswordField("Password");
    private TextField addressField = new TextField("Address");
    private Button submitButton = new Button("Submit");

    public LandlordForm() {

        add(
                firstNameField,
                surnameField,
                emailField,
                landlordIdField,
                contactField,
                passwordField,
                addressField,
                submitButton
        );
        submitButton.addClickListener(e -> {

            String firstName = firstNameField.getValue();
            String surname = surnameField.getValue();
            String Email = emailField.getValue();
            String landlord = landlordIdField.getValue();
            String contact = contactField.getValue();
            String password = passwordField.getValue();
            String Address = addressField.getValue();

            Notification.show("Firstname: " + firstName + ", surname: " + surname +", Email" + Email +",landlord" + landlord+ ",contact"+ contact + ",password"+password +",Address"+Address);
        });
    }

    // Add form validation and submission logic here
}

