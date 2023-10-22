package com.example.application.views.main;


import com.example.application.domain.Landlord;
import com.example.application.domain.Tenant;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.router.Route;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Route("landlord")
public class LandlordView extends VerticalLayout {
        private RestTemplate restTemplate;

        private final TextField landlordIdField = new TextField("Landlord ID");
        private final TextField firstNameField = new TextField("First Name");
        private final TextField lastNameField = new TextField("Last Name");
        private final TextField contactNumberField = new TextField("Contact Number");
        private final TextField emailField = new TextField("Email");
        private final TextField passwordField = new TextField("Password");
        private final TextField addressField = new TextField("Address");

        private final Button saveButton = new Button("Save");
        private final Button readButton = new Button("Read");
        private final Button updateButton = new Button("Update");
        private final Button deleteButton = new Button("Delete");

        private List<Landlord> landlords = new ArrayList<>();
        private ListDataProvider<Landlord> landlordDataProvider = new ListDataProvider<>(landlords);


        public LandlordView(RestTemplate restTemplate) {
            this.restTemplate = restTemplate;
            // Create a form layout and add form fields
            FormLayout formLayout = new FormLayout();
            formLayout.add(landlordIdField, firstNameField, lastNameField, contactNumberField, emailField, passwordField, addressField);

            // Create a layout for buttons
            HorizontalLayout buttonGroup = new HorizontalLayout(saveButton, readButton, updateButton, deleteButton);
            buttonGroup.setSpacing(true);

            saveButton.addClickListener(event -> saveLandlord());
            readButton.addClickListener(event -> readLandlord());
            updateButton.addClickListener(event -> updateLandlord());
            deleteButton.addClickListener(event -> deleteLandlord());

            // Create a grid to display agents
            Grid<Landlord> LandlordGrid = new Grid<>(Landlord.class);
            LandlordGrid.setDataProvider(landlordDataProvider);


            // Add the form layout, buttons, and grid to the view
            Style bgs = buttonGroup.getStyle();
            bgs.set("margin-left", "auto");
            bgs.set("margin-right", "auto");

            Style bg = saveButton.getStyle();
            bg.set("margin-left", "auto");
            bg.set("margin-right", "auto");
            bg.set("color", "white");
            bg.set("background-color", "Black");
            bg.set("border-radius", "8px");

            Style bg2 = readButton.getStyle();
            bg2.set("margin-left", "auto");
            bg2.set("margin-right", "auto");
            bg2.set("color", "white");
            bg2.set("background-color", "Black");
            bg2.set("border-radius", "8px");

            Style bg3 = updateButton.getStyle();
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

            add(formLayout, buttonGroup, LandlordGrid);

        }

        private void saveLandlord() {
                Landlord landlord = new Landlord(
                        landlordIdField.getValue(),
                        firstNameField.getValue(),
                        lastNameField.getValue(),
                        contactNumberField.getValue(),
                        emailField.getValue(),
                        passwordField.getValue(),
                        addressField.getValue()
                );

                try {
                    ResponseEntity<Landlord> response = restTemplate.postForEntity("http://localhost:50790/landlords/save", landlord, Landlord.class);
                    if (response.getStatusCode() == HttpStatus.CREATED) {
                        Notification.show("Landlord saved successfully");
                        clearFormFields();
                        readLandlord(); // Optional: Refresh the grid after saving
                    } else {
                        Notification.show("Landlord saved successfully");
                    }
                } catch (RestClientException e) {
                    Notification.show("Failed to save landlord");
                }
            clearFormFields();
            }



        private void readLandlord() {
            try {
                Landlord[] response = restTemplate.getForObject("http://localhost:50790/landlords/all", Landlord[].class);
                if (response != null) {
                    landlords.clear();
                    landlords.addAll(Arrays.asList(response));
                    landlordDataProvider.refreshAll();

                } else {
                    Notification.show("No landlords found");
                }
            } catch (RestClientException e) {
                Notification.show("Failed to retrieve landlords from the server");
            }
        }

        private void updateLandlord() {
            // Implement logic to update an agent's details in the backend
            // Typically, retrieve the agent by ID and update the properties
        }

        private void deleteLandlord() {
            String landlordId = landlordIdField.getValue();
            if (landlordId != null && !landlordId.isEmpty()) {
                try {
                    restTemplate.delete("http://localhost:50790/landlords/delete/" + landlordId);
                    Notification.show("Landlord deleted successfully");
                    clearFormFields();
                    //  readTenant();
                } catch (RestClientException e) {
                    Notification.show("Landlord to delete tenant");
                }
            } else {
                Notification.show("landlord ID is required to delete");
            }
        }

        private void clearFormFields() {
            landlordIdField.clear();
            firstNameField.clear();
            lastNameField.clear();
            contactNumberField.clear();
            emailField.clear();
            passwordField.clear();
            addressField.clear();
        }
    }

