package com.example.shalom.bottlerocketapp;

import com.example.shalom.bottlerocketapp.mockobjects.StoreMock;
import com.example.shalom.bottlerocketapp.service.model.Store;
import com.example.shalom.bottlerocketapp.viewmodel.StoreDetailsViewModel;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StoreDetailsViewModelUnitTest {

    public StoreDetailsViewModel storeDetailsViewModel;

    @Before
    public void prepareStore() {
        storeDetailsViewModel = new StoreDetailsViewModel();
        //Get a Store instance
        Store store = StoreMock.generateStore();
        //Set ViewModel's store
        storeDetailsViewModel.setSelectedStore(store);
    }

    @Test
    public void correctStreetFormat() {
        //Given a Store

        //When a street address is return
        String street = storeDetailsViewModel.getStreet();

        //It should be the store's street as it was given
        assertThat(street, is(StoreMock.MOCK_STREET));
    }

    @Test
    public void correctCityStateZipcodeFormat() {
        //Expected output
        String expectedOutput = StoreMock.MOCK_CITY + ", " + StoreMock.MOCK_STATE + " " + StoreMock.MOCK_ZIPCODE;

        //Given a store

        //When a String containing the store's city, state, and zipcode is returned
        String cityStateZip = storeDetailsViewModel.getCityStateZipcode();

        //It should be returned in the correct format
        assertThat(cityStateZip, is(expectedOutput));
    }

    @Test
    public void correctCoordinatesFormat() {
        //Expected output
        String expectedOutput = StoreMock.MOCK_LONGITUDE + ", " + StoreMock.MOCK_LATITUDE;

        //Given a store

        //When a String containing the store's coordinates is returned
        String coordinates = storeDetailsViewModel.getCoordinates();

        //It should be returned in the correct format
        assertThat(coordinates, is(expectedOutput));
    }

    @Test
    public void correctPhoneNumberFormat() {
        //Expected output
        String expectedOutput = "Call: " + StoreMock.MOCK_PHONE_NUMBER;

        //Given a store

        //When a String containing the store's phone number is returned
        String phoneNumber = storeDetailsViewModel.getPhoneNumber();

        //It should be of the same format as it was supplied to the object
        assertThat(phoneNumber, is(expectedOutput));
    }

    @Test
    public void correctStoreIdFormat() {
        //Expected output
        String expectedOutput = "Store ID: " + StoreMock.MOCK_STORE_ID;
        //Given a store

        //When a String containing the store's ID is returned
        String storeId = storeDetailsViewModel.getStoreID();

        //It should be of the same format as it was supplied to the object
        assertThat(storeId, is(expectedOutput));
    }
}
