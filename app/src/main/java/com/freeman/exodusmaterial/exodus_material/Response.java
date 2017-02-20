package com.freeman.exodusmaterial.exodus_material;

/**
 * Created by Freeman on 11.02.2017.
 */

public class Response {
    private String category;
    private String region;
    private String city;
    private String address;
    private String organisationName;
    private String phoneNumber;

    public Response() {
    }

    public Response(String category, String region, String city, String address, String organisationName, String phoneNumber) {
        this.category = category;
        this.region = region;
        this.city = city;
        this.address = address;
        this.organisationName = organisationName;
        this.phoneNumber = phoneNumber;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOrganisationName() {
        return organisationName;
    }

    public void setOrganisationName(String organisationName) {
        this.organisationName = organisationName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Response{" +
                "category='" + category + '\'' +
                ", region='" + region + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", organisationName='" + organisationName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
