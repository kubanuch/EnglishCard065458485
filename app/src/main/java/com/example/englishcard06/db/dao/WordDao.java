package com.example.englishcard06.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.englishcard06.db.model.WordsModel;

import java.util.List;

@Dao
public interface WordDao {

    @Insert
    void insert(WordsModel wordsModel);


    @Query("SELECT * FROM wordsmodel WHERE category =:userCategory")
    LiveData<List<WordsModel>> getAll(String userCategory);

}
