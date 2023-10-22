package com.example.application.views.main;

import com.example.application.domain.Agent;
import com.example.application.domain.Landlord;
import com.example.application.domain.Tenant;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
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
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Route(value = "Tenant", layout = HomeView.class)
//@RouteAlias("tenant")
@SpringComponent
@UIScope
public class TenantView extends VerticalLayout {
    private RestTemplate restTemplate;
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

    public TenantView(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;

        H2 heading = new H2("Tenant form:");

        Style headingStyle = heading.getStyle();
        headingStyle.set("margin-left", "auto");
        headingStyle.set("margin-right", "auto");

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
        viewButton.addClickListener(event -> readTenant());
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

        add(heading, formLayout, footerContainer, tenantGrid);
    }

    private void saveTenant() {
        Tenant tenant = new Tenant(
                tenantIdField.getValue(),
                firstNameField.getValue(),
                lastNameField.getValue(),
                contactNumberField.getValue(),
                emailField.getValue(),
                leaseIdField.getValue()
        );

        try {
            ResponseEntity<Tenant> response = restTemplate.postForEntity("http://localhost:50790/tenants/save", tenant, Tenant.class);
            if (response.getStatusCode() == HttpStatus.CREATED) {
                Notification.show("Tenant saved successfully");
                clearFormFields();
                readTenant(); // Optional: Refresh the grid after saving
            } else {
                Notification.show("Tenant saved successfully");
            }
        } catch (RestClientException e) {
            Notification.show("Failed to save landlord");
        }
        clearFormFields();
    }

    public void readTenant(){
        try {
            Tenant[] response = restTemplate.getForObject("http://localhost:50790/tenants/all", Tenant[].class);
            if (response != null) {
                tenants.clear();
                tenants.addAll(Arrays.asList(response));
                tenantDataProvider.refreshAll();

            } else {
                Notification.show("No tenants found");
            }
        } catch (RestClientException e) {
            Notification.show("Failed to retrieve tenants from the server");
        }
    }


    public void editTenant(){

    }
    public void deleteTenant(){
        String tenantId = tenantIdField.getValue();
        if (tenantId != null && !tenantId.isEmpty()) {
            try {
                restTemplate.delete("http://localhost:50790/tenants/delete/" + tenantId);
                Notification.show("Tenant deleted successfully");
                clearFormFields();
              //  readTenant();
            } catch (RestClientException e) {
                Notification.show("failed to delete tenant");
            }
        } else {
            Notification.show("tenant ID is required to delete");
        }
    }
    private void clearFormFields() {
        tenantIdField.clear();
        firstNameField.clear();
        lastNameField.clear();
        contactNumberField.clear();
        emailField.clear();
        leaseIdField.clear();
    }
}