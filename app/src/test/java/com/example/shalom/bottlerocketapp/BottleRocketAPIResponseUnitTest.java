package com.example.shalom.bottlerocketapp;

import com.example.shalom.bottlerocketapp.service.model.BottleRocketAPIResponse;
import com.example.shalom.bottlerocketapp.service.model.Store;
import com.example.shalom.bottlerocketapp.service.model.Stores;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class BottleRocketAPIResponseUnitTest {

    @Test
    public void responseType_succesfulResponse() {
        //Given a Stores instance
        Stores stores = new Stores();
        BottleRocketAPIResponse bottleRocketAPIResponse = new BottleRocketAPIResponse(stores);

        //When responseType is returned from BottleRocketAPIResponse
        int responseType = bottleRocketAPIResponse.getResponseType();

        //Then responseType should be the expected one
        assertThat(responseType, is(BottleRocketAPIResponse.SUCCESSFUL_RESPONSE));
    }

    @Test
    public void responseType_requestError() {
        //Given an int
        int requestError = 1; //If request error is 0, there wasn't an error
        BottleRocketAPIResponse bottleRocketAPIResponse = new BottleRocketAPIResponse(requestError);

        //When responseType is returned from BottleRocketAPIResponse
        int responseType = bottleRocketAPIResponse.getResponseType();

        //Then responseType should be the expected one
        assertThat(responseType, is(BottleRocketAPIResponse.REQUEST_ERROR_RESPONSE));
    }

    @Test
    public void responseType_throwableError() {
        //Given a Throwable instance
        Throwable throwable = new Throwable();
        BottleRocketAPIResponse bottleRocketAPIResponse = new BottleRocketAPIResponse(throwable);

        //When responseType is returned from BottleRocketAPIResponse
        int responseType = bottleRocketAPIResponse.getResponseType();

        //Then the responseType should be the expected one
        assertThat(responseType, is(BottleRocketAPIResponse.THROWABLE_ERROR_RESPONSE));
    }

}
