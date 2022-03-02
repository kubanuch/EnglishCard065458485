package com.example.englishcard06;

import android.app.Application;

import androidx.room.Room;

import com.example.englishcard06.db.AppDatabase;

import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp
public class App extends Application {
    static AppDatabase AppDatabase;
    static App app;

    public static App getInstance() {
        return app;
    }

    public static AppDatabase getDateBase() {
        return AppDatabase;

    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        AppDatabase = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database").allowMainThreadQueries().fallbackToDestructiveMigration()
                .build();
    }
}
