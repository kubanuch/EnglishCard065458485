package com.example.englishcard06.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.englishcard06.db.model.CategoryModel;

import java.util.List;

@Dao
public interface CategoryDao {

    @Insert
    void insert(CategoryModel model);

    @Query("SELECT *  FROM categorymodel")
    LiveData<List<CategoryModel>> getAll();


}
