package com.rsa.cleannewsapp.core.data.remote;

import com.rsa.cleannewsapp.core.domain.entity.NewsArticles;

import io.reactivex.Observable;
import retrofit2.Retrofit;

public class NewsService implements NewsApi {

    private final NewsApi newsApi;

    public NewsService(Retrofit retrofit) {
        newsApi = retrofit.create(NewsApi.class);
    }

    @Override
    public Observable<NewsArticles> headlines(String country) {
        return newsApi.headlines(country);
    }
}
