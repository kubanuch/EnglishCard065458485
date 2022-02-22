package com.example.englishcard06.client;

import com.example.englishcard06.R;
import com.example.englishcard06.network.model.ViewPagerModel;

import java.util.ArrayList;

public class ViewPagerClient {
    public static ArrayList<ViewPagerModel> pagerlist = new ArrayList<>();

    public static ArrayList<ViewPagerModel> getPagerlist() {
        pagerlist.add(new ViewPagerModel("Создавайте  собственные  категории для слов  ","Категории", R.drawable.noo ));
        pagerlist.add(new ViewPagerModel("Создавайте слова на английском и кликайте на карточку чтобы увидеть" +
                " его перевд и картинку  для фссоцифции  ","Слова", R.drawable.shi));
        pagerlist.add(new ViewPagerModel("Свайпайте карточку вправо еслы вы запомнили, влево если пока еще не уверны ","Изучение", R.drawable.olee ));
        pagerlist.add(new ViewPagerModel("Следите за своими авичками  и количеством очков опыта ","Личный кобинет", R.drawable.name ));
        pagerlist.add(new ViewPagerModel("Let's do it ","давайте начнем!", R.drawable.naruto ));
        return pagerlist;
}
}
