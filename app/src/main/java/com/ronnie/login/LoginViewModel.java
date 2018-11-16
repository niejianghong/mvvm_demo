package com.ronnie.login;

import com.ronnie.base.BaseViewModel;
import com.ronnie.utils.CommonUtils;

import java.util.concurrent.TimeUnit;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

/**
 * Created by Ronnie on 2018/11/12.
 */

public class LoginViewModel extends BaseViewModel<LoginNavigator> {
    public LoginViewModel(LoginNavigator nav) {
        super(nav);
    }

    public void onLoginClick() {
        getNavigator().login();
    }

    public void login(String userName, String password) {
        setIsLoading(true);
        Single.timer(500, TimeUnit.MILLISECONDS).subscribe(new SingleObserver<Long>() {
            @Override
            public void onSubscribe(Disposable d) {
                getCompositeDisposable().add(d);
            }

            @Override
            public void onSuccess(Long aLong) {
                setIsLoading(false);
                getNavigator().openMainActivity();

            }

            @Override
            public void onError(Throwable e) {
                setIsLoading(false);
                getNavigator().handleError(e);
            }
        });

    }

    public boolean isEmailAndPasswordValid(String email, String password) {
        //validate email and password
        if (email == null || email.isEmpty()) {
            return false;
        }
        if (!CommonUtils.isEmailValid(email)) {
            return false;
        }
        if (password == null || password.isEmpty()) {
            return false;
        }
        return true;
    }
}
