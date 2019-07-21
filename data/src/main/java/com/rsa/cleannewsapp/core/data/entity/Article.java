package com.rsa.cleannewsapp.core.data.entity;

import androidx.annotation.NonNull;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Article {

    public final String author;

    public final String content;

    public final String description;

    public final Boolean isBookmarked;

    public final String publishedAt;

    @Embedded
    public final Source source;

    public final String title;

    @PrimaryKey
    @NonNull
    public final String url;

    public final String urlToImage;

    public Article(Source source, String author, String title, String description,
        String url, String urlToImage, String publishedAt, String content, Boolean isBookmarked) {
        this.source = source;
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
