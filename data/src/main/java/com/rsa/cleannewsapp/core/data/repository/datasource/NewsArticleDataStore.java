package com.rsa.cleannewsapp.core.data.repository.datasource;

import com.rsa.cleannewsapp.core.domain.entity.Article;
import com.rsa.cleannewsapp.core.domain.entity.NewsArticles;

import java.util.ArrayList;

import io.reactivex.Observable;

public interface NewsArticleDataStore {

    Observable<NewsArticles> headlines(String country);

    Observable<ArrayList<Article>> getBookmarkedNews();

    void addBookmarkedNews(ArrayList<Article> bookmarkedNews);

}
