package com.rsa.cleannewsapp.core.di;

import com.rsa.cleannewsapp.features.newsarticle.view.HeadlineFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(HeadlineFragment headlineFragment);
}
