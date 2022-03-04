package com.example.englishcard06.utils.data;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.Room;

import com.example.englishcard06.db.AppDatabase;
import com.example.englishcard06.db.dao.CategoryDao;
import com.example.englishcard06.db.dao.WordDao;
import com.example.englishcard06.db.model.CategoryModel;
import com.example.englishcard06.db.model.WordsModel;


import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.hilt.android.qualifiers.ApplicationContext;

@Singleton
public class RoomModel {
    AppDatabase appDatabase;
    private WordDao wordDao;
    private CategoryDao categoryDao;

    @Inject
    @Singleton
    public RoomModel(WordDao wordDao, CategoryDao categoryDao) {
        this.wordDao = wordDao;
        this.categoryDao = categoryDao;
    }

    public AppDatabase createDatabase(@ApplicationContext Context context) {
        appDatabase = Room.databaseBuilder(context, AppDatabase.class, "database").allowMainThreadQueries().build();
        return appDatabase.getAppDatabase();


    }

    public CategoryModel insertCategory(CategoryModel categoryModel) {
        categoryDao.insert(categoryModel);
        return categoryModel;
    }


    public WordsModel insertWord(WordsModel wordModel) {
        wordDao.insert(wordModel);
        return wordModel;
    }

}
