package com.example.englishcard06.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.englishcard06.databinding.ItemTaskBinding;
import com.example.englishcard06.network.model.Hits;

import java.util.ArrayList;
import java.util.List;


public class AdapterWords extends RecyclerView.Adapter<AdapterWords.HomeWords> {

    List<Hits> list = new ArrayList<>();


    @NonNull
    @Override
    public HomeWords onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HomeWords(ItemTaskBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HomeWords holder, int position) {
        holder.onBind(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(List<Hits> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public class HomeWords extends RecyclerView.ViewHolder {
        private ItemTaskBinding binding;

        public HomeWords(@NonNull ItemTaskBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(Hits model) {
            Glide.with(binding.ivImage).load(model.getmLargeImageURL()).into(binding.ivImage);
        }
    }
}
