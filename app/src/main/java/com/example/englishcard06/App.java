package com.example.englishcard06;

import android.app.Application;

import com.example.englishcard06.network.PixbayApi;
import com.example.englishcard06.network.RetrofitClient;

public class App extends Application {
    public static RetrofitClient retrofitClient;
    public static PixbayApi api;

    @Override
    public void onCreate() {
        super.onCreate();
        retrofitClient = new RetrofitClient();
        api = retrofitClient.providePixabayApi();
    }
}
