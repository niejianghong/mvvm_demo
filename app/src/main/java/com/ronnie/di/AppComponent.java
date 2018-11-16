package com.ronnie.di;

import android.app.Application;

import com.ronnie.RonnieApp;
import com.ronnie.di.Activity.ActivityBuilder;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by Ronnie on 2018/4/11.
 */

@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class,ActivityBuilder.class})
public interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

    void inject(RonnieApp app);
}
