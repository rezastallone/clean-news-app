package com.rsa.cleannewsapp.core.domain.usecase;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class CompletableUseCase<Param> {

    private final CompositeDisposable compositeDisposable;

    private final Scheduler executorThread;

    public CompletableUseCase(Scheduler executorThread) {
        this.executorThread = executorThread;
        compositeDisposable = new CompositeDisposable();
    }

    public Disposable execute(Param param) {
        Disposable disposable = this.createObservableUseCase(param)
            .subscribeOn(executorThread)
            .observeOn(executorThread)
            .subscribe();
        compositeDisposable.add(disposable);
        return disposable;
    }

    protected abstract Observable createObservableUseCase(Param param);

    public void dispose() {
        if (!compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }
}
