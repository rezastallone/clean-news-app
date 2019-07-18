package com.rsa.cleannewsapp.core.data.remote;

import com.google.gson.Gson;

import com.rsa.cleannewsapp.BuildConfig;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemoteServiceFactory {

    private final static String BASE_URL =
        BuildConfig.NEWS_API_DOMAIN + "/" + BuildConfig.NEWS_API_VERSION + "/";

    private RemoteServiceFactory() {

    }

    public static Retrofit getRemoteService(Gson gson) {
        return new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(createClient())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();
    }

    private static OkHttpClient createClient() {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        addNewsApiKeyInterceptor(okHttpClientBuilder);
        return okHttpClientBuilder.build();
    }

    private static void addNewsApiKeyInterceptor(OkHttpClient.Builder okHttpClientBuilder) {
        okHttpClientBuilder.addInterceptor(new NewsApiKeyInterceptor());
    }

}
