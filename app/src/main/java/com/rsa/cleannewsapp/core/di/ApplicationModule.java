package com.rsa.cleannewsapp.core.di;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.rsa.cleannewsapp.CleanNewsApplication;
import com.rsa.cleannewsapp.core.data.remote.RemoteServiceFactory;
import com.rsa.cleannewsapp.core.data.repository.DefaultNewsArticleRepository;
import com.rsa.cleannewsapp.core.data.repository.datasource.NewsArticleLocalDataStore;
import com.rsa.cleannewsapp.core.data.repository.datasource.NewsArticleRemoteDataStore;
import com.rsa.cleannewsapp.core.domain.repository.NewsArticleRepository;

import android.content.Context;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

@Module
public class ApplicationModule {

    private final CleanNewsApplication cleanNewsApplication;

    public ApplicationModule(CleanNewsApplication cleanNewsApplication) {
        this.cleanNewsApplication = cleanNewsApplication;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return cleanNewsApplication;
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(Gson gson) {
        return RemoteServiceFactory.getRemoteService(gson);
    }

    @Provides
    @Singleton
    NewsArticleRemoteDataStore provideNewsArticleRemoteDataStore(Retrofit retrofit) {
        return new NewsArticleRemoteDataStore(retrofit);
    }

    @Provides
    @Singleton
    NewsArticleLocalDataStore provideNewsArticleLocalDataStore() {
        return new NewsArticleLocalDataStore();
    }

    @Provides
    @Singleton
    NewsArticleRepository provideNewsArticleRepository(NewsArticleRemoteDataStore remoteDataStore,
        NewsArticleLocalDataStore localDataSource) {
        return new DefaultNewsArticleRepository(remoteDataStore, localDataSource);
    }

    @Provides
    @Named("executor_thread")
    Scheduler provideExecutorThread() {
        return Schedulers.io();
    }

    @Provides
    @Named("ui_thread")
    Scheduler provideUiThread() {
        return AndroidSchedulers.mainThread();
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
            .create();
    }
}
