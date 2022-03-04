package com.example.englishcard06.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.englishcard06.db.model.CategoryModel;
import com.example.englishcard06.db.model.WordsModel;
import com.example.englishcard06.network.model.Hits;
import com.example.englishcard06.repository.PixaBayRepository;
import com.example.englishcard06.utils.data.RoomModel;
import com.example.englishcard06.viewmodel.client.preferences.Preferences;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.hilt.android.lifecycle.HiltViewModel;


@HiltViewModel
public class PixaBayViewModel extends ViewModel {
    MutableLiveData<List<Hits>> hitsMutableLiveData = new MutableLiveData<>();
    public LiveData<List<CategoryModel>> categoryList = new MutableLiveData<>();
    public LiveData<List<WordsModel>> wordsList = new MutableLiveData<>();
    PixaBayRepository repository;
    Preferences preferences;
    RoomModel roomModel;

    @Inject
    public PixaBayViewModel(PixaBayRepository repository, Preferences preferencesHelper, RoomModel roomModel) {
        this.repository = repository;
        this.preferences = preferencesHelper;
        this.roomModel = roomModel;
    }


    public MutableLiveData<List<Hits>> getImages(String word) {
        repository.getImages(word);
        hitsMutableLiveData = repository.listImages;
        return hitsMutableLiveData;
    }


    public boolean getBoolean() {
        return preferences.getBoolean();
    }


    public void setBoolean(boolean isShown) {
        preferences.setBoolean(isShown);
    }

    public void insertCategory(CategoryModel categoryModel) {
        roomModel.insertCategory(categoryModel);
    }

    public LiveData<List<CategoryModel>> getCategory() {
        return categoryList = repository.getCategory();
    }

    public void insertWord(WordsModel wordModel) {
        roomModel.insertWord(wordModel);

    }

    public LiveData<List<WordsModel>> getWords(String userCategory) {
        return wordsList = repository.getWords(userCategory);
    }

}
