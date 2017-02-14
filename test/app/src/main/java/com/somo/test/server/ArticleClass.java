package com.somo.test.server;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by yebonkim on 2016. 11. 19..
 */

public class ArticleClass {
    int id;
    String title;
    String subtitle;
    String image_url;
    List<Article> item;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public List<Article> getItem() {
        return item;
    }

    public void setItem(List<Article> item) {
        this.item = item;
    }
}
