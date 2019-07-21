package com.rsa.cleannewsapp.core.domain.usecase;

import com.rsa.cleannewsapp.core.domain.entity.Article;
import com.rsa.cleannewsapp.core.domain.repository.NewsArticleRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Observable;
import io.reactivex.Scheduler;

public class GetHeadline extends UseCase<List<Article>> {

    private NewsArticleRepository newsArticleRepository;

    @Inject
    public GetHeadline(
        @Named("executor_thread") Scheduler executorThread,
        @Named("ui_thread") Scheduler uiThread,
        NewsArticleRepository newsArticleRepository) {
        super(executorThread, uiThread);
        this.newsArticleRepository = newsArticleRepository;
    }

    @Override
    protected Observable<List<Article>> createObservableUseCase() {
        return Observable.zip(this.newsArticleRepository.headlines("id"),
            this.newsArticleRepository.bookmarkedNews(),
            (articles, articles2) -> {

                List<Article> filteredList = filterNotBookmarkedNewsOnly(articles, articles2);

                return filteredList;
            });
    }

    private List<Article> filterNotBookmarkedNewsOnly(List<Article> articles,
        List<Article> articles2) {
        List<Article> filteredList = new ArrayList<>();
        HashSet<String> bookmarkedNews = new HashSet<>();

        for (Article article : articles2) {
            bookmarkedNews.add(article.url);
        }

        for (Article article : articles) {
            if (!bookmarkedNews.contains(article.url)) {
                filteredList.add(article);
            }
        }
        return filteredList;
    }
}
