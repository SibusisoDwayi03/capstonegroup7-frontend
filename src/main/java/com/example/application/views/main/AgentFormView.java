package com.example.application.views.main;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

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

    public AgentFormView() {
        // Create a form layout and add form fields
        FormLayout formLayout = new FormLayout();
        formLayout.add(agentIdField, firstNameField, lastNameField, contactNumberField, emailField, passwordField, addressField);


        formLayout.add(saveButton);

        // Define form functionality here,saving the agent details
        saveButton.addClickListener(event -> saveAgent());

        // Add the form layout to the view
        add(formLayout);
    }

    private void saveAgent() {
        // Retrieve values from form fields and save the agent
        String agentId = agentIdField.getValue();
        String firstName = firstNameField.getValue();
        String lastName = lastNameField.getValue();
        String contactNumber = contactNumberField.getValue();
        String email = emailField.getValue();
        String password = passwordField.getValue();
        String address = addressField.getValue();

        // Create an Agent object and send it to the backend using AgentService
//        Agent agent = new Agent(agentId, firstName, lastName, contactNumber, email, password, address);
//        AgentService agentService = new AgentService(); // Implement AgentService to send data to the backend
//        agentService.saveAgent(agent);
    }
}

