package com.rsa.cleannewsapp.core.di;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.rsa.cleannewsapp.CleanNewsApplication;
import com.rsa.cleannewsapp.core.data.remote.RemoteServiceFactory;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
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
    Gson provideGson() {
        return new GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
            .create();
    }
}
