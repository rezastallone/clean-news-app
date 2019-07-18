package com.rsa.cleannewsapp.features.newsarticle.presenter;

import com.google.gson.Gson;

import com.rsa.cleannewsapp.core.data.entity.NewsArticles;
import com.rsa.cleannewsapp.core.presenter.Presenter;
import com.rsa.cleannewsapp.features.newsarticle.usecase.GetHeadline;
import com.rsa.cleannewsapp.features.newsarticle.view.HeadlineView;

import android.util.Log;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import io.reactivex.observers.DisposableObserver;

public class HeadlinePresenter extends Presenter<HeadlineView> {

    private GetHeadline getHeadline;

    @Inject
    public HeadlinePresenter(
        @NonNull GetHeadline getHeadline) {
        this.getHeadline = getHeadline;
    }

    @Override
    public void initialize() {
        super.initialize();
        getView().showLoading();
        getHeadline.execute(new DisposableObserver<NewsArticles>() {
            @Override
            public void onNext(NewsArticles newsArticles) {
                Log.d("Articles", new Gson().toJson(newsArticles));
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

    public void destroy() {
        this.getHeadline.dispose();
        setView(null);

    }
}
