package com.ronnie.di;

import android.app.Application;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.PrettyFormatStrategy;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ronnie on 2018/4/11.
 */
@Module
public class AppModule {
    @Provides
    @Singleton
    RefWatcher provideRefWatcher(Application application) {
        return LeakCanary.install(application);
    }

    @Provides
    @Singleton
    FormatStrategy provideFormatStrategy() {
        return PrettyFormatStrategy.newBuilder()
                .showThreadInfo(true)  // (Optional) Whether to show thread info or not. Default true
                .methodCount(0)         // (Optional) How many method line to show. Default 2
//                .methodOffset(3)        // (Optional) Skips some method invokes in stack trace. Default 5
//        .logStrategy(customLog) // (Optional) Changes the log strategy to print out. Default LogCat
                .tag("Ronnie")   // (Optional) Custom tag for each log. Default PRETTY_LOGGER
                .build();
    }

    @Provides
    @Singleton
    AndroidLogAdapter provideAndroidLogAdapter(FormatStrategy formatStrategy) {
        return new AndroidLogAdapter(formatStrategy);
    }
}
