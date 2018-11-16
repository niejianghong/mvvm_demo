package com.ronnie.splash;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ronnie.R;
import com.ronnie.base.BindingActivity;
import com.ronnie.databinding.ActivitySplashBinding;
import com.ronnie.login.LoginActivity;
import com.ronnie.main.MainActivity;

import javax.inject.Inject;

/**
 * Created by Ronnie on 2018/11/12.
 */

public class SplashActivity extends BindingActivity<ActivitySplashBinding, SplashViewModel> implements SplashNavigator {
    @Inject
    SplashViewModel splashViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        splashViewModel.startNavigator();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_splash;
    }

    @Override
    protected SplashViewModel getViewModel() {
        return splashViewModel;
    }


    @Override
    public void openLoginActivity() {
        startActivity(LoginActivity.class);
    }

    @Override
    public void openMainActivity() {
        startActivity(MainActivity.class);
    }
}
