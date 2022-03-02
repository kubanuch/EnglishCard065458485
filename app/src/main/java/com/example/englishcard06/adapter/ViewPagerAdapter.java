package com.example.englishcard06.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.englishcard06.databinding.FragmentBoardBinding;
import com.example.englishcard06.network.model.ViewPagerModel;
import com.example.englishcard06.utils.interfaces.ClickListener;

import java.util.ArrayList;

public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.ViewPagerHolder> {
    ArrayList<ViewPagerModel> listPager;
    ClickListener listener;

    public ViewPagerAdapter(ArrayList<ViewPagerModel> listPager, ClickListener listener) {
        this.listPager = listPager;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewPagerAdapter.ViewPagerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewPagerHolder(FragmentBoardBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewPagerAdapter.ViewPagerHolder holder, int position) {
        holder.OnBind(listPager.get(position));
    }

    @Override
    public int getItemCount() {
        return listPager.size();
    }

    public class ViewPagerHolder extends RecyclerView.ViewHolder {
        private FragmentBoardBinding binding;

        public ViewPagerHolder(@NonNull FragmentBoardBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void OnBind(ViewPagerModel model) {
            binding.tvTitle.setText(model.getTitle());
            binding.tvText.setText(model.getText());
            binding.ivImage.setImageResource(model.getImage());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.itemClick(model);

                }
            });
        }
    }
}
