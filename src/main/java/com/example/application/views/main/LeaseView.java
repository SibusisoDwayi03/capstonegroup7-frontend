package com.example.application.views.main;

import com.example.application.domain.Landlord;
import com.example.application.domain.Lease;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@PageTitle("lease")
@Route(value = "lease", layout = HomeView.class)
@UIScope
public class LeaseView extends VerticalLayout {
    private RestTemplate restTemplate;

    private TextField leaseId = new TextField("Lease Id");

    private TextField terms = new TextField("Terms");

    private DatePicker startDate = new DatePicker("Start date");

    private DatePicker endDate = new DatePicker("End date");

    private Button save = new Button("Save");

    private Button read = new Button("Read");

    private Button update = new Button("Update");

    private Button delete = new Button("Delete");

    private Button findAll = new Button("Get all");
    private List<Lease> leases = new ArrayList<>();
    private ListDataProvider<Lease> leaseDataProvider = new ListDataProvider<>(leases);

    public LeaseView() {
        this.restTemplate = restTemplate;
        // Create a form layout and add form fields
        FormLayout formLayout = new FormLayout();
        formLayout.add(leaseId, terms, startDate, endDate);

        // Create a layout for buttons
//        HorizontalLayout buttonGroup = new HorizontalLayout(save, read, update, delete,findAll);
//        buttonGroup.setSpacing(true);

        save.addClickListener(event -> saveLease());
        read.addClickListener(event -> readLease());
       // update.addClickListener(event -> updateLease());
        delete.addClickListener(event -> deleteLease());
        findAll.addClickListener(event -> findAllLease());

        // Create a grid to display agents
        Grid<Lease> LeaseGrid = new Grid<>(Lease.class);
        LeaseGrid.setDataProvider(leaseDataProvider);

        leaseId.setPlaceholder("Auto generated lease id");
        terms.setPlaceholder("Enter in the terms");
        startDate.setPlaceholder("Select the start date");
        endDate.setPlaceholder("Select the end date");

        Style leaseIdStyle = leaseId.getStyle();
        leaseIdStyle.set("margin-left", "auto");
        leaseIdStyle.set("margin-right", "auto");
        leaseIdStyle.setTextAlign(Style.TextAlign.CENTER);

        Style termsStyle = terms.getStyle();
        termsStyle.set("margin-left", "auto");
        termsStyle.set("margin-right", "auto");

        Style startDateStyle = startDate.getStyle();
        startDateStyle.set("margin-left", "auto");
        startDateStyle.set("margin-right", "auto");

        Style endDateStyle = endDate.getStyle();
        endDateStyle.set("margin-left", "auto");
        endDateStyle.set("margin-right", "auto");

        HorizontalLayout buttonGroup = new HorizontalLayout();
        buttonGroup.add(save);
        buttonGroup.add(read);
        buttonGroup.add(update);
        buttonGroup.add(delete);
        buttonGroup.add(findAll);

        H2 heading = new H2("Lease form:");

        Style headingStyle = heading.getStyle();
        headingStyle.set("margin-left", "auto");
        headingStyle.set("margin-right", "auto");

        Style bgs = buttonGroup.getStyle();
        bgs.set("margin-left", "auto");
        bgs.set("margin-right", "auto");

        Style bg = save.getStyle();
        bg.set("margin-left", "auto");
        bg.set("margin-right", "auto");
        bg.set("color", "white");
        bg.set("background-color", "Black");
        bg.set("border-radius", "8px");

        Style bg2 = read.getStyle();
        bg2.set("margin-left", "auto");
        bg2.set("margin-right", "auto");
        bg2.set("color", "white");
        bg2.set("background-color", "Black");
        bg2.set("border-radius", "8px");

        Style bg3 = update.getStyle();
        bg3.set("margin-left", "auto");
        bg3.set("margin-right", "auto");
        bg3.set("color", "white");
        bg3.set("background-color", "Black");
        bg3.set("border-radius", "8px");

        Style bg4 = delete.getStyle();
        bg4.set("margin-left", "auto");
        bg4.set("margin-right", "auto");
        bg4.set("color", "white");
        bg4.set("background-color", "Black");
        bg4.set("border-radius", "8px");

        Style bg5 = findAll.getStyle();
        bg5.set("margin-left", "auto");
        bg5.set("margin-right", "auto");
        bg5.set("color", "white");
        bg5.set("background-color", "Black");
        bg5.set("border-radius", "8px");

        add(heading, formLayout, buttonGroup, LeaseGrid);
    }

        private void saveLease () {
            Lease lease = new Lease(
                    leaseId.getValue(),
                    terms.getValue(),
                    startDate.getValue(),
                    endDate.getValue()
            );

            try {
                ResponseEntity<Lease> response = restTemplate.postForEntity("http://localhost:50790/leases/save", lease, Lease.class);
                if (response.getStatusCode() == HttpStatus.CREATED) {
                    Notification.show("Lease saved successfully");
                    clearFormFields();
                    readLease(); // Optional: Refresh the grid after saving
                } else {
                    Notification.show("Lease saved successfully");
                }
            } catch (RestClientException e) {
                Notification.show("Failed to save lease");
            }
            clearFormFields();
        }
        private void findAllLease () {
            try {
                Lease[] response = restTemplate.getForObject("http://localhost:50790/leases/all", Lease[].class);
                if (response != null) {
                    leases.clear();
                    leases.addAll(Arrays.asList(response));
                    leaseDataProvider.refreshAll();
                } else {
                    Notification.show("No leases found");
                }
            } catch (RestClientException e) {
                Notification.show("Failed to retrieve leases from the server");
            }
        }
    private void readLease () {
        try {
            Lease[] response = restTemplate.getForObject("http://localhost:50790/leases/read/{{leaseId}}", Lease[].class);
            if (response != null) {
                leases.clear();
                leases.addAll(Arrays.asList(response));
                leaseDataProvider.refreshAll();

            } else {
                Notification.show("No leases found");
            }
        } catch (RestClientException e) {
            Notification.show("Failed to retrieve leases from the server");
        }
    }

        private void updateLandlord () {
            // Implement logic to update an agent's details in the backend
            // Typically, retrieve the agent by ID and update the properties
        }

        private void deleteLease () {
            String leaseIdValue = leaseId.getValue();
            if (leaseId != null && !leaseId.isEmpty()) {
                try {
                    restTemplate.delete("http://localhost:50790/leases/delete/" + leaseIdValue);
                    Notification.show("Lease deleted successfully");
                    clearFormFields();
                    //  readTenant();
                } catch (RestClientException e) {
                    Notification.show("Failed to delete lease");
                }
            } else {
                Notification.show("Lease ID is required to delete");
            }
        }

        private void clearFormFields () {
            leaseId.clear();
            terms.clear();
            startDate.clear();
            endDate.clear();
        }
    }

