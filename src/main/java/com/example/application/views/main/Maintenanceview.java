package com.example.application.views.main;

import com.example.application.domain.Landlord;
import com.example.application.domain.Maintenance;
import com.example.application.domain.Tenant;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Route(value = "maintenance", layout = HomeView.class)
public class Maintenanceview extends VerticalLayout {

    private RestTemplate restTemplate;
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

    public Maintenanceview(RestTemplate restTemplate) {

        this.restTemplate = restTemplate;


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

        Style bg5 = submitButton.getStyle();
        bg5.set("margin-left", "auto");
        bg5.set("margin-right", "auto");
        bg5.set("color", "white");
        bg5.set("background-color", "Black");
        bg5.set("border-radius", "8px");

        add(formLayout, buttonLayout, maintenanceGrid);
    }

    private void saveMaintenance() {
        Maintenance maintenance = new Maintenance(
                descriptionField.getValue(),
                propertyIdField.getValue(),
                requestIdField.getValue(),
                datePicker.getValue()
        );

        try {
            ResponseEntity<Maintenance> response = restTemplate.postForEntity("http://localhost:50790/maintenancies/save", maintenance, Maintenance.class);
            if (response.getStatusCode() == HttpStatus.CREATED) {
                Notification.show("Maintanance saved successfully");
                clearFormFields();
                readMaintenance(); // Optional: Refresh the grid after saving
            } else {
                Notification.show("Maintanance saved successfully");
            }
        } catch (RestClientException e) {
            Notification.show("Maintanance to save landlord");
        }
        clearFormFields();
    }

    private void readMaintenance() {
        try {
            Maintenance[] response = restTemplate.getForObject("http://localhost:50790/maintenancies/all", Maintenance[].class);
            if (response != null) {
                maintenances.clear();
                maintenances.addAll(Arrays.asList(response));
                maintenanceDataProvider.refreshAll();

            } else {
                Notification.show("No maintenancies found");
            }
        } catch (RestClientException e) {
            Notification.show("Failed to retrieve maintenancies from the server");
        }
    }

    private void updateMaintenance() {
        // Implement logic to update an agent's details in the backend
        // Typically, retrieve the agent by ID and update the properties
    }

    private void deleteMaintenance() {
        String requestId = requestIdField.getValue();
        if (requestId != null && !requestId.isEmpty()) {
            try {
                restTemplate.delete("http://localhost:50790/maintenancies/delete/" + requestId);
                Notification.show("Maintenance deleted successfully");
                clearFormFields();
            } catch (RestClientException e) {
                Notification.show("failed to delete maintenance");
            }
        } else {
            Notification.show("request ID is required to delete");
        }
    }

    private void clearFormFields() {
        descriptionField.clear();
        requestIdField.clear();
        propertyIdField.clear();
        datePicker.clear();
    }

}

