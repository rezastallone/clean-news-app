package com.rsa.cleannewsapp.core.domain.usecase;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class CompletableUseCase {

    private final CompositeDisposable compositeDisposable;

    private final Scheduler executorThread;

    public CompletableUseCase(Scheduler executorThread) {
        this.executorThread = executorThread;
        compositeDisposable = new CompositeDisposable();
    }

    public void execute() {
        Disposable disposable = this.createObservableUseCase()
            .subscribeOn(executorThread)
            .observeOn(executorThread)
            .subscribe();
        compositeDisposable.add(disposable);
    }

    protected abstract Observable createObservableUseCase();

    public void dispose() {
        if (!compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }
}
