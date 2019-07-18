package com.rsa.cleannewsapp.features.newsarticle.view;

import com.rsa.cleannewsapp.CleanNewsApplication;
import com.rsa.cleannewsapp.R;
import com.rsa.cleannewsapp.core.BaseFragment;
import com.rsa.cleannewsapp.core.data.entity.NewsArticles;
import com.rsa.cleannewsapp.features.newsarticle.presenter.HeadlinePresenter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class HeadlineFragment extends BaseFragment implements HeadlineView {

    @Inject
    HeadlinePresenter headlinePresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
        @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_headline, container, false);
    }

    @Override
    public void initView() {
        super.initView();
        initializeDagger();
    }

    private void initializeDagger() {
        CleanNewsApplication cleanNewsApplication = (CleanNewsApplication) getActivity()
            .getApplication();
        cleanNewsApplication.getApplicationComponent().inject(this);
    }

    @Override
    public void showHeadlines(NewsArticles newsArticles) {

    }

    @Override
    public void showLoading() {
        Toast.makeText(getContext(), "loading", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideLoading() {

    }
}
