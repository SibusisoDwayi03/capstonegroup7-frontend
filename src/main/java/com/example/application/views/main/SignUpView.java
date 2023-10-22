package com.example.application.views.main;


import com.example.application.domain.Landlord;
import com.example.application.domain.User;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.router.Route;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Route("signup")
public class SignUpView extends VerticalLayout {
    private RestTemplate restTemplate;
    // Create a form layout to organize the input fields
    FormLayout formLayout = new FormLayout();

    // Create text fields for user input
    TextField usernameField = new TextField("Username");
    TextField userIdField = new TextField("User ID");
    EmailField emailField = new EmailField("Email");
    PasswordField passwordField = new PasswordField("Password");

    // Create a sign-up button
    Button signUpButton = new Button("Sign Up");
    public SignUpView() {

        signUpButton.addClickListener(event -> saveUser());

        // Add fields and button to the form layout
        formLayout.add(usernameField, userIdField, emailField, passwordField, signUpButton);

        // Add the form layout to the view
        add(formLayout);

        Style bg5 = signUpButton.getStyle();
        bg5.set("margin-left", "auto");
        bg5.set("margin-right", "auto");
        bg5.set("color", "white");
        bg5.set("background-color", "Black");
        bg5.set("border-radius", "8px");
    }
    private void saveUser() {
        User user = new User(
                usernameField.getValue(),
                userIdField.getValue(),
                emailField.getValue(),
                passwordField.getValue()

        );
        try {
            ResponseEntity<User> response = restTemplate.postForEntity("http://localhost:50790/users/save", user, User.class);
            if (response.getStatusCode() == HttpStatus.CREATED) {
                Notification.show("User saved successfully");
                clearFormFields();
            } else {
                Notification.show("User saved successfully");
            }
        } catch (RestClientException e) {
            Notification.show("Failed to save USer");
        }
        clearFormFields();
    }
    private void clearFormFields() {
        userIdField.clear();
        userIdField.clear();
        emailField.clear();
        passwordField.clear();
    }
}

