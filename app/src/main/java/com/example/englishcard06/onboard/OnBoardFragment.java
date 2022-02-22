package com.example.englishcard06.onboard;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;

import com.example.englishcard06.R;
import com.example.englishcard06.adapter.ViewPagerAdapter;
import com.example.englishcard06.base.BaseFragment;
import com.example.englishcard06.client.ViewPagerClient;
import com.example.englishcard06.databinding.FragmentOnBoardBinding;
import com.example.englishcard06.network.model.ViewPagerModel;
import com.example.englishcard06.viewmodel.PixaBayViewModel;

import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class OnBoardFragment extends BaseFragment<FragmentOnBoardBinding> implements ClickListener {


    ViewPagerAdapter adapter;
    PixaBayViewModel viewModel;
    ArrayList<ViewPagerModel> list = new ArrayList<>();

    @Override
    public FragmentOnBoardBinding bind() {
        return FragmentOnBoardBinding.inflate(getLayoutInflater());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(PixaBayViewModel.class);
        initListeners();
        IfShown();
        getData();
    }

    private void initListeners() {
        binding.btnGetStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.setBoolean(false);
                Navigation.findNavController(requireView()).navigate(R.id.wordsFragment);
            }
        });
    }

    private void IfShown() {
        if (viewModel.getBoolean()) {
            Navigation.findNavController(requireView()).navigate(R.id.wordsFragment);
        } else {
            viewModel.setBoolean(true);
        }
    }
    @Override
    public void itemClick(ViewPagerModel viewPagerModel) {
        binding.viewpager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                if (position == 4) {
                    binding.btnGetStart.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    private void getData() {
        list = ViewPagerClient.getPagerlist();
        adapter = new ViewPagerAdapter(list, this);
        binding.viewpager2.setAdapter(adapter);
        binding.dotsIndicator.setViewPager2(binding.viewpager2);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}