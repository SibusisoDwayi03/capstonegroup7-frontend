package com.example.application.views.main;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@Route("tenant-form")
@RouteAlias("tenant")
public class TenantFormView extends VerticalLayout {

    private final TextField tenantIdField = new TextField("Tenant ID");
    private final TextField firstNameField = new TextField("First Name");
    private final TextField lastNameField = new TextField("Last Name");
    private final TextField contactNumberField = new TextField("Contact Number");
    private final TextField emailField = new TextField("Email");
    private final TextField leaseIdField = new TextField("Lease ID");

    private final Button signupButton = new Button("Sign Up");

    public TenantFormView() {
        FormLayout formLayout = new FormLayout();
        formLayout.add(tenantIdField, firstNameField, lastNameField, contactNumberField, emailField, leaseIdField, signupButton);

        signupButton.addClickListener(event -> {
            saveTenant();
        });

        add(formLayout);
    }

    private void saveTenant() {
        String tenantId = tenantIdField.getValue();
        String firstName = firstNameField.getValue();
        String lastName = lastNameField.getValue();
        String contactNumber = contactNumberField.getValue();
        String email = emailField.getValue();
        String leaseId = leaseIdField.getValue();

        // You can perform actions to save the tenant data to your database here
        // For simplicity, we are just logging the data in this example
        System.out.println("Tenant ID: " + tenantId);
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Contact Number: " + contactNumber);
        System.out.println("Email: " + email);
        System.out.println("Lease ID: " + leaseId);

        Notification.show("First Name: " + firstName + "Last Name: " + lastName + "Contact Number: "+ contactNumber
                + "Email: " + email + "Lease ID: "+ leaseId);
    }
}

