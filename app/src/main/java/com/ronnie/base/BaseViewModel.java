package com.ronnie.base;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableBoolean;

import io.reactivex.disposables.CompositeDisposable;


/**
 * Created by Ronnie on 2018/11/12.
 */

public abstract class BaseViewModel<N> extends ViewModel {
    private N navigator;
    private final CompositeDisposable compositeDisposable;
    private final ObservableBoolean isLoading;

    public BaseViewModel(N nav) {
        compositeDisposable = new CompositeDisposable();
        isLoading = new ObservableBoolean(false);
        this.navigator = nav;
    }

    public CompositeDisposable getCompositeDisposable() {
        return compositeDisposable;
    }

    public N getNavigator() {
        return navigator;
    }

    public void setNavigator(N navigator) {
        this.navigator = navigator;
    }

    public ObservableBoolean getIsLoading() {
        return isLoading;
    }

    public void setIsLoading(boolean isLoading) {
        this.isLoading.set(isLoading);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.clear();
    }
}
