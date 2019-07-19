package com.rsa.cleannewsapp.core.domain.usecase;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;

public abstract class CompletableUseCase<Param> {

    private final CompositeDisposable compositeDisposable;

    private final Scheduler executorThread;

    public CompletableUseCase(Scheduler executorThread) {
        this.executorThread = executorThread;
        compositeDisposable = new CompositeDisposable();
    }

    public void execute(Param param, Observer observer) {

        if (observer == null) {
            throw new IllegalArgumentException("disposableObserver must not be null");
        }

        this.createObservableUseCase(param)
            .subscribeOn(executorThread)
            .observeOn(executorThread)
            .subscribe(observer);
    }

    protected abstract Observable createObservableUseCase(Param param);

    public void dispose() {
        if (!compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }
}
