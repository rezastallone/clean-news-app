package com.rsa.cleannewsapp.core.data.repository;

import com.rsa.cleannewsapp.core.data.repository.datasource.NewsArticleLocalDataStore;
import com.rsa.cleannewsapp.core.data.repository.datasource.NewsArticleRemoteDataStore;
import com.rsa.cleannewsapp.core.domain.entity.Article;
import com.rsa.cleannewsapp.core.domain.entity.NewsArticles;
import com.rsa.cleannewsapp.core.domain.repository.NewsArticleRepository;

import java.util.ArrayList;

import io.reactivex.Observable;

public class DefaultNewsArticleRepository implements NewsArticleRepository {

    private final NewsArticleLocalDataStore newsArticleLocalDataStore;

    private final NewsArticleRemoteDataStore newsArticleRemoteDataStore;

    public DefaultNewsArticleRepository(
        NewsArticleRemoteDataStore remoteDataStore,
        NewsArticleLocalDataStore localDataSource) {
        this.newsArticleRemoteDataStore = remoteDataStore;
        this.newsArticleLocalDataStore = localDataSource;
    }

    @Override
    public Observable<NewsArticles> headlines(String country) {
        return newsArticleRemoteDataStore.headlines("id");
    }

    @Override
    public Observable<ArrayList<Article>> bookmarkedNews() {
        return newsArticleLocalDataStore.getBookmarkedNews();
    }

    @Override
    public void setBookmarkedNews(ArrayList<Article> articles) {
        newsArticleLocalDataStore.addBookmarkedNews(articles);
    }
}
