package com.rsa.cleannewsapp.features.newsarticle.presenter;

import com.rsa.cleannewsapp.core.domain.entity.Article;
import com.rsa.cleannewsapp.core.domain.entity.NewsArticles;
import com.rsa.cleannewsapp.core.domain.usecase.GetBookmarkedNews;
import com.rsa.cleannewsapp.core.domain.usecase.GetHeadline;
import com.rsa.cleannewsapp.core.presenter.Presenter;
import com.rsa.cleannewsapp.features.newsarticle.mapper.ArticleModelDataMapper;
import com.rsa.cleannewsapp.features.newsarticle.model.ArticleModel;
import com.rsa.cleannewsapp.features.newsarticle.view.HeadlineView;

import java.util.ArrayList;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import io.reactivex.observers.DisposableObserver;

public class HeadlinePresenter extends Presenter<HeadlineView> {

    private final GetBookmarkedNews getBookmarkedNews;

    private ArticleModelDataMapper articleModelDataMapper;

    private GetHeadline getHeadline;

    @Inject
    public HeadlinePresenter(
        @NonNull GetHeadline getHeadline,
        @NonNull GetBookmarkedNews getBookmarkedNews,
        ArticleModelDataMapper articleModelDataMapper
    ) {
        this.getHeadline = getHeadline;
        this.articleModelDataMapper = articleModelDataMapper;
        this.getBookmarkedNews = getBookmarkedNews;
    }

    @Override
    public void initialize() {
        super.initialize();
        getView().showLoading();
        executeGetBookmarkedNews();
        executeGetHeadlines();
    }

    private void executeGetBookmarkedNews() {
        getBookmarkedNews.execute(new DisposableObserver<ArrayList<Article>>() {
            @Override
            public void onNext(ArrayList<Article> articles) {
                showBookmarkedNews(articles);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    private void executeGetHeadlines() {
        getHeadline.execute(new DisposableObserver<NewsArticles>() {
            @Override
            public void onNext(NewsArticles newsArticles) {
                showHeadlines(newsArticles);
            }

            @Override
            public void onError(Throwable e) {
                getView().hideLoading();
                e.printStackTrace();
            }

            @Override
            public void onComplete() {
                getView().hideLoading();
            }
        });
    }

    private void showBookmarkedNews(ArrayList<Article> bookmarkedNews) {
        getView().showBookmarkedNews((ArrayList<ArticleModel>) articleModelDataMapper
            .transform(bookmarkedNews));
    }

    private void showHeadlines(NewsArticles newsArticles) {
        getView().showHeadlines(
            (ArrayList<ArticleModel>) articleModelDataMapper
                .transform(newsArticles.articles));
    }

    public void destroy() {
        this.getHeadline.dispose();
        this.getBookmarkedNews.dispose();
        setView(null);
    }
}
