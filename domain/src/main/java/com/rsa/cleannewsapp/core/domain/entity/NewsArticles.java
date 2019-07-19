package com.rsa.cleannewsapp.core.domain.entity;

import java.util.ArrayList;

public class NewsArticles {

    public final ArrayList<Article> articles;

    public final String status;

    public final int totalResults;

    public NewsArticles(String status, int totalResults,
        ArrayList<Article> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public static NewsArticles fromNothing() {
        return new NewsArticles("", 0, new ArrayList<>());
    }
}
