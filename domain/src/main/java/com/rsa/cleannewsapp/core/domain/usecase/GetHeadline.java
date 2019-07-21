package com.rsa.cleannewsapp.core.domain.usecase;

import com.rsa.cleannewsapp.core.domain.entity.Article;
import com.rsa.cleannewsapp.core.domain.repository.NewsArticleRepository;

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
        return this.newsArticleRepository.headlines("id");
    }
}
