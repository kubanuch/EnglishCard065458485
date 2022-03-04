package com.example.englishcard06.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.englishcard06.db.model.WordsModel;

import java.util.List;

import javax.inject.Singleton;

@Dao
@Singleton
public interface WordDao {

    @Singleton
    @Insert
    void insert(WordsModel wordsModel);

    @Singleton
    @Query("SELECT * FROM wordsmodel WHERE category =:userCategory")
    LiveData<List<WordsModel>> getAll(String userCategory);

}
