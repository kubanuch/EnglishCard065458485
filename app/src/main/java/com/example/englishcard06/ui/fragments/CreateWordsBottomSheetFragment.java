package com.example.englishcard06.ui.fragments;


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
import androidx.navigation.Navigation;

import com.example.englishcard06.App;
import com.example.englishcard06.R;
import com.example.englishcard06.adapter.AdapterRecyclerviewImage;
import com.example.englishcard06.databinding.FragmentCreateWordsBottomSheetBinding;
import com.example.englishcard06.utils.interfaces.ItemClickListener;
import com.example.englishcard06.viewmodel.PixaBayViewModel;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


public class CreateWordsBottomSheetFragment extends BottomSheetDialogFragment {

    PixaBayViewModel viewModel;
    Handler handler = new Handler();
    private FragmentCreateWordsBottomSheetBinding binding;
    private AdapterRecyclerviewImage adapterImage;

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
        adapterImage = new AdapterRecyclerviewImage();
        getImages();
        getargs();
    }

    private void getargs() {

    }

    private void getImages() {
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
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        String text = binding.edText.getText().toString();
                        binding.progressBar.setVisibility(View.VISIBLE);
                        viewModel.getImages(text).observe(getViewLifecycleOwner(), hits -> {
                            if (hits != null) {
                                binding.progressBar.setVisibility(View.GONE);
                                adapterImage.setList(hits);
                                adapterImage.setItemClickListener(new ItemClickListener() {
                                    @Override
                                    public void itemListener(int position) {
                                        Navigation.findNavController(requireView()).navigate(CreateWordsBottomSheetFragmentDirections.actionCreateWordsBottomSheetFragmentToWordsFragment(text,position));
                                    }
                                });
                                binding.recyclerviewImage.setAdapter(adapterImage);

                            }
                        });
                    }
                }, 2000);


            }
        });
    }




}