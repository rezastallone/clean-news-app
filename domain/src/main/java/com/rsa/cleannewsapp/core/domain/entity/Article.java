package com.rsa.cleannewsapp.core.domain.entity;

public class Article {

    public final String author;

    public final String content;

    public final String description;

    public final Boolean isBookmarked;

    public final String publishedAt;

    public final String sourceName;

    public final String title;

    public final String url;

    public final String urlToImage;

    public Article(String sourceName, String author, String title, String description,
        String url, String urlToImage, String publishedAt, String content, Boolean isBookmarked) {
        this.sourceName = sourceName;
        this.author = author;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
        this.content = content;
        this.isBookmarked = isBookmarked;
    }
}
