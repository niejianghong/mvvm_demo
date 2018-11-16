package com.ronnie;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.ronnie.di.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * Created by Ronnie on 2018/4/11.
 */

public class RonnieApp extends Application implements HasActivityInjector {

    public static Context CONTEXT;

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    @Inject
    AndroidLogAdapter androidLogAdapter;

    @Override
    public void onCreate() {
        super.onCreate();
        CONTEXT = this;
        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this);

        initLogger();
    }

    private void initLogger() {
        Logger.clearLogAdapters();
        Logger.addLogAdapter(androidLogAdapter);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }
}
