package com.rsa.cleannewsapp.core.data.remote;


import com.rsa.cleannewsapp.core.domain.entity.NewsArticles;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApi {

    String HEADLINES = "top-headlines";

    @GET(HEADLINES)
    Observable<NewsArticles> headlines(
        @Query("country") String country
    );
}
