package com.example.englishcard06.client.preferences;

import android.content.SharedPreferences;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Preferences {

    private final SharedPreferences sharedPreferences;

    @Inject
    Preferences(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    public boolean getBoolean() {
        boolean isShown = sharedPreferences.getBoolean("shared_prefs", false);
        return isShown;
    }

    public void setBoolean(boolean isShown) {
        sharedPreferences.edit().putBoolean("shared_prefs", isShown).apply();
    }
}
