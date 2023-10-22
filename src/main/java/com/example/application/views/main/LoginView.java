package com.example.application.views.main;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.spring.annotation.UIScope;

@Route(value = "login")
@UIScope
@AnonymousAllowed
public class LoginView extends VerticalLayout {

    private TextField usernameField = new TextField("Username");
    private PasswordField passwordField = new PasswordField("Password");
    private Button loginButton = new Button("Login");

    public LoginView() {
        configureComponents();
        buildLayout();
        applyStyles();
        loginButton.addClickListener(event -> login());
    }

    private void configureComponents() {
        loginButton.addClickListener(event -> login());
    }

    private void buildLayout() {
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
        setSizeFull();

        add(usernameField, passwordField, loginButton);
    }

    private void applyStyles() {
        getStyle().set("background-color", "#F5F5F5");
        getStyle().set("color", "#000");

        // Apply additional styles to your components if needed
        usernameField.getStyle().set("background-color", "#FFF"); // Input field background color
        passwordField.getStyle().set("background-color", "#FFF");
        loginButton.getStyle().set("background-color", "#000"); // Button background color
        loginButton.getStyle().set("color", "#FFF"); // Button text color
    }

    private void login() {
        UI.getCurrent().navigate("home");
    }

    private boolean isValidLogin(String username, String password) {
        // You should implement logic to check if the login is valid in your service.
        //  you can make a REST API call to your backend.
        return true;
    }
}

