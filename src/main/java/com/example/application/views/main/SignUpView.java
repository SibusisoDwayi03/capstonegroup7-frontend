package com.example.application.views.main;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.router.Route;

@Route("signup")
public class SignUpView extends VerticalLayout {

    public SignUpView() {
        // Create a form layout to organize the input fields
        FormLayout formLayout = new FormLayout();

        // Create text fields for user input
        TextField usernameField = new TextField("Username");
        TextField userIdField = new TextField("User ID");
        EmailField emailField = new EmailField("Email");
        PasswordField passwordField = new PasswordField("Password");

        // Create a sign-up button
        Button signUpButton = new Button("Sign Up");

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
}

