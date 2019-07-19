package com.rsa.cleannewsapp.core.data.repository.datasource;

import com.rsa.cleannewsapp.core.data.remote.NewsApi;
import com.rsa.cleannewsapp.core.domain.entity.NewsArticles;

import io.reactivex.Observable;
import retrofit2.Retrofit;

public class NewsArticleRemoteDataStore implements NewsArticleDataStore {

    private final NewsApi newsApi;

    public NewsArticleRemoteDataStore(Retrofit retrofit) {
        newsApi = retrofit.create(NewsApi.class);
    }

    @Override
    public Observable<NewsArticles> headlines(String country) {
        return newsApi.headlines(country);
    }
}
