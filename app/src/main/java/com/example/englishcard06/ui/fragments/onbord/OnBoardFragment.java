package com.example.englishcard06.ui.fragments.onbord;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;

import com.example.englishcard06.R;
import com.example.englishcard06.ui.adapter.ViewPagerAdapter;
import com.example.englishcard06.ui.fragments.base.BaseFragment;
import com.example.englishcard06.viewmodel.client.ViewPagerClient;
import com.example.englishcard06.databinding.FragmentOnBoardBinding;
import com.example.englishcard06.network.model.ViewPagerModel;
import com.example.englishcard06.utils.interfaces.ClickListener;
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
                viewModel.setBoolean(true);
                Navigation.findNavController(requireView()).navigate(R.id.wordsFragment);
            }
        });
    }

    private void IfShown() {
        if (viewModel.getBoolean()) {
            Navigation.findNavController(requireView()).navigate(R.id.wordsFragment);
        } else {
            viewModel.setBoolean(false);
        }
    }
    @Override
    public void itemClick(ViewPagerModel viewPagerModel) {
        binding.btnGetStart.setVisibility(View.GONE);
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