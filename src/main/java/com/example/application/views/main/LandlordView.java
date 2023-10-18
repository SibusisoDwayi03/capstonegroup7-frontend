package com.example.application.views.main;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("myform")
public class LandlordView extends VerticalLayout {
    private Button addButton = new Button("Save");
    private Button viewButton = new Button("Read");
    private Button editButton = new Button("Update");
    private Button deleteButton = new Button("Delete");

    public LandlordView() {
        HorizontalLayout footerContainer = new HorizontalLayout(addButton,viewButton, editButton, deleteButton);
        footerContainer.addClassName("footer");
        add(footerContainer);

        LandlordForm myForm = new LandlordForm();
        add(myForm);
    }
}


