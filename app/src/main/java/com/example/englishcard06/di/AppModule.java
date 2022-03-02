package com.example.englishcard06.di;


import com.example.englishcard06.network.model.PixbayApi;
import com.example.englishcard06.repository.PixaBayRepository;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {
    @Singleton
    @Provides
    public static PixaBayRepository provideRepository(PixbayApi api) {
        return new PixaBayRepository(api);

    }

    @Singleton
    @Provides
    public static PixbayApi provideApi(OkHttpClient client) {
        return new Retrofit.Builder().baseUrl
                ("https://pixabay.com/").addConverterFactory
                (GsonConverterFactory.create())
                .client(client)
                .build().create(PixbayApi.class);
    }
    @Singleton
    @Provides
    public static OkHttpClient provideOkHttpClient(Interceptor interceptor) {
        return new OkHttpClient().newBuilder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();
    }

    @Singleton
    @Provides
    public static Interceptor provideLoggingInterceptor() {
        return new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY);
    }

}



