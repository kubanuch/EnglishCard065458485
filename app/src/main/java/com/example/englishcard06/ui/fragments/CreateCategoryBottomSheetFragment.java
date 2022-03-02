package com.example.englishcard06.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.englishcard06.App;
import com.example.englishcard06.databinding.FragmentCreateCategoryBottomSheetBinding;
import com.example.englishcard06.db.model.CategoryModel;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


public class CreateCategoryBottomSheetFragment extends BottomSheetDialogFragment {
    private FragmentCreateCategoryBottomSheetBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentCreateCategoryBottomSheetBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initClickers();
    }

    private void initClickers() {
        binding.createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String category = binding.categoryEd.getText().toString();
                CategoryModel categoryModel = new CategoryModel(category);
                App.getDateBase().categoryDao().insert(categoryModel);
                dismiss();
            }
        });
    }
}