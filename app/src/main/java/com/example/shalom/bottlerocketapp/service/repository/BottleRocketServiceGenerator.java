package com.example.shalom.bottlerocketapp.service.repository;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Generates an instance of a Retrofit implementation
 */
public class BottleRocketServiceGenerator {
    //Only base URL used in this application
    private static final String BASE_URL = "http://sandbox.bottlerocketapps.com/";

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofitInstance = builder.build();

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    /**
     * @param serviceClass Supply {@link BottleRocketService}
     * @param <S> A class type parameter used to specify that the output class is the same as input class
     * @return Creates An implementation of the API endpoints defined by the service interface
     */
    public static <S> S createService(Class<S> serviceClass) {
        return retrofitInstance.create(serviceClass);
    }
}
