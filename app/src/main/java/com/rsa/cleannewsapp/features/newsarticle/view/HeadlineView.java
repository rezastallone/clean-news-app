package com.rsa.cleannewsapp.features.newsarticle.view;

import com.rsa.cleannewsapp.core.presenter.Presenter;
import com.rsa.cleannewsapp.features.newsarticle.model.ArticleModel;

import java.util.ArrayList;

public interface HeadlineView extends Presenter.View {

    void showHeadlines(ArrayList<ArticleModel> headlines);

}
