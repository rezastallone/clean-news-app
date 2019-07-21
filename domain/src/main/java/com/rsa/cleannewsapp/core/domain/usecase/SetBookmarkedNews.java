package com.rsa.cleannewsapp.core.domain.usecase;

import com.rsa.cleannewsapp.core.domain.entity.Article;
import com.rsa.cleannewsapp.core.domain.repository.NewsArticleRepository;

import java.util.ArrayList;
import java.util.concurrent.Callable;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Observable;
import io.reactivex.Scheduler;

public class SetBookmarkedNews extends CompletableUseCase<Article> {

    private final NewsArticleRepository repository;

    @Inject
    public SetBookmarkedNews(
        @Named("executor_thread") Scheduler executorThread,
        NewsArticleRepository newsArticleRepository
    ) {
        super(executorThread);
        this.repository = newsArticleRepository;
    }

    @Override
    protected Observable<Object> createObservableUseCase(Article articles) {
        return Observable.fromCallable((Callable<Boolean>) () -> {
            repository.setBookmarkedNews(articles);
            return true;
        });
    }
}
