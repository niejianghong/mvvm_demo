package com.ronnie.di.Activity;

import com.ronnie.login.LoginActivity;
import com.ronnie.login.LoginActivityModule;
import com.ronnie.main.MainAcitivityModule;
import com.ronnie.main.MainActivity;
import com.ronnie.splash.SplashActivityModule;
import com.ronnie.splash.SplashActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Ronnie on 2018/4/11.
 */

@Module
public abstract class ActivityBuilder {
    @ActivityScope
    @ContributesAndroidInjector(modules = SplashActivityModule.class)
    abstract SplashActivity bindSplashActivity();

    @ActivityScope
    @ContributesAndroidInjector(modules = LoginActivityModule.class)
    abstract LoginActivity bindLoginActivity();

    @ContributesAndroidInjector(modules = MainAcitivityModule.class)
    abstract MainActivity bindMainActivity();
}
