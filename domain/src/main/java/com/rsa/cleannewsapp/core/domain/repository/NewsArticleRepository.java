package com.rsa.cleannewsapp.core.domain.repository;

import com.rsa.cleannewsapp.core.domain.entity.NewsArticles;

import io.reactivex.Observable;

public interface NewsArticleRepository {

    Observable<NewsArticles> headlines(String country);

}
