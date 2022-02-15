
package com.example.englishcard06.fragments;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.englishcard06.base.BaseFragment;
import com.example.englishcard06.databinding.FragmentCategoryBinding;

public class CategoryFragment extends BaseFragment<FragmentCategoryBinding> {

    @Override
    public FragmentCategoryBinding bind() {
        return FragmentCategoryBinding.inflate(getLayoutInflater());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}