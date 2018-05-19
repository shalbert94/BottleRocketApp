package com.example.shalom.bottlerocketapp.service.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel //Allows Parceler to wrap this class
public class Store {

    @SerializedName("address")
    @Expose
    String address;
    @SerializedName("city")
    @Expose
    String city;
    @SerializedName("name")
    @Expose
    String name;
    @SerializedName("latitude")
    @Expose
    String latitude;
    @SerializedName("zipcode")
    @Expose
    String zipcode;
    @SerializedName("storeLogoURL")
    @Expose
    String storeLogoURL;
    @SerializedName("phone")
    @Expose
    String phone;
    @SerializedName("longitude")
    @Expose
    String longitude;
    @SerializedName("storeID")
    @Expose
    String storeID;
    @SerializedName("state")
    @Expose
    String state;


    public Store() {
    } //Empty constructor for Parceler

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getStoreLogoURL() {
        return storeLogoURL;
    }

    public void setStoreLogoURL(String storeLogoURL) {
        this.storeLogoURL = storeLogoURL;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getStoreID() {
        return storeID;
    }

    public void setStoreID(String storeID) {
        this.storeID = storeID;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}