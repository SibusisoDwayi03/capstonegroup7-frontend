package com.example.application.domain;

public class Property {
    private String description;
    private double rentAmount;
    private String pictureUrl;
    private String address;

    public Property(String description, double rentAmount, String pictureUrl, String address) {
        this.description = description;
        this.rentAmount = rentAmount;
        this.pictureUrl = pictureUrl;
        this.address = address;
    }

    // Getters and setters for the properties

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRentAmount() {
        return rentAmount;
    }

    public void setRentAmount(double rentAmount) {
        this.rentAmount = rentAmount;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
