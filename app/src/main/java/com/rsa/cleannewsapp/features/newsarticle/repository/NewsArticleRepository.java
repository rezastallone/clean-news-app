package com.rsa.cleannewsapp.features.newsarticle.repository;

import com.rsa.cleannewsapp.core.data.entity.NewsArticles;

import io.reactivex.Observable;

public interface NewsArticleRepository {

    Observable<NewsArticles> articles();

}
