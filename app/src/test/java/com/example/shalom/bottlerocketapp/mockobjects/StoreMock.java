package com.example.shalom.bottlerocketapp.mockobjects;

import com.example.shalom.bottlerocketapp.service.model.Store;

public class StoreMock {

    public static final String MOCK_STREET = "7801 Citrus Park Town Center Mall";
    public static final String MOCK_CITY = "Tampa";
    public static final String MOCK_STATE = "FL";
    public static final String MOCK_ZIPCODE = "33625";
    public static final String MOCK_LONGITUDE = "-82.583401";
    public static final String MOCK_LATITUDE = "28.078152";
    public static final String MOCK_PHONE_NUMBER = "813-926-7302";
    public static final String MOCK_STORE_ID = "1238";

    public static Store generateStore() {
        Store store = new Store();
        store.setAddress(MOCK_STREET);
        store.setCity(MOCK_CITY);
        store.setState(MOCK_STATE);
        store.setZipcode(MOCK_ZIPCODE);
        store.setLongitude(MOCK_LONGITUDE);
        store.setLatitude(MOCK_LATITUDE);
        store.setPhone(MOCK_PHONE_NUMBER);
        store.setStoreID(MOCK_STORE_ID);

        return store;
    }
}
