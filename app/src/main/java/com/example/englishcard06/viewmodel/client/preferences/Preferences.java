package com.example.englishcard06.viewmodel.client.preferences;

import android.content.SharedPreferences;

import javax.inject.Inject;
public class Preferences {

    private final SharedPreferences sharedPreferences;

    @Inject
    public Preferences(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    public boolean getBoolean() {
        return sharedPreferences.getBoolean("isShown", false);
    }

    public void setBoolean(boolean isShown) {
        sharedPreferences.edit().putBoolean("isShown", isShown).apply();
    }
}
