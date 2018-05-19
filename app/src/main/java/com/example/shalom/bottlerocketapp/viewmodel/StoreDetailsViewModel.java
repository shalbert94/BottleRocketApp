package com.example.shalom.bottlerocketapp.viewmodel;

import android.arch.lifecycle.ViewModel;

import com.example.shalom.bottlerocketapp.service.model.Store;

public class StoreDetailsViewModel extends ViewModel {
    public static final String BUNDLED_STORE_KEY = "STORE";

    private Store selectedStore;

    public Store getSelectedStore() {
        return selectedStore;
    }

    public void setSelectedStore(Store selectedStore) {
        this.selectedStore = selectedStore;
    }

    public String getStoreLogoURL() {
        return selectedStore.getStoreLogoURL();
    }

    public String getStreet() {
        String street = selectedStore.getAddress();

        return street;
    }

    public String getCityStateZipcode() {
        String city = selectedStore.getCity();
        String state = selectedStore.getState();
        String zipCode = selectedStore.getZipcode();

        return city + ", " + state + " " + zipCode;
    }

    public String getCoordinates() {
        String longitude = selectedStore.getLongitude();
        String latitude = selectedStore.getLatitude();

        return longitude + ", " + latitude;
    }

    public String getPhoneNumber() {
        String phoneNumber = selectedStore.getPhone();

        return "Call: " + phoneNumber;
    }

    public String getStoreID() {
        String storeID = selectedStore.getStoreID();

        return "Store ID: " + storeID;
    }

}
