package com.rsa.cleannewsapp.features.newsarticle.presenter;

import com.rsa.cleannewsapp.core.domain.entity.Article;
import com.rsa.cleannewsapp.core.domain.usecase.DeleteBookmarkedNews;
import com.rsa.cleannewsapp.core.domain.usecase.GetBookmarkedNews;
import com.rsa.cleannewsapp.core.domain.usecase.GetHeadline;
import com.rsa.cleannewsapp.core.domain.usecase.SetBookmarkedNews;
import com.rsa.cleannewsapp.core.presenter.Presenter;
import com.rsa.cleannewsapp.features.newsarticle.mapper.ArticleModelDataMapper;
import com.rsa.cleannewsapp.features.newsarticle.model.ArticleModel;
import com.rsa.cleannewsapp.features.newsarticle.view.HeadlineView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import io.reactivex.observers.DisposableObserver;

public class HeadlinePresenter extends Presenter<HeadlineView> {

    private final DeleteBookmarkedNews deleteBookmarkedNews;

    private final GetBookmarkedNews getBookmarkedNews;

    private final SetBookmarkedNews setBookmarkedNews;

    private ArticleModelDataMapper articleModelDataMapper;

    private GetHeadline getHeadline;

    @Inject
    public HeadlinePresenter(
        @NonNull GetHeadline getHeadline,
        @NonNull GetBookmarkedNews getBookmarkedNews,
        @NonNull SetBookmarkedNews setBookmarkedNews,
        @NonNull DeleteBookmarkedNews deleteBookmarkedNews,
        ArticleModelDataMapper articleModelDataMapper
    ) {
        this.getHeadline = getHeadline;
        this.getBookmarkedNews = getBookmarkedNews;
        this.setBookmarkedNews = setBookmarkedNews;
        this.deleteBookmarkedNews = deleteBookmarkedNews;
        this.articleModelDataMapper = articleModelDataMapper;
    }

    @Override
    public void initialize() {
        super.initialize();
        getView().showLoading();
        executeGetBookmarkedNews();
        executeGetHeadlines();
    }

    private void executeGetBookmarkedNews() {
        getBookmarkedNews.execute(new DisposableObserver<List<Article>>() {

            @Override
            public void onNext(List<Article> articles) {
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
        getHeadline.execute(new DisposableObserver<List<Article>>() {

            @Override
            public void onNext(List<Article> articles) {
                showHeadlines(articles);
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

    private void showBookmarkedNews(List<Article> bookmarkedNews) {
        ArrayList<ArticleModel> articlesToShow = new ArrayList<>(articleModelDataMapper
            .transform(bookmarkedNews));
        getView().showBookmarkedNews(articlesToShow);
    }

    private void showHeadlines(List<Article> newsArticles) {
        ArrayList<ArticleModel> articlesToShow = new ArrayList(articleModelDataMapper
            .transform(newsArticles));
        getView().showHeadlines(articlesToShow);
    }

    public void setBookmarkedNews(ArticleModel articleModel) {
        setBookmarkedNews
            .execute(articleModelDataMapper.transformBack(articleModel), new DisposableObserver() {
                @Override
                public void onNext(Object o) {

                }

                @Override
                public void onError(Throwable e) {
                    e.printStackTrace();
                }

                @Override
                public void onComplete() {

                }
            });
    }

    public void removeBookmarkedNews(ArticleModel articleModel) {
        deleteBookmarkedNews.execute(articleModelDataMapper.transformBack(articleModel),
            new DisposableObserver() {
                @Override
                public void onNext(Object o) {

                }

                @Override
                public void onError(Throwable e) {
                    e.printStackTrace();
                }

                @Override
                public void onComplete() {

                }
            });
    }

    public void destroy() {
        this.getHeadline.dispose();
        this.getBookmarkedNews.dispose();
        this.setBookmarkedNews.dispose();
        this.deleteBookmarkedNews.dispose();
        setView(null);
    }
}
