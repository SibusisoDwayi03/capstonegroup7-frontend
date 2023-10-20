package com.example.application.views.main;

import com.example.application.domain.Maintenance;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.router.Route;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Route("maintenance")
public class Maintenanceview extends VerticalLayout {


    private TextField descriptionField = new TextField("Description");
    private TextField propertyIdField = new TextField("PropertyId");
    private TextField requestIdField = new TextField("RequestId");
    private DatePicker datePicker = new DatePicker("RequestDate");
    private Button submitButton = new Button("Submit");


    private final Button saveButton = new Button("Save");
    private final Button readButton = new Button("Read");
    private final Button updateButton = new Button("Update");
    private final Button deleteButton = new Button("Delete");

    private List<Maintenance> maintenances = new ArrayList<>();
    private ListDataProvider<Maintenance> maintenanceDataProvider = new ListDataProvider<>(maintenances);

    public Maintenanceview() {

        // Create a form layout and add form fields
        FormLayout formLayout = new FormLayout();
        formLayout.add(descriptionField, propertyIdField , requestIdField, datePicker ,submitButton);

        // Create a layout for buttons
        HorizontalLayout buttonLayout = new HorizontalLayout(saveButton, readButton, updateButton, deleteButton);
        buttonLayout.setSpacing(true);

        saveButton.addClickListener(event -> saveMaintenance());
        readButton.addClickListener(event -> readMaintenance());
        updateButton.addClickListener(event -> updateMaintenance());
        deleteButton.addClickListener(event -> deleteMaintenance());

        // Create a grid to display agents
        Grid<Maintenance> maintenanceGrid = new Grid<>(Maintenance.class);
        maintenanceGrid.setDataProvider(maintenanceDataProvider);





//// Only add columns for the properties you want to display
//        agentGrid.addColumn("agentId").setHeader("Agent ID");
//        agentGrid.addColumn("firstName").setHeader("First Name");
//        agentGrid.addColumn("lastName").setHeader("Last Name");

        // Add the form layout, buttons, and grid to the view

        Style bgs = buttonLayout.getStyle();
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

        add(formLayout, buttonLayout, maintenanceGrid);
    }

    private void saveMaintenance() {
        // Retrieve values from form fields and save the agent (similar to previous code)
        // ...

        // Clear form fields after saving
        clearFormFields();
    }

    private void readMaintenance() {
        // Implement logic to read an agent from the backend (e.g., by ID)
        // Update the form fields with the agent's details
    }

    private void updateMaintenance() {
        // Implement logic to update an agent's details in the backend
        // Typically, retrieve the agent by ID and update the properties
    }

    private void deleteMaintenance() {
        // Implement logic to delete an agent from the backend (e.g., by ID)
        // Remove the agent from the list and refresh the data provider
    }

    private void clearFormFields() {
        descriptionField.clear();
        requestIdField.clear();
        propertyIdField.clear();
        datePicker.clear();
    }



}

