package com.example.application.views.main;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.textfield.TextFieldVariant;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;

@Route(value = "application", layout = HomeView.class)
@UIScope
public class ApplicationView extends VerticalLayout {
    // Creating and instantiating variables for components.
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
        // Adds place holders for the various fields.
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

        // Styles the various field components.
        Style applicationIdStyle = applicationId.getStyle();
        applicationIdStyle.set("margin-left", "auto");
        applicationIdStyle.set("margin-right", "auto");
        applicationIdStyle.setWidth("auto");
        //applicationIdStyle.setTextAlign(Style.TextAlign.CENTER);

        Style bankStatementStyle = bankStatement.getStyle();
        bankStatementStyle.set("margin-left", "auto");
        bankStatementStyle.set("margin-right", "auto");

        Style paySlipStyle = paySlip.getStyle();
        paySlipStyle.set("margin-left", "auto");
        paySlipStyle.set("margin-right", "auto");

        Style statusStyle = status.getStyle();
        statusStyle.set("margin-left", "auto");
        statusStyle.set("margin-right", "auto");

        Style adressStyle = adress.getStyle();
        adressStyle.set("margin-left", "auto");
        adressStyle.set("margin-right", "auto");

        Style emailStyle = email.getStyle();
        emailStyle.set("margin-left", "auto");
        emailStyle.set("margin-right", "auto");

        Style contactNumberStyle = contactNumber.getStyle();
        contactNumberStyle.set("margin-left", "auto");
        contactNumberStyle.set("margin-right", "auto");

        Style idStyle = id.getStyle();
        idStyle.set("margin-left", "auto");
        idStyle.set("margin-right", "auto");

        Style firstNameStyle = firstName.getStyle();
        firstNameStyle.set("margin-left", "auto");
        firstNameStyle.set("margin-right", "auto");

        Style lastNameStyle = lastName.getStyle();
        lastNameStyle.set("margin-left", "auto");
        lastNameStyle.set("margin-right", "auto");

        Style applicationDateStyle = applicationDate.getStyle();
        applicationDateStyle.set("margin-left", "auto");
        applicationDateStyle.set("margin-right", "auto");

        Style propertyIdStyle = propertyId.getStyle();
        propertyIdStyle.set("margin-left", "auto");
        propertyIdStyle.set("margin-right", "auto");

        Style tenantIdStyle = tenantId.getStyle();
        tenantIdStyle.set("margin-left", "auto");
        tenantIdStyle.set("margin-right", "auto");

        Style copyOfIdStyle = copyOfId.getStyle();
        copyOfIdStyle.set("margin-left", "auto");
        copyOfIdStyle.set("margin-right", "auto");

        Style referencesStyle = references.getStyle();
        referencesStyle.set("margin-left", "auto");
        referencesStyle.set("margin-right", "auto");

        // This styles the components to be centered.
        applicationId.addThemeVariants(TextFieldVariant.LUMO_ALIGN_CENTER);

        // Creating a horizontal layout and adding buttons to the layout.
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

        // Styles the various button components.
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

        // This adds the components to the web page.
        add(applicationId, bankStatement, paySlip, status, adress, email, contactNumber, id,
                firstName, lastName, applicationDate, propertyId, tenantId, copyOfId, references, buttonGroup);
    }
}
