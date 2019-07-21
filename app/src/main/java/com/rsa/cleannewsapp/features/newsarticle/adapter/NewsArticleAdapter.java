package com.rsa.cleannewsapp.features.newsarticle.adapter;

import com.rsa.cleannewsapp.core.common.Action;
import com.rsa.cleannewsapp.features.newsarticle.model.ArticleModel;
import com.rsa.cleannewsapp.features.newsarticle.view.NewsArticleViewHolder;

import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import static androidx.recyclerview.widget.RecyclerView.NO_POSITION;

public class NewsArticleAdapter extends RecyclerView.Adapter<NewsArticleViewHolder> {

    private final Action<ArticleModel> onClick;

    private final Action<ArticleModel> onLongClick;

    private ArrayList<ArticleModel> articles = new ArrayList<>();

    private NewsArticleAdapter(
        Action<ArticleModel> onClick,
        Action<ArticleModel> onLongClick) {
        this.onClick = onClick;
        this.onLongClick = onLongClick;
    }

    public static NewsArticleAdapter newInstance(Action<ArticleModel> onClick,
        Action<ArticleModel> onLongClick) {
        return new NewsArticleAdapter(onClick, onLongClick);
    }

    @NonNull
    @Override
    public NewsArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return NewsArticleViewHolder.newInstance(parent, this.onClick, this.onLongClick);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsArticleViewHolder holder, int position) {
        ArticleModel article = getItem(position);
        if (article != null) {
            holder.bind(article);
        }
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    private ArticleModel getItem(int position) {
        if (position != NO_POSITION) {
            return articles.get(position);
        } else {
            return null;
        }
    }

    public void setArticles(ArrayList<ArticleModel> articles) {
        this.articles.clear();
        this.articles.addAll(articles);
        notifyDataSetChanged();
    }
}
