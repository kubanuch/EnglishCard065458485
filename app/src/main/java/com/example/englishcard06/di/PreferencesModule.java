package com.example.englishcard06.di;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class PreferencesModule {
    @Singleton
    @Provides

    public static SharedPreferences provideSharedPreferences(@ApplicationContext Context context) {
        return context.getSharedPreferences("english.pref", Context.MODE_PRIVATE);
    }


}
