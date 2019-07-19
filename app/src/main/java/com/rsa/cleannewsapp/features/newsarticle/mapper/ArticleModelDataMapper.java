package com.rsa.cleannewsapp.features.newsarticle.mapper;

import com.rsa.cleannewsapp.core.domain.entity.Article;
import com.rsa.cleannewsapp.features.newsarticle.model.ArticleModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.inject.Inject;

import androidx.annotation.NonNull;

/**
 * Mapper class used to transform {@link Article} (in the domain layer) to {@link ArticleModel} in
 * the app layer.
 */

public class ArticleModelDataMapper {

    @Inject
    public ArticleModelDataMapper() {
    }

    public ArticleModel transform(@NonNull Article article) {
        return ArticleModel.fromArticle(article);
    }

    public Collection<ArticleModel> transform(@NonNull Collection<Article> articles) {
        Collection<ArticleModel> articleModelCollection;

        if (!articles.isEmpty()) {
            articleModelCollection = new ArrayList();
            for (Article article : articles) {
                articleModelCollection.add(ArticleModel.fromArticle(article));
            }
        } else {
            articleModelCollection = Collections.emptyList();
        }
        return articleModelCollection;
    }

}
