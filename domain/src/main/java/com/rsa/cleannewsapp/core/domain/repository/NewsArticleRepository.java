package com.rsa.cleannewsapp.core.domain.repository;

import com.rsa.cleannewsapp.core.domain.entity.Article;
import com.rsa.cleannewsapp.core.domain.entity.NewsArticles;

import java.util.ArrayList;

import io.reactivex.Observable;

public interface NewsArticleRepository {

    Observable<NewsArticles> headlines(String country);

    Observable<ArrayList<Article>> bookmarkedNews();

    void setBookmarkedNews(ArrayList<Article> articles);

}
