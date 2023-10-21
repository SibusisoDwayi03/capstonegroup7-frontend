package com.example.application.views.main;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.spring.annotation.UIScope;
import com.vaadin.flow.theme.lumo.LumoUtility;

@PageTitle("Rental Real Estate Management")
@Route("home")
@UIScope
public class HomeView extends AppLayout {
    public HomeView(){
        createNavBar();
        addLinks();
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

    private void addLinks() {
        addToDrawer(new VerticalLayout(
                new RouterLink("Home", HomeView.class),
                new RouterLink("Agent", AgentFormView.class),
                new RouterLink("Application", ApplicationView.class),
                new RouterLink("Land lord", LandlordView.class),
                new RouterLink("Lease", LeaseView.class),
                new RouterLink("Maintenance", Maintenanceview.class),
                new RouterLink("Property", PropertyView.class ),
                new RouterLink("Tenant", TenantView.class)
        ));

        //Style menuStyle = addToDrawer().getStyle();
    }
}
