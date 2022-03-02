package com.example.englishcard06.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.englishcard06.db.dao.CategoryDao;
import com.example.englishcard06.db.dao.WordDao;
import com.example.englishcard06.db.model.CategoryModel;
import com.example.englishcard06.db.model.WordsModel;

@Database(entities = {CategoryModel.class, WordsModel.class}, version = 2, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    AppDatabase AppDatabase;


    public AppDatabase getAppDatabase() {
        return AppDatabase;
    }

    public abstract CategoryDao categoryDao();

    public abstract WordDao wordDao();

}
