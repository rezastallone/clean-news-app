package com.rsa.cleannewsapp.core.data.entity;

import java.util.ArrayList;

public class NewsArticles {

    final ArrayList<Article> articles;

    final String status;

    final int totalResults;

    public NewsArticles(String status, int totalResults,
        ArrayList<Article> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }
}
