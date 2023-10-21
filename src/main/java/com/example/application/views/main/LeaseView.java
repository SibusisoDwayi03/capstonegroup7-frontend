package com.example.application.views.main;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;

@PageTitle("lease")
@Route(value = "lease", layout = HomeView.class)
@UIScope
public class LeaseView extends VerticalLayout {
    private TextField leaseId = new TextField("Lease Id");

    private TextField terms = new TextField("Terms");

    private DatePicker startDate = new DatePicker("Start date");

    private DatePicker endDate = new DatePicker("End date");

    private Button save = new Button("Save");

    private Button read = new Button("Read");

    private Button update = new Button("Update");

    private Button delete = new Button("Delete");

    private Button findAll = new Button("Get all");

    public LeaseView() {
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

        // Functionality for buttons.
        save.addClickListener(e ->{

        });

        read.addClickListener(e ->{

        });

        update.addClickListener(e ->{

        });

        delete.addClickListener(e ->{

        });

        findAll.addClickListener(e ->{

        });

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

        add(leaseId, terms, startDate, endDate, buttonGroup);
    }
}
