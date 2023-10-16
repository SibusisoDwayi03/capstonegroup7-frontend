package com.example.application.views.main;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

@Route("")
@PageTitle("Real Estate Management System")
@UIScope
@StyleSheet("mytodo/styles.css") // Link to  CSS file

//@Theme( variant = Lumo.LIGHT)
public class LandingPage extends VerticalLayout {

    public LandingPage() {
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        setHeight("100vh");
        setSpacing(false);

        H1 title = new H1("Real Estate Management System");
        title.addClassName("landing-title");

        // Create a RouterLink to navigate to the LoginView
        RouterLink loginLink = new RouterLink("Login", LoginView.class);
        loginLink.addClassName("landing-button");

//        Button loginButton = new Button("Login");
//        loginButton.addClassName("landing-button");

        Button signUpButton = new Button("Sign Up");
        signUpButton.addClassName("landing-button");

        add(title, loginLink, signUpButton);

        addClassName("landing-page"); // Add a class name to the LandingPage
    }
    }



