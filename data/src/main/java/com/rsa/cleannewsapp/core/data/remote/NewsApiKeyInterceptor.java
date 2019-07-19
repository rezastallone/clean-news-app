package com.rsa.cleannewsapp.core.data.remote;


import com.rsa.cleannewsapp.core.data.BuildConfig;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class NewsApiKeyInterceptor implements Interceptor {

    private final static String NEWS_API_KEY = BuildConfig.NEWS_API_KEY;

    private final static String NEWS_API_KEY_PARAM = "apiKey";

    @Override
    public Response intercept(Chain chain) throws IOException {
        HttpUrl url = chain.request().url()
            .newBuilder()
            .addQueryParameter(NEWS_API_KEY_PARAM, NEWS_API_KEY)
            .build();
        Request request = chain.request().newBuilder().url(url).build();
        return chain.proceed(request);
    }
}
