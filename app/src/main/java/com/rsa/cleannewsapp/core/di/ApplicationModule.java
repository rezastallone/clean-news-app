package com.rsa.cleannewsapp.core.di;

import com.rsa.cleannewsapp.CleanNewsApplication;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

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

}
