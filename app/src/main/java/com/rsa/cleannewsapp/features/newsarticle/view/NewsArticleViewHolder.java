package com.rsa.cleannewsapp.features.newsarticle.view;

import com.rsa.cleannewsapp.R;
import com.rsa.cleannewsapp.core.data.entity.Article;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsArticleViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.iv_news_image)
    ImageView IvNewsImage;

    @BindView(R.id.tv_news_author)
    TextView TvNewsAuthor;

    @BindView(R.id.tv_news_description)
    TextView TvNewsDescription;

    @BindView(R.id.tv_news_title)
    TextView TvNewsTitle;

    private NewsArticleViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(itemView);
    }

    public static NewsArticleViewHolder fromViewGroup(ViewGroup parent) {
        return new NewsArticleViewHolder(
            parent.inflate(parent.getContext(), R.layout.item_news_article, parent));
    }

    public void bind(Article article) {
        TvNewsAuthor.setText(article.author);
        TvNewsTitle.setText(article.title);
        TvNewsDescription.setText(article.description);
    }
}
