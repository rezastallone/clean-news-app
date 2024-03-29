package com.rsa.cleannewsapp.features.newsarticle.view;

import com.rsa.cleannewsapp.CleanNewsApplication;
import com.rsa.cleannewsapp.R;
import com.rsa.cleannewsapp.core.BaseFragment;
import com.rsa.cleannewsapp.core.common.Action;
import com.rsa.cleannewsapp.features.newsarticle.adapter.NewsArticleAdapter;
import com.rsa.cleannewsapp.features.newsarticle.model.ArticleModel;
import com.rsa.cleannewsapp.features.newsarticle.presenter.HeadlinePresenter;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class HeadlineFragment extends BaseFragment implements HeadlineView {

    private final Action<ArticleModel> onClick = article -> {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(article.url));
        startActivity(browserIntent);
    };

    @BindView(R.id.rv_bookmarked)
    RecyclerView RvBookmarked;

    @BindView(R.id.rv_headline)
    RecyclerView RvHeadline;

    @Inject
    HeadlinePresenter headlinePresenter;

    private NewsArticleAdapter bookmarkedNewsArticleAdapter;

    private NewsArticleAdapter newsArticleAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
        @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_headline, container, false);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        headlinePresenter.destroy();
    }

    @Override
    public void initView() {
        super.initView();
        initializeButterKnife();
        initializeDagger();
        initializePresenter();
        initializeHeadlineList();
        initializeBookmarkedNewsList();
    }

    private void initializeButterKnife() {
        ButterKnife.bind(this, getView());
    }

    private void initializeDagger() {
        CleanNewsApplication cleanNewsApplication = (CleanNewsApplication) getActivity()
            .getApplication();
        cleanNewsApplication.getApplicationComponent().inject(this);
    }

    private void initializePresenter() {
        headlinePresenter.setView(this);
        headlinePresenter.initialize();
    }

    private void initializeHeadlineList() {
        initializeHeadlineAdapter();
        RvHeadline.setAdapter(newsArticleAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),
            LinearLayoutManager.HORIZONTAL, false);
        RvHeadline.setLayoutManager(linearLayoutManager);
    }

    private void initializeBookmarkedNewsList() {
        initializeBookmarkedAdapter();
        RvBookmarked.setAdapter(bookmarkedNewsArticleAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),
            LinearLayoutManager.HORIZONTAL, false);
        RvBookmarked.setLayoutManager(linearLayoutManager);
    }

    private void initializeHeadlineAdapter() {
        newsArticleAdapter = NewsArticleAdapter.newInstance(onClick, articleToBookmark -> {
            headlinePresenter.setBookmarkedNews(articleToBookmark);
        });
    }

    private void initializeBookmarkedAdapter() {
        bookmarkedNewsArticleAdapter = NewsArticleAdapter.newInstance(onClick,
            articleModel -> {
                headlinePresenter.removeBookmarkedNews(articleModel);
            });
    }

    @Override
    public void showHeadlines(ArrayList<ArticleModel> headlines) {
        newsArticleAdapter.setArticles(headlines);
    }

    @Override
    public void showBookmarkedNews(ArrayList<ArticleModel> bookmarkedNews) {
        bookmarkedNewsArticleAdapter.setArticles(bookmarkedNews);
    }

    @Override
    public void showLoading() {
        Toast.makeText(getContext(), "loading", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideLoading() {

    }
}
