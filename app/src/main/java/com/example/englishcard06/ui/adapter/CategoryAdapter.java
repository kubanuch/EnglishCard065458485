package com.example.englishcard06.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.englishcard06.databinding.ItemCategoryBinding;
import com.example.englishcard06.db.model.CategoryModel;
import com.example.englishcard06.utils.interfaces.CategoryListener;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    List<CategoryModel> list;
    CategoryListener listener;

    public void setListener(CategoryListener listener) {
        this.listener = listener;
    }

    public void setList(List<CategoryModel> list) {
        this.list = list;
    }

    public CategoryAdapter(List<CategoryModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoryViewHolder(ItemCategoryBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.OnBind(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        private ItemCategoryBinding binding;


        public CategoryViewHolder(@NonNull ItemCategoryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void OnBind(CategoryModel model) {
            binding.categoryTv.setText(model.getName());
            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.listener(model.getName(), getAdapterPosition());
                }
            });
        }
    }

}

