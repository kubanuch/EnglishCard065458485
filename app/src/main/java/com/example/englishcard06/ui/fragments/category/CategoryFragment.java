package com.example.englishcard06.ui.fragments.category;


import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.englishcard06.databinding.FragmentCategoryBinding;
import com.example.englishcard06.di.App;
import com.example.englishcard06.ui.adapter.CategoryAdapter;
import com.example.englishcard06.ui.fragments.base.BaseFragment;
import com.example.englishcard06.utils.interfaces.CategoryListener;
import com.example.englishcard06.viewmodel.PixaBayViewModel;


public class CategoryFragment extends BaseFragment<FragmentCategoryBinding> {
    CategoryAdapter adapter;
    PixaBayViewModel viewModel;


    @Override
    public FragmentCategoryBinding bind() {
        return FragmentCategoryBinding.inflate(getLayoutInflater());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(PixaBayViewModel.class);
        initObserver();
        initListeners();

    }

    private void initListeners() {
        binding.categoryAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateCategoryBottomSheetFragment createCategoryBottomSheetFragment = new CreateCategoryBottomSheetFragment();
                createCategoryBottomSheetFragment.show(requireActivity().getSupportFragmentManager(), "");
            }
        });
    }

    private void initObserver() {
        viewModel.getCategory().observe(getViewLifecycleOwner(), categoryModels -> {
            if (categoryModels != null) {
                adapter = new CategoryAdapter(categoryModels);
                binding.recyclerview.setAdapter(adapter);
            }
        });

        adapter.setListener(new CategoryListener() {
            @Override
            public void listener(String category, int position) {
                Navigation.findNavController(requireView()).navigate(CategoryFragmentDirections.actionCategoryFragmentToWordsFragment(category, position));
            }
        });

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}