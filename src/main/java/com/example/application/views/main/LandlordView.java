package com.example.application.views.main;


import com.example.application.domain.Landlord;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.List;

@Route(value = "landlord", layout = HomeView.class)
public class LandlordView extends VerticalLayout {

        private final TextField landlordIdField = new TextField("Agent ID");
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

    private List<Landlord> Landlords = new ArrayList<>();
    private ListDataProvider<Landlord> LandlordDataProvider = new ListDataProvider<>(Landlords);


        public LandlordView() {
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
            LandlordGrid.setDataProvider(LandlordDataProvider);

//// Only add columns for the properties you want to display
//        agentGrid.addColumn("agentId").setHeader("Agent ID");
//        agentGrid.addColumn("firstName").setHeader("First Name");
//        agentGrid.addColumn("lastName").setHeader("Last Name");

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
            // Retrieve values from form fields and save the agent (similar to previous code)
            // ...

            // Clear form fields after saving
            clearFormFields();
        }

        private void readLandlord() {
            // Implement logic to read an agent from the backend (e.g., by ID)
            // Update the form fields with the agent's details
        }

        private void updateLandlord() {
            // Implement logic to update an agent's details in the backend
            // Typically, retrieve the agent by ID and update the properties
        }

        private void deleteLandlord() {
            // Implement logic to delete an agent from the backend (e.g., by ID)
            // Remove the agent from the list and refresh the data provider
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

