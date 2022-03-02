package com.example.englishcard06.db.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class CategoryModel implements Serializable {

    @PrimaryKey(autoGenerate = true)
    public int id;
    public String name;

    public CategoryModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
