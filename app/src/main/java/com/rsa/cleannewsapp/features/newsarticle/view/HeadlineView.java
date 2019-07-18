package com.rsa.cleannewsapp.features.newsarticle.view;

import com.rsa.cleannewsapp.core.data.entity.NewsArticles;
import com.rsa.cleannewsapp.core.presenter.Presenter;

public interface HeadlineView extends Presenter.View {

    void showHeadlines(NewsArticles newsArticles);

}
