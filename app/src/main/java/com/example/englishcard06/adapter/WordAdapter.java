package com.example.englishcard06.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.englishcard06.databinding.WordsHolderBinding;
import com.example.englishcard06.db.model.WordsModel;
import com.example.englishcard06.utils.interfaces.ItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.WordHolder> {
    List<WordsModel> list = new ArrayList<>();
    ItemClickListener itemClickListener;

    public WordAdapter(List<WordsModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public WordAdapter.WordHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new WordHolder(WordsHolderBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull WordAdapter.WordHolder holder, int position) {
        holder.onBind(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class WordHolder extends RecyclerView.ViewHolder {
        WordsHolderBinding binding;


        public WordHolder(@NonNull WordsHolderBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(WordsModel wordModel) {
            binding.tvWords.setText(wordModel.getWord());
            binding.imgWords.setImageResource(wordModel.getImage());
            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

        }
    }
}








