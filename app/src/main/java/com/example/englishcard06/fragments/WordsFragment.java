package com.example.englishcard06.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import com.example.englishcard06.adapter.AdapterWords;
import com.example.englishcard06.base.BaseFragment;
import com.example.englishcard06.databinding.FragmentWordsBinding;
import com.example.englishcard06.viewmodel.PixaBayViewModel;

public class WordsFragment extends BaseFragment<FragmentWordsBinding> {

    PixaBayViewModel viewModel;
    private AdapterWords adapterWords;
    Handler handler = new Handler();

    @Override
    public FragmentWordsBinding bind() {
        return FragmentWordsBinding.inflate(getLayoutInflater());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = ViewModelProviders.of(requireParentFragment()).get(PixaBayViewModel.class);
        getImages();
        initAdapter();

    }


    private void initAdapter() {
        adapterWords = new AdapterWords();
    }

    private void getImages() {
        binding.etText.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }


            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (handler != null) {
                    handler = null;
                }
            }


            @Override
            public void afterTextChanged(Editable editable) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        String text = binding.etText.getText().toString();
                        binding.progressBar.setVisibility(View.VISIBLE);
                        viewModel.getImages(text).observe(getViewLifecycleOwner(), hits -> {
                            if (hits != null) {
                                binding.progressBar.setVisibility(View.GONE);
                                adapterWords.setList(hits);
                                binding.recyclerview.setAdapter(adapterWords);

                            }
                        });
                    }
                }, 5000);
                Log.e("ololo", "" + 2000);


            }
        });

    }
}


