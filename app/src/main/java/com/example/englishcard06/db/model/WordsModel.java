package com.example.englishcard06.db.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class WordsModel {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String word;
    public String category;
    private int image;

    public WordsModel(String word, String category, int image) {
        this.word = word;
        this.category = category;
        this.image = image;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
