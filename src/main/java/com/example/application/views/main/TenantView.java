package com.example.application.views.main;

import com.example.application.domain.Tenant;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

import java.util.ArrayList;
import java.util.List;

@Route("Tenant")
@RouteAlias("tenant")
public class TenantView extends VerticalLayout {
    private final TextField tenantIdField = new TextField("Tenant ID");
    private final TextField firstNameField = new TextField("First Name");
    private final TextField lastNameField = new TextField("Last Name");
    private final TextField contactNumberField = new TextField("Contact Number");
    private final TextField emailField = new TextField("Email");
    private final TextField leaseIdField = new TextField("Lease ID");
    private final Button signupButton = new Button("Sign Up");
    private Button addButton = new Button("Save");
    private Button viewButton = new Button("Read");
    private Button editButton = new Button("Update");
    private Button deleteButton = new Button("Delete");

    private List<Tenant> tenants = new ArrayList<>();
    private ListDataProvider<Tenant> tenantDataProvider = new ListDataProvider<>(tenants);

    public TenantView() {
        FormLayout formLayout = new FormLayout();
        formLayout.add(tenantIdField, firstNameField, lastNameField, contactNumberField,
                emailField, leaseIdField, signupButton);

        HorizontalLayout footerContainer = new HorizontalLayout(addButton,viewButton, editButton, deleteButton);
        footerContainer.setSpacing(true);
        footerContainer.addClassName("footer");
        add(footerContainer);

        signupButton.addClickListener(event -> {
            saveTenant();
        });
        addButton.addClickListener(event -> saveTenant());
        viewButton.addClickListener(event -> viewTenant());
        editButton.addClickListener(event -> editTenant());
        deleteButton.addClickListener(event -> deleteTenant());

        //Grid to display tenants
        Grid<Tenant> tenantGrid = new Grid<>(Tenant.class);
        tenantGrid.setDataProvider(tenantDataProvider);

        //Styling for the buttons
        Style bgs = footerContainer.getStyle();
        bgs.set("margin-left", "auto");
        bgs.set("margin-right", "auto");

        Style bg = addButton.getStyle();
        bg.set("margin-left", "auto");
        bg.set("margin-right", "auto");
        bg.set("color", "white");
        bg.set("background-color", "Black");
        bg.set("border-radius", "8px");

        Style bg2 = viewButton.getStyle();
        bg2.set("margin-left", "auto");
        bg2.set("margin-right", "auto");
        bg2.set("color", "white");
        bg2.set("background-color", "Black");
        bg2.set("border-radius", "8px");

        Style bg3 = editButton.getStyle();
        bg3.set("margin-left", "auto");
        bg3.set("margin-right", "auto");
        bg3.set("color", "white");
        bg3.set("background-color", "Black");
        bg3.set("border-radius", "8px");

        Style bg4 = deleteButton.getStyle();
        bg4.set("margin-left", "auto");
        bg4.set("margin-right", "auto");
        bg4.set("color", "white");
        bg4.set("background-color", "Black");
        bg4.set("border-radius", "8px");

        Style bg5 = signupButton.getStyle();
        bg5.set("margin-left", "auto");
        bg5.set("margin-right", "auto");
        bg5.set("color", "white");
        bg5.set("background-color", "Black");
        bg5.set("border-radius", "8px");

        add(formLayout, footerContainer, tenantGrid);
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
    public void viewTenant(){

    }
    public void editTenant(){

    }
    public void deleteTenant(){

    }

}