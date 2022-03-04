package com.example.englishcard06.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.englishcard06.db.AppDatabase;
import com.example.englishcard06.db.model.CategoryModel;
import com.example.englishcard06.db.model.WordsModel;
import com.example.englishcard06.network.model.Hits;
import com.example.englishcard06.network.model.PixabayResponse;
import com.example.englishcard06.network.model.PixbayApi;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PixaBayRepository {
    AppDatabase appDatabase;

    PixbayApi api;
    public MutableLiveData<List<Hits>> listImages = new MutableLiveData<>();

    @Inject
    public PixaBayRepository(PixbayApi api) {
        this.api = api;
    }

    public void getImages(String word) {
        api.getImages(word).enqueue(new Callback<PixabayResponse>() {
            @Override
            public void onResponse(Call<PixabayResponse> call, Response<PixabayResponse> response) {
                if (response.isSuccessful()) {
                    listImages.postValue(response.body().getHits());
                }
            }
            @Override
            public void onFailure(Call<PixabayResponse> call, Throwable t) {
                Log.e("ololo", t.getMessage());

            }
        });
    }

    public LiveData<List<CategoryModel>> getCategory() {
        MutableLiveData<List<CategoryModel>> categoryList = new MutableLiveData<>();
        categoryList.setValue((List<CategoryModel>) appDatabase.getAppDatabase().categoryDao().getAll());
        return categoryList;
    }
    public LiveData<List<WordsModel>> getWords(String userCategory) {
        MutableLiveData<List<WordsModel>> wordsList = new MutableLiveData<>();
        wordsList.setValue((List<WordsModel>) appDatabase.getAppDatabase().wordDao().getAll(userCategory));
        return wordsList;
    }

}
