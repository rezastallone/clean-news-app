package com.rsa.cleannewsapp.core.data.repository.datasource;

import com.rsa.cleannewsapp.core.data.entity.Article;
import com.rsa.cleannewsapp.core.data.entity.NewsArticles;
import com.rsa.cleannewsapp.core.data.remote.NewsApi;

import java.util.Collections;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import retrofit2.Retrofit;

public class NewsArticleRemoteDataStore implements NewsArticleDataStore {

    private final NewsApi newsApi;

    public NewsArticleRemoteDataStore(Retrofit retrofit) {
        newsApi = retrofit.create(NewsApi.class);
    }

    @Override
    public Observable<List<Article>> headlines(String country) {
        return newsApi.headlines(country).flatMap(
            new Function<NewsArticles, ObservableSource<List<Article>>>() {
                @Override
                public ObservableSource<List<Article>> apply(
                    NewsArticles newsArticles) throws Exception {
                    return Observable.just((List<Article>) newsArticles.articles);
                }
            });
    }

    @Override
    public Observable<List<Article>> getBookmarkedNews() {
        return (Observable<List<Article>>) Collections.emptyList();
    }

    @Override
    public void addBookmarkedNews(Article bookmarkedNews) {

    }

    @Override
    public void deleteBookmarkNews(Article bookmarkedToDelete) {

    }
}
