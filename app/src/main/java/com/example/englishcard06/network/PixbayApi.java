package com.example.englishcard06.network;

import com.example.englishcard06.network.model.PixabayResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PixbayApi {
    @GET("/api?key=25684975-6e2f0510cb7fb3d7709f7d7c1")
    Call<PixabayResponse> getImages(@Query("q") String englishWord);
}
