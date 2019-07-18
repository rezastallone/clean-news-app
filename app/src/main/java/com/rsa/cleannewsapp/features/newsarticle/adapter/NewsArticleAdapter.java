package com.rsa.cleannewsapp.features.newsarticle.adapter;

import com.rsa.cleannewsapp.core.data.entity.Article;
import com.rsa.cleannewsapp.features.newsarticle.view.NewsArticleViewHolder;

import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import static androidx.recyclerview.widget.RecyclerView.NO_POSITION;

public class NewsArticleAdapter extends RecyclerView.Adapter<NewsArticleViewHolder> {

    private ArrayList<Article> articles;

    public static NewsArticleAdapter fromArticles(ArrayList<Article> articles) {
        return new NewsArticleAdapter(articles);
    }

    private NewsArticleAdapter(ArrayList<Article> articles) {
        this.articles = articles;
    }

    @NonNull
    @Override
    public NewsArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return NewsArticleViewHolder.fromViewGroup(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsArticleViewHolder holder, int position) {
        Article article = getItem(position);
        if (article != null) {
            holder.bind(article);
        }
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    private Article getItem(int position) {
        if (position != NO_POSITION) {
            return articles.get(position);
        } else {
            return null;
        }
    }
}
