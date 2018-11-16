package com.ronnie.base;

/**
 * Created by Ronnie on 2018/11/12.
 */

public interface BaseNavigator {
    default void handleError(Throwable throwable) {
        throwable.printStackTrace();
    }
}
