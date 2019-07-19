package com.rsa.cleannewsapp.features.newsarticle.view;

import com.bumptech.glide.Glide;
import com.rsa.cleannewsapp.R;
import com.rsa.cleannewsapp.core.common.Action;
import com.rsa.cleannewsapp.features.newsarticle.model.ArticleModel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsArticleViewHolder extends RecyclerView.ViewHolder {

    private final Action<ArticleModel> onLongClick;

    @BindView(R.id.iv_news_image)
    ImageView IvNewsImage;

    @BindView(R.id.tv_news_author)
    TextView TvNewsAuthor;

    @BindView(R.id.tv_news_description)
    TextView TvNewsDescription;

    @BindView(R.id.tv_news_title)
    TextView TvNewsTitle;

    private Action onClick;

    private NewsArticleViewHolder(@NonNull View itemView,
        @NonNull Action<ArticleModel> onClick,
        Action<ArticleModel> onLongClick) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.onClick = onClick;
        this.onLongClick = onLongClick;
    }

    public static NewsArticleViewHolder newInstance(ViewGroup parent,
        Action<ArticleModel> onClick,
        Action<ArticleModel> onLongClick) {
        return new NewsArticleViewHolder(
            LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_news_article, parent, false), onClick, onLongClick);
    }

    public void bind(ArticleModel article) {
        bindArticleInformation(article);
        bindArticleImage(article);
        bindClick(article);
        bindLongClick(article);
    }

    private void bindArticleInformation(ArticleModel article) {
        TvNewsAuthor.setText(article.author);
        TvNewsTitle.setText(article.title);
        TvNewsDescription.setText(article.description);
    }

    private void bindArticleImage(ArticleModel article) {
        Glide
            .with(itemView.getContext())
            .load(article.urlToImage)
            .centerCrop()
            .into(IvNewsImage);
    }

    private void bindClick(ArticleModel article) {
        itemView.setOnClickListener(view -> {
            onClick.call(article);
        });
    }

    private void bindLongClick(ArticleModel article) {
        itemView.setOnLongClickListener(view -> {
            onLongClick.call(article);
            return true;
        });
    }
}
