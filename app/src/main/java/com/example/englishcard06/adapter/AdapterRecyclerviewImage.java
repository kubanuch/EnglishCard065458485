package com.example.englishcard06.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.englishcard06.databinding.ItemTaskBinding;
import com.example.englishcard06.network.model.Hits;
import com.example.englishcard06.utils.interfaces.ItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class AdapterRecyclerviewImage extends RecyclerView.Adapter<AdapterRecyclerviewImage.AdapterRecyclerviewHolder> {

    ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    List<Hits> list = new ArrayList<>();

    @NonNull
    @Override
    public AdapterRecyclerviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdapterRecyclerviewHolder(ItemTaskBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRecyclerviewHolder holder, int position) {
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

    public class AdapterRecyclerviewHolder extends RecyclerView.ViewHolder {
        private final ItemTaskBinding binding;

        public AdapterRecyclerviewHolder(@NonNull ItemTaskBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(Hits model) {
            Glide.with(binding.ivImage).load(model.getmLargeImageURL()).into(binding.ivImage);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemClickListener.itemListener(getAdapterPosition());

                }
            });

        }
    }
}
