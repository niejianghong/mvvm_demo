package com.ronnie.splash;

import com.ronnie.base.BaseViewModel;

import java.util.concurrent.TimeUnit;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

/**
 * Created by Ronnie on 2018/11/12.
 */

public class SplashViewModel extends BaseViewModel<SplashNavigator> {
    public SplashViewModel(SplashNavigator nav) {
        super(nav);
    }

    public void startNavigator() {
        Single.timer(500, TimeUnit.MILLISECONDS).subscribe(new SingleObserver<Long>() {
            @Override
            public void onSubscribe(Disposable d) {
                getCompositeDisposable().add(d);
            }

            @Override
            public void onSuccess(Long aLong) {
                getNavigator().openLoginActivity();

            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

}
