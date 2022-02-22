package com.example.englishcard06.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.englishcard06.client.preferences.Preferences;
import com.example.englishcard06.network.model.Hits;
import com.example.englishcard06.repository.PixaBayRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import retrofit2.http.Query;

@HiltViewModel
public class PixaBayViewModel extends ViewModel {
     MutableLiveData<List<Hits>> hitsMutableLiveData = new MutableLiveData<>();
    PixaBayRepository repository;

    Preferences preferences;

    @Inject
    public void PixabayViewModel(PixaBayRepository repository, Preferences preferencesHelper) {
        this.repository = repository;
        this.preferences = preferencesHelper;
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
}
