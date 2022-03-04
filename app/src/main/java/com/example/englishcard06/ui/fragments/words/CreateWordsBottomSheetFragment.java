package com.example.englishcard06.ui.fragments.words;


import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.example.englishcard06.databinding.FragmentCreateWordsBottomSheetBinding;
import com.example.englishcard06.db.model.WordsModel;
import com.example.englishcard06.network.model.Hits;
import com.example.englishcard06.ui.adapter.AdapterRecyclerviewImage;
import com.example.englishcard06.utils.interfaces.ItemClickListener;
import com.example.englishcard06.viewmodel.PixaBayViewModel;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;


public class CreateWordsBottomSheetFragment extends BottomSheetDialogFragment implements ItemClickListener {

    PixaBayViewModel viewModel;
    Handler handler = new Handler();
    private FragmentCreateWordsBottomSheetBinding binding;
    private AdapterRecyclerviewImage adapterImage;
    String word;
    WordsFragmentArgs args;
    String category;
    int image;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentCreateWordsBottomSheetBinding.inflate(getLayoutInflater());
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(PixaBayViewModel.class);
        adapterImage = new AdapterRecyclerviewImage((ItemClickListener) this);
        getImages();
        getArgs();
    }

    private void getArgs() {
        if (getArguments() != null) {
            args = WordsFragmentArgs.fromBundle(getArguments());
            category = args.getFromCategoryToWords();
        }
    }


    private void getImages() {
        binding.btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                binding.edText.addTextChangedListener(new TextWatcher() {
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
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                String text = binding.edText.getText().toString();
                                binding.progressBar.setVisibility(View.VISIBLE);
                                viewModel.getImages(text).observe(getViewLifecycleOwner(), hits -> {
                                    if (hits != null) {
                                        binding.progressBar.setVisibility(View.GONE);
                                        adapterImage.setData((ArrayList<Hits>) hits);
                                        binding.recyclerviewImage.setAdapter(adapterImage);
                                        WordsModel wordsModel = new WordsModel(word, category, image);
                                        viewModel.insertWord(wordsModel);
                                    }
                                });
                            }
                        }, 2000);
                    }
                });
            }
        });
    }


    @Override
    public void itemListener(WordsModel wordsModel) {
        image = wordsModel.getImage();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}