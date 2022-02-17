package com.example.englishcard06.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.englishcard06.adapter.AdapterWords;
import com.example.englishcard06.base.BaseFragment;
import com.example.englishcard06.databinding.FragmentWordsBinding;
import com.example.englishcard06.viewmodel.PixaBayViewModel;

public class WordsFragment extends BaseFragment<FragmentWordsBinding> {

    PixaBayViewModel viewModel;
    private final AdapterWords adapterWords = new AdapterWords();

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
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(requireContext()));

    }

    private void getImages() {
        binding.etText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                final Handler handler = new Handler(Looper.getMainLooper());
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
//                        Do something after 100ms
                        binding.progressBar.setVisibility(View.VISIBLE);
                        viewModel.getImages(binding.etText.getText().toString()).observe(getViewLifecycleOwner(), hits -> {
                            if (hits != null) {
                                binding.progressBar.setVisibility(View.GONE);
                                binding.recyclerview.setAdapter(adapterWords);
                                adapterWords.setList(hits);

                            }
                        });
                    }
                }, 3000);

            }
        });

    }
}


