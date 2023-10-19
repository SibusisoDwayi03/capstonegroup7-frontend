package com.example.application.views.main;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.Component;


@Route("property")
public class PropertyTableView extends VerticalLayout {

    public PropertyTableView() {
        Grid<Object[]> textGrid = new Grid<>();
        textGrid.setItems(
                new Object[]{"images/property1.jpg", "10 Dorset Street", "R120000"},
                new Object[]{"images/property2.jpg", "21878 Chinaberry Court", "R12000"}
        );

        textGrid.addColumn(this::createImageComponent).setHeader("Property Image");
        textGrid.addColumn(item -> " " + item[1]).setHeader("Address");
        textGrid.addColumn(item -> " " + item[2]).setHeader("Rent Amount");

        add(textGrid);
    }

    private Component createImageComponent(Object[] item) {
        Image image = new Image((String) item[0], "Property Image");
        Text addressText = new Text((String) item[1]);
        VerticalLayout imageLayout = new VerticalLayout(image, addressText);
        return imageLayout;
    }
}


