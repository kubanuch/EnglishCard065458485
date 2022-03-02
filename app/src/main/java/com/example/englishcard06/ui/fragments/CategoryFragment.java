package com.example.englishcard06.ui.fragments;


import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.Navigation;

import com.example.englishcard06.App;
import com.example.englishcard06.adapter.CategoryAdapter;
import com.example.englishcard06.base.BaseFragment;
import com.example.englishcard06.databinding.FragmentCategoryBinding;
import com.example.englishcard06.utils.interfaces.CategoryListener;


public class CategoryFragment extends BaseFragment<FragmentCategoryBinding> {
    CategoryAdapter adapter;

    @Override
    public FragmentCategoryBinding bind() {
        return FragmentCategoryBinding.inflate(getLayoutInflater());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initObserver();
    }

    private void initObserver() {
        App.getDateBase().categoryDao().getAll().observe(getViewLifecycleOwner(), categoryModels -> {
            if (categoryModels != null) {
                adapter = new CategoryAdapter(categoryModels);
                binding.recyclerview.setAdapter(adapter);
            }
            adapter.setListener(new CategoryListener() {
                @Override
                public void listener(int position) {
                    Navigation.findNavController(requireView()).navigate(CategoryFragmentDirections.actionCategoryFragmentToWordsFragment("",position));
                }
            });
        });
        binding.categoryAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateCategoryBottomSheetFragment createCategoryBottomSheetFragment = new CreateCategoryBottomSheetFragment();
                createCategoryBottomSheetFragment.show(requireActivity().getSupportFragmentManager(), "");
            }
        });

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}