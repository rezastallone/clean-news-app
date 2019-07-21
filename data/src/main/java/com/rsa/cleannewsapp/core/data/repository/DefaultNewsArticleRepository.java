package com.rsa.cleannewsapp.core.data.repository;

import com.rsa.cleannewsapp.core.data.mapper.ArticleDataToDomainMapper;
import com.rsa.cleannewsapp.core.data.repository.datasource.NewsArticleLocalDataStore;
import com.rsa.cleannewsapp.core.data.repository.datasource.NewsArticleRemoteDataStore;
import com.rsa.cleannewsapp.core.domain.entity.Article;
import com.rsa.cleannewsapp.core.domain.repository.NewsArticleRepository;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

public class DefaultNewsArticleRepository implements NewsArticleRepository {

    private final ArticleDataToDomainMapper articleDataToDomainMapper;

    private final NewsArticleLocalDataStore newsArticleLocalDataStore;

    private final NewsArticleRemoteDataStore newsArticleRemoteDataStore;

    public DefaultNewsArticleRepository(
        NewsArticleRemoteDataStore remoteDataStore,
        NewsArticleLocalDataStore localDataSource) {
        this.articleDataToDomainMapper = new ArticleDataToDomainMapper();
        this.newsArticleRemoteDataStore = remoteDataStore;
        this.newsArticleLocalDataStore = localDataSource;
    }

    @Override
    public Observable<List<Article>> headlines(String country) {
        return newsArticleRemoteDataStore.headlines(country)
            .flatMap(
                new Function<List<com.rsa.cleannewsapp.core.data.entity.Article>,
                    ObservableSource<List<Article>>>() {
                    @Override
                    public ObservableSource<List<Article>> apply(
                        List<com.rsa.cleannewsapp.core.data.entity.Article> articles) throws Exception {
                        return Observable
                            .just((List<Article>) articleDataToDomainMapper.transform(articles));
                    }
                });
    }

    @Override
    public Observable<List<Article>> bookmarkedNews() {
        return newsArticleLocalDataStore.getBookmarkedNews().flatMap(
            new Function<List<com.rsa.cleannewsapp.core.data.entity.Article>,
                ObservableSource<List<Article>>>() {
                @Override
                public ObservableSource<List<Article>> apply(
                    List<com.rsa.cleannewsapp.core.data.entity.Article> articles) throws Exception {
                    return Observable
                        .just((List<Article>) articleDataToDomainMapper.transform(articles));
                }
            });
    }

    @Override
    public void setBookmarkedNews(Article article) {
        newsArticleLocalDataStore
            .addBookmarkedNews(articleDataToDomainMapper.transformBack(article));
    }

    @Override
    public void deleteBookmarkedNews(Article article) {
        newsArticleLocalDataStore
            .deleteBookmarkNews(articleDataToDomainMapper.transformBack(article));
    }
}
