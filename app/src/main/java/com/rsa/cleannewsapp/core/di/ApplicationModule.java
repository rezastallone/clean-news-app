package com.rsa.cleannewsapp.core.di;

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
    Retrofit provideRetrofit() {
        return RemoteServiceFactory.getRemoteService();
    }
}
