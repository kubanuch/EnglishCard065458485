package com.example.englishcard06.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.englishcard06.R;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_EnglishCard06);
        setContentView(R.layout.activity_main);
    }
}