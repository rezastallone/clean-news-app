package com.rsa.cleannewsapp.features.newsarticle.view;

import com.rsa.cleannewsapp.R;
import com.rsa.cleannewsapp.core.BaseFragment;
import com.rsa.cleannewsapp.core.data.entity.NewsArticles;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class HeadlineFragment extends BaseFragment implements HeadlineView {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
        @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_headline, container, false);
    }

    @Override
    public void showHeadlines(NewsArticles newsArticles) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
