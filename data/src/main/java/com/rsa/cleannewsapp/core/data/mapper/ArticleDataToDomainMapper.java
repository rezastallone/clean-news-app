package com.rsa.cleannewsapp.core.data.mapper;

import com.rsa.cleannewsapp.core.data.entity.Source;
import com.rsa.cleannewsapp.core.domain.entity.Article;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import androidx.annotation.NonNull;

public class ArticleDataToDomainMapper {

    public ArticleDataToDomainMapper() {
    }

    public Collection<Article> transform(
        @NonNull Collection<com.rsa.cleannewsapp.core.data.entity.Article> articles) {
        Collection<Article> articleModelCollection;

        if (!articles.isEmpty()) {
            articleModelCollection = new ArrayList();
            for (com.rsa.cleannewsapp.core.data.entity.Article article : articles) {
                articleModelCollection.add(transform(article));
            }
        } else {
            articleModelCollection = Collections.emptyList();
        }
        return articleModelCollection;
    }

    public Article transform(@NonNull com.rsa.cleannewsapp.core.data.entity.Article article) {
        return new Article(
            article.source.name,
            article.author,
            article.title,
            article.description,
            article.url,
            article.urlToImage,
            article.publishedAt,
            article.content
        );
    }

    public com.rsa.cleannewsapp.core.data.entity.Article transformBack(Article article) {
        return new com.rsa.cleannewsapp.core.data.entity.Article(
            new Source(article.sourceName),
            article.author,
            article.title,
            article.description,
            article.url,
            article.urlToImage,
            article.publishedAt,
            article.content
        );
    }

}
