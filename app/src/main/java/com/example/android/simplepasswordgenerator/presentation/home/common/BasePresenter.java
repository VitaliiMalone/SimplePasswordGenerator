package com.example.android.simplepasswordgenerator.presentation.home.common;

public interface BasePresenter<V> {
    void attachView(V view);

    void detachView();
}
