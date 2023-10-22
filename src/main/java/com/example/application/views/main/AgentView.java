package com.example.application.views.main;

import com.example.application.domain.Agent;
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
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Route(value = "agent", layout = HomeView.class)
@UIScope
public class AgentView extends VerticalLayout {
    private RestTemplate restTemplate;

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


    public AgentView(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        // Create a form layout and add form fields
        FormLayout formLayout = new FormLayout();
        formLayout.add(agentIdField, firstNameField, lastNameField, contactNumberField, emailField, passwordField, addressField);

        // Create a layout for buttons
        HorizontalLayout buttonGroup = new HorizontalLayout(saveButton, readButton, updateButton, deleteButton);
        buttonGroup.setSpacing(true);

        saveButton.addClickListener(event -> saveAgent());
        readButton.addClickListener(event -> readAgent());
        updateButton.addClickListener(event -> updateAgent());
        deleteButton.addClickListener(event -> deleteAgent());

        // Create a grid to display agents
        Grid<Agent> AgentGrid = new Grid<>(Agent.class);
        AgentGrid.setDataProvider(agentDataProvider);


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

        add(formLayout, buttonGroup, AgentGrid);

    }

    private void saveAgent() {
        Agent agent = new Agent(
                agentIdField.getValue(),
                firstNameField.getValue(),
                lastNameField.getValue(),
                contactNumberField.getValue(),
                emailField.getValue(),
                passwordField.getValue(),
                addressField.getValue()
        );

        try {
            ResponseEntity<Agent> response = restTemplate.postForEntity("http://localhost:50790/agents/save", agent, Agent.class);
            if (response.getStatusCode() == HttpStatus.CREATED) {
                Notification.show("Agent saved successfully");
                clearFormFields();
                readAgent(); // Optional: Refresh the grid after saving
            } else {
                Notification.show("Agent saved successfully");
            }
        } catch (RestClientException e) {
            Notification.show("Failed to save landlord");
        }
        clearFormFields();
    }

        private void readAgent() {
        try {
            Agent[] response = restTemplate.getForObject("http://localhost:50790/agents/all", Agent[].class);
            if (response != null) {
                agents.clear();
                agents.addAll(Arrays.asList(response));
                agentDataProvider.refreshAll();

            } else {
                Notification.show("No agents found");
            }
        } catch (RestClientException e) {
            Notification.show("Failed to retrieve agents from the server");
        }
    }

    private void updateAgent() {
        // Implement logic to update an agent's details in the backend
        // Typically, retrieve the agent by ID and update the properties
    }

    private void deleteAgent() {
        String agentId = agentIdField.getValue();
        if (agentId != null && !agentId.isEmpty()) {
            try {
                restTemplate.delete("http://localhost:50790/agents/delete/" + agentId);
                Notification.show("Agent deleted successfully");
                clearFormFields();
                //  readTenant();
            } catch (RestClientException e) {
                Notification.show("Agent to delete tenant");
            }
        } else {
            Notification.show("Agent ID is required to delete");
        }
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
