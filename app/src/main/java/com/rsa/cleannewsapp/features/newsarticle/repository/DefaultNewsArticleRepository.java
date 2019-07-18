package com.rsa.cleannewsapp.features.newsarticle.repository;

import com.rsa.cleannewsapp.core.domain.entity.NewsArticles;
import com.rsa.cleannewsapp.core.domain.repository.NewsArticleRepository;
import com.rsa.cleannewsapp.features.newsarticle.remote.NewsApi;

import io.reactivex.Observable;

public class DefaultNewsArticleRepository implements NewsArticleRepository {

    private NewsApi newsApi;

    public DefaultNewsArticleRepository(
        NewsApi newsApi) {
        this.newsApi = newsApi;
    }

    @Override
    public Observable<NewsArticles> headlines(String country) {
        return newsApi.headlines("id");
    }
}
