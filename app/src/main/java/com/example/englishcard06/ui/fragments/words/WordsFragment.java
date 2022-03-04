package com.example.englishcard06.ui.fragments.words;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.example.englishcard06.di.App;
import com.example.englishcard06.ui.adapter.WordAdapter;
import com.example.englishcard06.ui.fragments.base.BaseFragment;
import com.example.englishcard06.db.model.WordsModel;
import com.example.englishcard06.viewmodel.PixaBayViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class WordsFragment extends BaseFragment<com.example.englishcard06.databinding.FragmentWordsBinding> {
    PixaBayViewModel viewModel;
    WordsModel wordModel;
    WordAdapter wordAdapter;
    WordsFragmentArgs args;


    @Override
    public com.example.englishcard06.databinding.FragmentWordsBinding bind() {
        return com.example.englishcard06.databinding.FragmentWordsBinding.inflate(getLayoutInflater());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(PixaBayViewModel.class);
        getImages();
        getAgs();
        initObserver();
    }

    private void initObserver() {
        String category = args.getFromCategoryToWords();
        viewModel.getWords(category).observe(getViewLifecycleOwner(), wordsModels -> {
            if (wordsModels != null) {
                wordAdapter = new WordAdapter(wordsModels);
                binding.recyclerview.setAdapter(wordAdapter);
            }

        });
    }


    private void getAgs() {
        if (getArguments() != null) {
            args = WordsFragmentArgs.fromBundle(getArguments());
            String category = args.getFromCategoryToWords();
            binding.toolbar.setTitle(category);
        }
    }


    private void getImages() {
        binding.btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateWordsBottomSheetFragment createWordsBottomSheetFragment = new CreateWordsBottomSheetFragment();
                createWordsBottomSheetFragment.show(requireActivity().getSupportFragmentManager(), "word dialog opened");
            }
        });
    }
}