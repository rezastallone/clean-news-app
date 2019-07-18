package com.rsa.cleannewsapp.features.newsarticle.adapter;

import com.rsa.cleannewsapp.core.common.Action;
import com.rsa.cleannewsapp.core.data.entity.Article;
import com.rsa.cleannewsapp.features.newsarticle.view.NewsArticleViewHolder;

import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import static androidx.recyclerview.widget.RecyclerView.NO_POSITION;

public class NewsArticleAdapter extends RecyclerView.Adapter<NewsArticleViewHolder> {

    private final Action<Article> onClick;

    private ArrayList<Article> articles = new ArrayList<>();

    private NewsArticleAdapter(
        Action<Article> onClick) {
        this.onClick = onClick;
    }

    public static NewsArticleAdapter newInstance(Action<Article> onClick) {
        return new NewsArticleAdapter(onClick);
    }

    @NonNull
    @Override
    public NewsArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return NewsArticleViewHolder.newInstance(parent, this.onClick);
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

    public void setArticles(ArrayList<Article> articles) {
        this.articles.addAll(articles);
        notifyDataSetChanged();
    }
}
