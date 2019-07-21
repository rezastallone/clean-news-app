package com.rsa.cleannewsapp.core.domain.repository;

import com.rsa.cleannewsapp.core.domain.entity.Article;

import java.util.List;

import io.reactivex.Observable;

public interface NewsArticleRepository {

    Observable<List<Article>> headlines(String country);

    Observable<List<Article>> bookmarkedNews();

    void setBookmarkedNews(Article article);

    void deleteBookmarkedNews(Article article);
}
