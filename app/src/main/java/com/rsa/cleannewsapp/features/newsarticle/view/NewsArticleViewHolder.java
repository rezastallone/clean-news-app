package com.rsa.cleannewsapp.features.newsarticle.view;

import com.bumptech.glide.Glide;
import com.rsa.cleannewsapp.R;
import com.rsa.cleannewsapp.core.common.Action;
import com.rsa.cleannewsapp.core.data.entity.Article;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsArticleViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.iv_news_image)
    ImageView IvNewsImage;

    @BindView(R.id.rltv_wrapper_news_article)
    RelativeLayout RltvWrapperNewsArticle;

    @BindView(R.id.tv_news_author)
    TextView TvNewsAuthor;

    @BindView(R.id.tv_news_description)
    TextView TvNewsDescription;

    @BindView(R.id.tv_news_title)
    TextView TvNewsTitle;

    private Action onClick;

    private NewsArticleViewHolder(@NonNull View itemView, @NonNull Action<Article> onClick) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.onClick = onClick;
    }

    public static NewsArticleViewHolder newInstance(ViewGroup parent, Action<Article> onClick) {
        return new NewsArticleViewHolder(
            LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_news_article, parent, false), onClick);
    }

    public void bind(Article article) {
        bindArticleInformation(article);
        bindArticleImage(article);
        bindClick(article);
    }

    private void bindArticleInformation(Article article) {
        TvNewsAuthor.setText(article.author);
        TvNewsTitle.setText(article.title);
        TvNewsDescription.setText(article.description);
    }

    private void bindArticleImage(Article article) {
        Glide
            .with(itemView.getContext())
            .load(article.urlToImage)
            .centerCrop()
            .into(IvNewsImage);
    }

    private void bindClick(Article article) {
        itemView.setOnClickListener(view -> {
            onClick.call(article);
        });
    }
}
