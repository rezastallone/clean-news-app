package com.rsa.cleannewsapp.core.data.repository.datasource;

import com.rsa.cleannewsapp.core.domain.entity.NewsArticles;

import io.reactivex.Observable;

public interface NewsArticleDataStore {

    Observable<NewsArticles> headlines(String country);

}
