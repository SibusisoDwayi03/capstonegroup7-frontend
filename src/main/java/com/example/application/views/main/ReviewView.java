package com.example.application.views.main;


import com.example.application.domain.Landlord;
import com.example.application.domain.Review;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.router.Route;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Route(value = "reviews", layout = HomeView.class)
public class ReviewView extends VerticalLayout {
    private RestTemplate restTemplate;


    private TextField reviewIdField = new TextField("Review ID");
    private TextField propertyIdField = new TextField("Property ID");
    private TextField tenantIdField = new TextField("Tenant ID");
    private TextField ratingField = new TextField("Rating");
    private TextField commentField = new TextField("Comment");
    private final Button saveButton = new Button("Save");
    private final Button readButton = new Button("Read");
    private final Button updateButton = new Button("Update");
    private final Button deleteButton = new Button("Delete");

    private List<Review> reviews = new ArrayList<>();
    private ListDataProvider<Review> reviewDataProvider = new ListDataProvider<>(reviews);


    public ReviewView(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;

        H2 heading = new H2("Review form:");

        Style headingStyle = heading.getStyle();
        headingStyle.set("margin-left", "auto");
        headingStyle.set("margin-right", "auto");

        // Create a form layout and add form fields
        FormLayout formLayout = new FormLayout();
        formLayout.add(reviewIdField, propertyIdField, tenantIdField, ratingField, commentField);

        // Create a layout for buttons
        HorizontalLayout buttonGroup = new HorizontalLayout(saveButton, readButton, updateButton, deleteButton);
        buttonGroup.setSpacing(true);

        saveButton.addClickListener(event -> saveReview());
        readButton.addClickListener(event -> readReview());
        updateButton.addClickListener(event -> updateReview());
        deleteButton.addClickListener(event -> deleteReview());

        // Create a grid to display agents
        Grid<Review> ReviewGrid = new Grid<>(Review.class);
        ReviewGrid.setDataProvider(reviewDataProvider);


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

        add(heading, formLayout, buttonGroup, ReviewGrid);

    }

    private void saveReview() {
        Review review = new Review(
                reviewIdField.getValue(),
                propertyIdField.getValue(),
                tenantIdField.getValue(),
                ratingField.getValue(),
                commentField.getValue()
        );

        try {
            ResponseEntity<Review> response = restTemplate.postForEntity("http://localhost:50790/reviews/save", review, Review.class);
            if (response.getStatusCode() == HttpStatus.CREATED) {
                Notification.show("Review saved successfully");
                clearFormFields();
                readReview(); // Optional: Refresh the grid after saving
            } else {
                Notification.show("Review saved successfully");
            }
        } catch (RestClientException e) {
            Notification.show("Failed to save review");
        }
        clearFormFields();
    }



    private void readReview() {
        try {
            Review[] response = restTemplate.getForObject("http://localhost:50790/reviews/all", Review[].class);
            if (response != null) {
                reviews.clear();
                reviews.addAll(Arrays.asList(response));
                reviewDataProvider.refreshAll();

            } else {
                Notification.show("No reviews found");
            }
        } catch (RestClientException e) {
            Notification.show("Failed to retrieve reviews from the server");
        }
    }

    private void updateReview() {
        // Implement logic to update an agent's details in the backend
        // Typically, retrieve the agent by ID and update the properties
    }

    private void deleteReview() {
        String reviewId = reviewIdField.getValue();
        if (reviewId != null && !reviewId.isEmpty()) {
            try {
                restTemplate.delete("http://localhost:50790/reviews/delete/" + reviewId);
                Notification.show("Review deleted successfully");
                clearFormFields();
                //  readTenant();
            } catch (RestClientException e) {
                Notification.show("Failed to delete tenant");
            }
        } else {
            Notification.show("Review ID is required to delete");
        }
    }

    private void clearFormFields() {
        reviewIdField.clear();
        propertyIdField.clear();
        tenantIdField.clear();
        ratingField.clear();
        commentField.clear();
    }
}
