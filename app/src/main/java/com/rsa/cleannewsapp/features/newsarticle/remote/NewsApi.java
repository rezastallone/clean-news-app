package com.rsa.cleannewsapp.features.newsarticle.remote;

import com.rsa.cleannewsapp.core.data.entity.NewsArticles;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface NewsApi {

    String HEADLINES = "top-headlines";

    @GET(HEADLINES)
    Observable<NewsArticles> headlines();
}
