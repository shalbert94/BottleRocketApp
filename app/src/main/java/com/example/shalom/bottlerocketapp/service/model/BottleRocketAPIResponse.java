package com.example.shalom.bottlerocketapp.service.model;

/**
 * Enable informing the UI thread of networking success and failure via wrapping response/failure
 */
public class BottleRocketAPIResponse {

    //Possible response types
    private Stores stores;
    private int requestError = 0; //If request error is 0, there wasn't an error
    private Throwable error;

    //Response type code
    public static final int SUCCESSFUL_RESPONSE = 100;
    public static final int REQUEST_ERROR_RESPONSE = 101;
    public static final int THROWABLE_ERROR_RESPONSE = 102;

    private int responseType;

    public BottleRocketAPIResponse(Stores stores) {
        setResponseType(SUCCESSFUL_RESPONSE);
        this.stores = stores;
        this.error = null;
    }

    public BottleRocketAPIResponse(int requestError) {
        setResponseType(REQUEST_ERROR_RESPONSE);
        this.requestError = requestError;
        this.error = null;
        this.stores = null;
    }

    public BottleRocketAPIResponse(Throwable error) {
        setResponseType(THROWABLE_ERROR_RESPONSE);
        this.error = error;
        this.stores = null;
    }

    public Throwable getError() {
        return error;
    }

    public void setError(Throwable error) {
        this.error = error;
    }

    public int getRequestError() {
        return requestError;
    }

    public void setRequestError(int requestError) {
        this.requestError = requestError;
    }

    public Stores getStores() {
        return stores;
    }

    public void setStores(Stores stores) {
        this.stores = stores;
    }

    public int getResponseType() {
        return responseType;
    }

    public void setResponseType(int responseType) {
        this.responseType = responseType;
    }
}
