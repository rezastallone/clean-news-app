package com.rsa.cleannewsapp;

import com.rsa.cleannewsapp.core.di.ApplicationComponent;
import com.rsa.cleannewsapp.core.di.ApplicationModule;
import com.rsa.cleannewsapp.core.di.DaggerApplicationComponent;

import android.app.Application;

public class CleanNewsApplication extends Application {

    private ApplicationComponent applicationComponent;

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initializeInjector();
    }

    private void initializeInjector() {
        applicationComponent = DaggerApplicationComponent.builder()
            .applicationModule(new ApplicationModule(this)).build();
    }
}
