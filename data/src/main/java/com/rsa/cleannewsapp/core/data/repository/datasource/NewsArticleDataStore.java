package com.rsa.cleannewsapp.core.data.repository.datasource;

import com.rsa.cleannewsapp.core.data.entity.Article;

import java.util.List;

import io.reactivex.Observable;

public interface NewsArticleDataStore {

    Observable<List<Article>> headlines(String country);

    Observable<List<Article>> getBookmarkedNews();

    void addBookmarkedNews(Article bookmarkedNews);

}
