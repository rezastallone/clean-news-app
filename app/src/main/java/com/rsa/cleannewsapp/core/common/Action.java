package com.rsa.cleannewsapp.core.common;

public interface Action<T> {
    void call(T type);
}
