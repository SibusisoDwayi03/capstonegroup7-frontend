package com.example.application.views.main;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.spring.annotation.UIScope;
import com.vaadin.flow.theme.lumo.LumoUtility;

@PageTitle("Home")
@Route(value = "home")
@UIScope
public class HomeView extends AppLayout {
    public HomeView(){
        createNavBar();
        navlinks();

        H2 heading = new H2("Home:");

        Style headingStyle = heading.getStyle();
        headingStyle.set("margin-left", "auto");
        headingStyle.set("margin-right", "auto");


    }

    private void createNavBar(){
        H1 rental = new H1("Rental Real Estate Management");
        rental.addClassNames(
                LumoUtility.FontSize.LARGE,
                LumoUtility.Margin.AUTO);

        var header = new HorizontalLayout(new DrawerToggle(), rental);

        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        header.setWidthFull();
        header.addClassNames(
                LumoUtility.Padding.Vertical.NONE,
                LumoUtility.Padding.Horizontal.MEDIUM);
        addToNavbar(header);
    }

    private void navlinks() {
        VerticalLayout links = new VerticalLayout();
        RouterLink homeLink = new RouterLink("", HomeView.class);
        homeLink.add(new Button("Home", VaadinIcon.HOME.create()));

        RouterLink agentLink = new RouterLink("", AgentFormView.class);
        agentLink.add(new Button("Agent", VaadinIcon.USER.create()));

        RouterLink applicationLink = new RouterLink("", ApplicationView.class);
        applicationLink.add(new Button("Application", VaadinIcon.ANCHOR.create()));

        RouterLink landLordLink = new RouterLink("", LandlordView.class);
        landLordLink.add(new Button("Landlord", VaadinIcon.CALENDAR_USER.create()));

        RouterLink leaseLink = new RouterLink("", LeaseView.class);
        leaseLink.add(new Button("Lease", VaadinIcon.CONNECT.create()));

        RouterLink maintenanceLink = new RouterLink("", Maintenanceview.class);
        maintenanceLink.add(new Button("Maintenance", VaadinIcon.WRENCH.create()));

        RouterLink propertyLink = new RouterLink("", PropertyView.class );
        propertyLink.add(new Button("Property", VaadinIcon.HOME_O.create()));

        RouterLink tenantLink = new RouterLink("", TenantView.class);
        tenantLink.add(new Button("Tenant", VaadinIcon.USER_CHECK.create()));

        links.add(homeLink, agentLink, applicationLink, landLordLink, leaseLink, maintenanceLink, propertyLink, tenantLink);

        addToDrawer(links);
    }
}
