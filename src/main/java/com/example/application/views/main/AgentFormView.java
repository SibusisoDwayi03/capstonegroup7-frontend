package com.example.application.views.main;

import com.example.application.domain.Agent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.Route;
import java.util.ArrayList;
import java.util.List;

@Route("agent-form")
public class AgentFormView extends VerticalLayout {
    private final TextField agentIdField = new TextField("Agent ID");
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

    private List<Agent> agents = new ArrayList<>();
    private ListDataProvider<Agent> agentDataProvider = new ListDataProvider<>(agents);

    public AgentFormView() {
        // Create a form layout and add form fields
        FormLayout formLayout = new FormLayout();
        formLayout.add(agentIdField, firstNameField, lastNameField, contactNumberField, emailField, passwordField, addressField);

        // Create a layout for buttons
        HorizontalLayout buttonLayout = new HorizontalLayout(saveButton, readButton, updateButton, deleteButton);
        buttonLayout.setSpacing(true);

        saveButton.addClickListener(event -> saveAgent());
        readButton.addClickListener(event -> readAgent());
        updateButton.addClickListener(event -> updateAgent());
        deleteButton.addClickListener(event -> deleteAgent());

        // Create a grid to display agents
        Grid<Agent> agentGrid = new Grid<>(Agent.class);
        agentGrid.setDataProvider(agentDataProvider);

//// Only add columns for the properties you want to display
//        agentGrid.addColumn("agentId").setHeader("Agent ID");
//        agentGrid.addColumn("firstName").setHeader("First Name");
//        agentGrid.addColumn("lastName").setHeader("Last Name");

        // Add the form layout, buttons, and grid to the view
        add(formLayout, buttonLayout, agentGrid);
    }

    private void saveAgent() {
        // Retrieve values from form fields and save the agent (similar to previous code)
        // ...

        // Clear form fields after saving
        clearFormFields();
    }

    private void readAgent() {
        // Implement logic to read an agent from the backend (e.g., by ID)
        // Update the form fields with the agent's details
    }

    private void updateAgent() {
        // Implement logic to update an agent's details in the backend
        // Typically, retrieve the agent by ID and update the properties
    }

    private void deleteAgent() {
        // Implement logic to delete an agent from the backend (e.g., by ID)
        // Remove the agent from the list and refresh the data provider
    }

    private void clearFormFields() {
        agentIdField.clear();
        firstNameField.clear();
        lastNameField.clear();
        contactNumberField.clear();
        emailField.clear();
        passwordField.clear();
        addressField.clear();
    }
}

