package com.somo.test.server;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by yebonkim on 2016. 11. 19..
 */

public class ArticleListClassResponse {
    @SerializedName("results")
    List<ArticleClass> articleClass;

    public List<ArticleClass> getArticleClass() {
        return articleClass;
    }

    public void setArticleClass(List<ArticleClass> articleClass) {
        this.articleClass = articleClass;
    }
}
