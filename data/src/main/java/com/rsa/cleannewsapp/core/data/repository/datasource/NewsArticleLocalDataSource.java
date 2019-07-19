package com.rsa.cleannewsapp.core.data.repository.datasource;

import com.rsa.cleannewsapp.core.domain.entity.Article;
import com.rsa.cleannewsapp.core.domain.entity.NewsArticles;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public class NewsArticleLocalDataSource implements NewsArticleDataStore {

    private ObservableEmitter<ArrayList<Article>> bookmaredNewsEmmiter;

    private Observable<ArrayList<Article>> bookmarkObservable = Observable
        .create(new ObservableOnSubscribe<ArrayList<Article>>() {

            @Override
            public void subscribe(ObservableEmitter<ArrayList<Article>> emitter) throws Exception {
                bookmaredNewsEmmiter = emitter;
            }
        });

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
