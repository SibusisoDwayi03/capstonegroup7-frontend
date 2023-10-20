package com.example.application.views.main;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;

@Route(value = "application")
@UIScope
public class ApplicationView extends VerticalLayout {
    private TextField applicationId = new TextField("Application Id");
    private Checkbox bankStatement = new Checkbox("Bank statement");

    private Checkbox paySlip = new Checkbox("Pay slip");

    private TextField status = new TextField("Status");

    private TextField adress = new TextField("Address");

    private EmailField email = new EmailField("Email");

    private TextField contactNumber = new TextField("Contact number");

    private NumberField id = new NumberField("Id");

    private TextField firstName = new TextField("First name");

    private TextField lastName = new TextField("Last name");

    private DatePicker applicationDate = new DatePicker("Date of application");

    private TextField propertyId = new TextField("Property Id");

    private TextField tenantId = new TextField("Tenant Id");

    private Checkbox copyOfId = new Checkbox("Copy of Id");

    private TextField references = new TextField("References");

    private Button save = new Button("Save");

    private Button read = new Button("Read");

    private Button update = new Button("Update");

    private Button delete = new Button("Delete");

    private Button findAll = new Button("Get all");

    public ApplicationView(){
        applicationId.setPlaceholder("Auto generated application id");
        bankStatement.setLabel("Click if bank statement is true");
        paySlip.setLabel("Click if pay slip is true");
        status.setPlaceholder("Enter in the status");
        adress.setPlaceholder("Enter in address");
        email.setPlaceholder("Enter in email");
        contactNumber.setPlaceholder("Enter in contact number");
        id.setPlaceholder("Enter in id");
        firstName.setPlaceholder("Enter in first name");
        lastName.setPlaceholder("Enter in last name");
        applicationDate.setPlaceholder("Select the date of application");
        propertyId.setPlaceholder("Property id");
        tenantId.setPlaceholder("Tenant id");
        copyOfId.setLabel("Click if copy of id is true");
        references.setPlaceholder("Enter in references");



        HorizontalLayout buttonGroup = new HorizontalLayout();
        buttonGroup.add(save);
        buttonGroup.add(read);
        buttonGroup.add(update);
        buttonGroup.add(delete);
        buttonGroup.add(findAll);

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

        add(applicationId, bankStatement, paySlip, status, adress, email, contactNumber, id,
                firstName, lastName, applicationDate, propertyId, tenantId, copyOfId, references, buttonGroup);
    }
}
