package com.example.shalom.bottlerocketapp.service.repository;

import com.example.shalom.bottlerocketapp.service.model.Stores;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Contains abstract methods used by Retrofit for getting
 * {@link com.example.shalom.bottlerocketapp.service.model.Stores}
 */
public interface BottleRocketService {

    @GET("BR_Android_CodingExam_2015_Server/stores.json")
    Call<Stores> fetchStores();

}
