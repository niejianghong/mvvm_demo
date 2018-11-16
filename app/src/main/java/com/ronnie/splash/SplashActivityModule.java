package com.ronnie.splash;

import com.ronnie.di.Activity.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ronnie on 2018/11/12.
 */
@Module
public class SplashActivityModule {
    @Provides
    @ActivityScope
    SplashViewModel provideSplashViewModel(SplashActivity activity) {
        SplashViewModel model = new SplashViewModel(activity);
        return model;
    }
}
