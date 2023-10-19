package com.example.application.views.main;

import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;

@PageTitle("Lease")
@Route("lease")
@UIScope
public class LeaseView extends VerticalLayout {
    private TextField leaseId = new TextField("Lease Id");

    private TextField terms = new TextField("Terms");

    private DatePicker startDate = new DatePicker("Start date");

    private DatePicker endDate = new DatePicker("End date");

    public LeaseView(){
        leaseId.setPlaceholder("Enter a lease Id");
        terms.setPlaceholder("Enter in the terms");
        startDate.setPlaceholder("Select the start date");
        endDate.setPlaceholder("Select the end date");

        Style leaseIdStyle = leaseId.getStyle();
        leaseIdStyle.set("margin-left","auto");
        leaseIdStyle.set("margin-right","auto");
        leaseIdStyle.setTextAlign(Style.TextAlign.CENTER);

        Style termsStyle = terms.getStyle();
        termsStyle.set("margin-left","auto");
        termsStyle.set("margin-right","auto");

        Style startDateStyle = startDate.getStyle();
        startDateStyle.set("margin-left","auto");
        startDateStyle.set("margin-right","auto");

        Style endDateStyle = endDate.getStyle();
        endDateStyle.set("margin-left","auto");
        endDateStyle.set("margin-right","auto");

        this.add(leaseId);
        this.add(terms);
        this.add(startDate);
        this.add(endDate);
    }
}
