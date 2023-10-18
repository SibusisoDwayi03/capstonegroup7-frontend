package com.example.application.views.main;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("form")
@Route("form")
public class MaintenaceFormView extends VerticalLayout {
    private Button addButton = new Button("Save");
    private Button viewButton = new Button("Read");
    private Button editButton = new Button("Update");
    private Button deleteButton = new Button("Delete");


    public MaintenaceFormView() {
        HorizontalLayout footerContainer = new HorizontalLayout(addButton,viewButton, editButton, deleteButton);
        footerContainer.addClassName("footer");
        add(footerContainer);

        Maintenance myForm = new Maintenance();
        add(myForm);



    }



}