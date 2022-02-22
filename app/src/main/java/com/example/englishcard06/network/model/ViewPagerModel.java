package com.example.englishcard06.network.model;

public class ViewPagerModel {
    private String title;
    private String text;
    private int image;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public ViewPagerModel(String title, String text, int image) {
        this.title = title;
        this.text = text;
        this.image = image;
    }
}
