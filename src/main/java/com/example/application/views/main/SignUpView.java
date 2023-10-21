package com.example.application.views.main;


import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.RouterLink;

@Route("signup")
@PageTitle("Signup")
public class SignUpView extends VerticalLayout {

    public SignUpView() {
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        // Create a title for the page
        H2 title = new H2("Sign Up With User Role");

        // Create a container to center the content
        Div container = new Div();
        container.addClassName("center-container");

        // Create a RadioButtonGroup for role selection
        RadioButtonGroup<String> roleSelection = new RadioButtonGroup<>();
        roleSelection.setItems("Agent", "Landlord", "Tenant");
        roleSelection.setLabel("*Select Your Role");

        // Add a value change listener to respond when a role is selected
        roleSelection.addValueChangeListener(event -> {
            String selectedRole = event.getValue();
            if (selectedRole != null) {
                // Handle role selection (e.g., navigate to a role-specific signup form)
                // You can use Vaadin's Page or Router to navigate to the relevant views
                switch (selectedRole) {
                    case "Agent":
                        // Navigate to Agent signup view
                        getUI().ifPresent(ui -> ui.navigate("agent-form"));
                        RouterLink agentFormlink = new RouterLink("AgentView ", AgentFormView.class);
                        agentFormlink.addClassName("landing-button");
                        break;
                    case "Landlord":
                        // Navigate to Landlord signup view
                        getUI().ifPresent(ui -> ui.navigate("landlord"));
                        RouterLink LandlordView = new RouterLink("LandlordView ", SignUpView.class);
                        LandlordView.addClassName("landing-button");

                        break;
                    case "Tenant":
                        // Navigate to Tenant signup view
                        getUI().ifPresent(ui -> ui.navigate("Tenant"));
                        RouterLink TenantView = new RouterLink("TenantView ", SignUpView.class);
                        TenantView.addClassName("landing-button");
                        break;
                }
            }
        });

        container.add(title, roleSelection);
        container.addClassName("centered-content");
        add(container);
    }
}
