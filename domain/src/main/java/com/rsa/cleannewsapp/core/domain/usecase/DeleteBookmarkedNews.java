package com.rsa.cleannewsapp.core.domain.usecase;

import com.rsa.cleannewsapp.core.domain.entity.Article;
import com.rsa.cleannewsapp.core.domain.repository.NewsArticleRepository;

import java.util.concurrent.Callable;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Observable;
import io.reactivex.Scheduler;

public class DeleteBookmarkedNews extends CompletableUseCase<Article> {

    private NewsArticleRepository newsArticleRepository;

    @Inject
    public DeleteBookmarkedNews(
        @Named("executor_thread") Scheduler executorThread,
        NewsArticleRepository newsArticleRepository

    ) {
        super(executorThread);
        this.newsArticleRepository = newsArticleRepository;
    }

    @Override
    protected Observable createObservableUseCase(Article article) {
        return Observable.fromCallable((Callable<Object>) () -> {
            newsArticleRepository.deleteBookmarkedNews(article);
            return true;
        });
    }
}
