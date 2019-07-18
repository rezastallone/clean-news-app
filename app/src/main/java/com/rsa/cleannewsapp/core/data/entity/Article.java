package com.rsa.cleannewsapp.core.data.entity;

public class Article {

    final String author;

    final String content;

    final String description;

    final String publishedAt;

    final Source source;

    final String title;

    final String url;

    final String urlToImage;

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
