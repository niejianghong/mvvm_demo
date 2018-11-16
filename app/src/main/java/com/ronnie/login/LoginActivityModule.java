package com.ronnie.login;

import com.ronnie.di.Activity.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ronnie on 2018/11/12.
 */

@Module
public class LoginActivityModule {
    @Provides
    @ActivityScope
    LoginViewModel provideLoginViewModel(LoginActivity loginActivity) {
        LoginViewModel model = new LoginViewModel(loginActivity);
        return model;
    }
}
