package com.rsa.cleannewsapp.core.data.repository;

import com.rsa.cleannewsapp.core.data.repository.datasource.NewsArticleRemoteDataStore;
import com.rsa.cleannewsapp.core.domain.entity.NewsArticles;
import com.rsa.cleannewsapp.core.domain.repository.NewsArticleRepository;

import io.reactivex.Observable;

public class DefaultNewsArticleRepository implements NewsArticleRepository {

    private NewsArticleRemoteDataStore newsArticleRemoteDataStore;

    public DefaultNewsArticleRepository(
        NewsArticleRemoteDataStore remoteDataStore) {
        this.newsArticleRemoteDataStore = remoteDataStore;
    }

    @Override
    public Observable<NewsArticles> headlines(String country) {
        return newsArticleRemoteDataStore.headlines("id");
    }
}
