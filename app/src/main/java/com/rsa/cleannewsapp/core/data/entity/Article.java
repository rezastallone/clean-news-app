package com.rsa.cleannewsapp.core.data.entity;

public class Article {

    public final String author;

    public final String content;

    public final String description;

    public final String publishedAt;

    public final Source source;

    public final String title;

    public final String url;

    public final String urlToImage;

    public Article(Source source, String author, String title, String description,
        String url, String urlToImage, String publishedAt, String content) {
        this.source = source;
        this.author = author;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
        this.content = content;
    }
}
