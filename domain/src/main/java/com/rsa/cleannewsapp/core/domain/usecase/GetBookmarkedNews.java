package com.rsa.cleannewsapp.core.domain.usecase;

import com.rsa.cleannewsapp.core.domain.entity.Article;
import com.rsa.cleannewsapp.core.domain.repository.NewsArticleRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Observable;
import io.reactivex.Scheduler;

public class GetBookmarkedNews extends UseCase<List<Article>> {

    private NewsArticleRepository newsArticleRepository;

    @Inject
    public GetBookmarkedNews(
        @Named("executor_thread") Scheduler executorThread,
        @Named("ui_thread") Scheduler uiThread,
        NewsArticleRepository newsArticleRepository
    ) {
        super(executorThread, uiThread);
        this.newsArticleRepository = newsArticleRepository;
    }

    @Override
    protected Observable<List<Article>> createObservableUseCase() {
        return newsArticleRepository.bookmarkedNews();
    }
}
