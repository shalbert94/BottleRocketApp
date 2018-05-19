package com.example.shalom.bottlerocketapp.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.shalom.bottlerocketapp.service.model.BottleRocketAPIResponse;
import com.example.shalom.bottlerocketapp.service.repository.BottleRocketRepository;

/**
 * ViewModel for {@link com.example.shalom.bottlerocketapp.UI.StoresFragment}
 * Caches data related to the Fragment
 */
public class StoresViewModel extends ViewModel {
    public static final String FRAGMENT_TAG = "StoresFragment";
    private MutableLiveData<BottleRocketAPIResponse> bottleRocketAPIResponse = new MutableLiveData<>();

    public LiveData<BottleRocketAPIResponse> getBottleRocketAPIResponse() {
        if (bottleRocketAPIResponse.getValue() == null ||
                bottleRocketAPIResponse.getValue().getResponseType()
                        != BottleRocketAPIResponse.SUCCESSFUL_RESPONSE) {
            //Retrieve data if {@code bottleRocketAPIResponse} is null, or the previous network request was unsuccessful
            getStores();
        }
        return bottleRocketAPIResponse;
    }

    public void getStores() {
        bottleRocketAPIResponse = BottleRocketRepository.getInstance().cacheStores();
    }

    public void setBottleRocketAPIResponse(MutableLiveData<BottleRocketAPIResponse> bottleRocketAPIResponse) {
        this.bottleRocketAPIResponse = bottleRocketAPIResponse;
    }
}
