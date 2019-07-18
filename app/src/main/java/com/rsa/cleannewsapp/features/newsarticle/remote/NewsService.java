package com.rsa.cleannewsapp.features.newsarticle.remote;

import com.rsa.cleannewsapp.core.data.entity.NewsArticles;

import io.reactivex.Observable;
import retrofit2.Retrofit;

public class NewsService implements NewsApi {

    private final NewsApi newsApi;

    public NewsService(Retrofit retrofit) {
        newsApi = retrofit.create(NewsApi.class);
    }

    @Override
    public Observable<NewsArticles> articles() {
        return newsApi.articles();
    }
}