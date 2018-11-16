package com.ronnie.login;

import com.ronnie.base.BaseNavigator;

/**
 * Created by Ronnie on 2018/11/12.
 */

public interface LoginNavigator extends BaseNavigator {
    void login();

    void openMainActivity();

    void createAccount();

    void forgetPassword();
}
