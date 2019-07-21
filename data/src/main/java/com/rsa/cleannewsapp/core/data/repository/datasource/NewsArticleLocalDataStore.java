package com.rsa.cleannewsapp.core.data.repository.datasource;

import com.rsa.cleannewsapp.core.data.local.AppDatabase;
import com.rsa.cleannewsapp.core.domain.entity.Article;
import com.rsa.cleannewsapp.core.domain.entity.NewsArticles;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public class NewsArticleLocalDataStore implements NewsArticleDataStore {

    private final AppDatabase appDatabase;

    private ObservableEmitter<ArrayList<Article>> bookmaredNewsEmmiter;

    private Observable<ArrayList<Article>> bookmarkObservable = Observable
        .create(new ObservableOnSubscribe<ArrayList<Article>>() {

            @Override
            public void subscribe(ObservableEmitter<ArrayList<Article>> emitter) throws Exception {
                bookmaredNewsEmmiter = emitter;
            }
        });

    public NewsArticleLocalDataStore(AppDatabase appDatabase) {
        this.appDatabase = appDatabase;
    }

    @Override
    public Observable<NewsArticles> headlines(String country) {
        return Observable.just(NewsArticles.fromNothing());
    }

    @Override
    public Observable<ArrayList<Article>> getBookmarkedNews() {
        return bookmarkObservable;
    }

    @Override
    public void addBookmarkedNews(ArrayList<Article> bookmarkedNews) {
        bookmaredNewsEmmiter.onNext(bookmarkedNews);
    }
}
