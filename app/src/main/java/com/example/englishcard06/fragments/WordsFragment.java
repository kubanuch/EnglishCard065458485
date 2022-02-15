package com.example.englishcard06.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.englishcard06.App;
import com.example.englishcard06.adapter.AdapterWords;
import com.example.englishcard06.base.BaseFragment;
import com.example.englishcard06.databinding.FragmentWordsBinding;
import com.example.englishcard06.network.model.Hits;
import com.example.englishcard06.network.model.PixabayResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WordsFragment extends BaseFragment<FragmentWordsBinding> {
    private AdapterWords adapterWords;
    private LinearLayoutManager linearLayout = new LinearLayoutManager(getContext());

    @Override
    public FragmentWordsBinding bind() {
        return FragmentWordsBinding.inflate(getLayoutInflater());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.recyclerview.setLayoutManager(linearLayout);
        adapterWords = new AdapterWords();
        getImages();
    }


    private void getImages() {
        binding.btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String words = binding.etText.getText().toString();
                App.retrofitClient.providePixabayApi().getImages("25684975-6e2f0510cb7fb3d7709f7d7c1", words)
                        .enqueue(new Callback<PixabayResponse>() {
                            @Override
                            public void onResponse(Call<PixabayResponse> call, Response<PixabayResponse> response) {
                                if (response.isSuccessful()) {
                                    adapterWords.setList((ArrayList<Hits>) response.body().getHits());
                                    binding.recyclerview.setAdapter(adapterWords);
                                    Log.e("ololo", "" + response.body());

                                }
                            }

                            @Override
                            public void onFailure(Call<PixabayResponse> call, Throwable t) {
                                Log.e("ololo", t.getMessage());

                            }
                        });

            }
        });


    }

}
