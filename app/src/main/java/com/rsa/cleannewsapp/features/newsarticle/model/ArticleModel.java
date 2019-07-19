package com.rsa.cleannewsapp.features.newsarticle.model;

import com.rsa.cleannewsapp.core.domain.entity.Article;

public class ArticleModel {

    public final String author;

    public final String description;

    public final String sourceName;

    public final String title;

    public final String url;

    public final String urlToImage;

    private ArticleModel(String author, String description, String sourceName, String title,
        String url, String urlToImage) {
        this.author = author;
        this.description = description;
        this.sourceName = sourceName;
        this.title = title;
        this.url = url;
        this.urlToImage = urlToImage;
    }

    public static ArticleModel fromArticle(Article article) {
        return new ArticleModel(
            article.author,
            article.description,
            article.source.name,
            article.title,
            article.url,
            article.urlToImage
        );
    }
}
