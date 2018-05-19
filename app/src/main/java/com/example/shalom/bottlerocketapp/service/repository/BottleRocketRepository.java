package com.example.shalom.bottlerocketapp.service.repository;

import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.example.shalom.bottlerocketapp.service.model.BottleRocketAPIResponse;
import com.example.shalom.bottlerocketapp.service.model.Stores;
import com.example.shalom.bottlerocketapp.util.EspressoIdlingResource;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Repository used by {@link com.example.shalom.bottlerocketapp.viewmodel.StoresViewModel}
 */
public class BottleRocketRepository {

    public static final String LOG_TAG = BottleRocketRepository.class.getSimpleName();

    //Required for static instantiation
    private static BottleRocketRepository bottlerocketRepository;

    private BottleRocketService storesService;

    private MutableLiveData<BottleRocketAPIResponse> apiResponse = new MutableLiveData<>();

    public BottleRocketRepository(){
        storesService = BottleRocketServiceGenerator.createService(BottleRocketService.class);
    }

    //Creates an instance of this repository
    public static synchronized BottleRocketRepository getInstance() {
        if (bottlerocketRepository == null) {
            bottlerocketRepository = new BottleRocketRepository();
        }
        return bottlerocketRepository;
    }

    /**
     * Enables caching of data from JSON reponse
     * @return {@code apiResponse} which enables the caller to be informed when the network response is
     * received
     */
    public MutableLiveData<BottleRocketAPIResponse> cacheStores() {

        EspressoIdlingResource.increment();

        Callback<Stores> callback = new Callback<Stores>() {
            @Override
            public void onResponse(Call<Stores> call, Response<Stores> response) {
                if (response.isSuccessful()) {
                    apiResponse.postValue(new BottleRocketAPIResponse(response.body()));
                    Log.d(LOG_TAG, "Stores retreived");
                } else {
                    int statusCode = response.code();
                    apiResponse.postValue(new BottleRocketAPIResponse(statusCode));
                    Log.e(LOG_TAG, "Request error: " + statusCode);
                }
            }


            @Override
            public void onFailure(Call<Stores> call, Throwable t) {
                apiResponse.postValue(new BottleRocketAPIResponse(t));
                Log.e(LOG_TAG, "Error loading from API");
            }
        };

        storesService.fetchStores().enqueue(callback);

        return apiResponse;
    }
}
