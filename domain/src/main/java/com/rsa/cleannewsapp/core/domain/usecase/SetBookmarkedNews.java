package com.rsa.cleannewsapp.core.domain.usecase;

import com.rsa.cleannewsapp.core.domain.entity.Article;
import com.rsa.cleannewsapp.core.domain.repository.NewsArticleRepository;

import java.util.ArrayList;
import java.util.concurrent.Callable;

import javax.inject.Named;

import io.reactivex.Observable;
import io.reactivex.Scheduler;

public class SetBookmarkedNews extends UseCase {

    private final NewsArticleRepository repository;

    public ArrayList<Article> bookmarkedNewsToUpdate = new ArrayList<>();

    public SetBookmarkedNews(
        @Named("executor_thread") Scheduler executorThread,
        @Named("ui_thread") Scheduler uiThread,
        NewsArticleRepository newsArticleRepository
    ) {
        super(executorThread, uiThread);
        this.repository = newsArticleRepository;
    }

    @Override
    protected Observable<Void> createObservableUseCase() {
        return Observable.fromCallable(() -> {
            repository.setBookmarkedNews(bookmarkedNewsToUpdate);
            return null;
        });
    }
}
