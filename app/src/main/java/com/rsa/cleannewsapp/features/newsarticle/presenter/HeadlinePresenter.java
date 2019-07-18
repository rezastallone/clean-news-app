package com.rsa.cleannewsapp.features.newsarticle.presenter;

import com.rsa.cleannewsapp.core.data.entity.NewsArticles;
import com.rsa.cleannewsapp.core.presenter.Presenter;
import com.rsa.cleannewsapp.features.newsarticle.usecase.GetHeadline;
import com.rsa.cleannewsapp.features.newsarticle.view.HeadlineView;

import io.reactivex.observers.DisposableObserver;

public class HeadlinePresenter extends Presenter<HeadlineView> {

    private GetHeadline getHeadline;

    public HeadlinePresenter(GetHeadline getHeadline) {
        this.getHeadline = getHeadline;
    }

    @Override
    public void initialize() {
        super.initialize();
        getView().showLoading();
        getHeadline.execute(new DisposableObserver<NewsArticles>() {
            @Override
            public void onNext(NewsArticles newsArticles) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    void destroy() {
        this.getHeadline.dispose();
        setView(null);

    }
}
