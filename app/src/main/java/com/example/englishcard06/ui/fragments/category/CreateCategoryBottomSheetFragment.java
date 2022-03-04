package com.example.englishcard06.ui.fragments.category;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.example.englishcard06.databinding.FragmentCreateCategoryBottomSheetBinding;
import com.example.englishcard06.db.model.CategoryModel;
import com.example.englishcard06.viewmodel.PixaBayViewModel;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


public class CreateCategoryBottomSheetFragment extends BottomSheetDialogFragment {
    private FragmentCreateCategoryBottomSheetBinding binding;
    PixaBayViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentCreateCategoryBottomSheetBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(PixaBayViewModel.class);
        initClickers();
    }

    private void initClickers() {
        binding.createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String category = binding.categoryEd.getText().toString();
                CategoryModel categoryModel = new CategoryModel(category);
                viewModel.insertCategory(categoryModel);
                dismiss();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}