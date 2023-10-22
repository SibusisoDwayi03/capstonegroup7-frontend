package com.example.application.views.main;

import com.example.application.domain.Property;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.List;

@Route(value = "property-view", layout = HomeView.class)
public class PropertyView extends VerticalLayout {
    public PropertyView() {
        // Create a list of property items
        List<Property> properties = new ArrayList<>();
        properties.add(new Property(
                "A cozy apartment in the heart of the city",
                1200.0,
                "icons/House.jpg",
                "123 Elm Street"
        ));
        properties.add(new Property(
                "Spacious family home with a beautiful garden",
                2500.0,
                "icons/garden.jpg",
                "456 Oak Avenue"
        ));
        properties.add(new Property(
                "2 Bedrooms,Outdoor Swimming Pool,2 Bathroom and a Laundry,",
                1800.0,
                "icons/condo.jpg",
                "789 Pine Road"
        ));

        // Create a Grid to display the properties
        Grid<Property> propertyGrid = new Grid<>(Property.class);
        propertyGrid.setItems(properties);

        // Define the columns for the Grid
        propertyGrid.setColumns("description", "rentAmount", "address");

        // Create a ComponentRenderer for the image column
        propertyGrid.addComponentColumn(property -> {
            Image image = new Image(property.getPictureUrl(), "Property Image");
            image.setMaxWidth("400px"); // Limit the image width
            return image;
        }).setHeader("Image");

        // Add the Grid to the layout
        add(propertyGrid);
    }
}


