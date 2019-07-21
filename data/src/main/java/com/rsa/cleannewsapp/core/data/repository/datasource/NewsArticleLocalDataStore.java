package com.rsa.cleannewsapp.core.data.repository.datasource;

import com.rsa.cleannewsapp.core.data.entity.Article;
import com.rsa.cleannewsapp.core.data.local.AppDatabase;
import com.rsa.cleannewsapp.core.data.local.ArticleDao;

import java.util.List;

import io.reactivex.Observable;

public class NewsArticleLocalDataStore implements NewsArticleDataStore {

    private final ArticleDao articleDao;

    public NewsArticleLocalDataStore(AppDatabase appDatabase) {
        this.articleDao = appDatabase.articleDao();
    }

    @Override
    public Observable<List<Article>> headlines(String country) {
        return Observable.empty();
    }

    @Override
    public Observable<List<Article>> getBookmarkedNews() {
        return articleDao.getBookmarkedArticles().toObservable();
    }

    @Override
    public void addBookmarkedNews(Article bookmarkedNews) {
        articleDao.insert(bookmarkedNews);
    }

    @Override
    public void deleteBookmarkNews(Article bookmarkedToDelete) {
        articleDao.delete(bookmarkedToDelete);
    }
}
