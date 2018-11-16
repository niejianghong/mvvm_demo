package com.ronnie.login;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ronnie.R;
import com.ronnie.base.BindingActivity;
import com.ronnie.databinding.ActivityLoginBinding;
import com.ronnie.main.MainActivity;
import com.ronnie.utils.ToastUtils;

import javax.inject.Inject;

/**
 * Created by Ronnie on 2018/11/12.
 */

public class LoginActivity extends BindingActivity<ActivityLoginBinding, LoginViewModel> implements LoginNavigator {
    @Inject
    LoginViewModel loginViewModel;

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = getViewDataBinding();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected LoginViewModel getViewModel() {
        return loginViewModel;
    }

    @Override
    public void login() {
        String email = binding.loginUsernameText.getEditText().getText().toString();
        String password = binding.loginPasswordInput.getEditText().getText().toString();

        if (loginViewModel.isEmailAndPasswordValid(email, password)) {
            hideKeyboard();
            loginViewModel.login(email, password);
        } else {
            ToastUtils.showToast("Please provide a valid email and password");
        }
    }

    @Override
    public void openMainActivity() {
        startActivity(MainActivity.class);
        finish();
    }

    @Override
    public void createAccount() {

    }

    @Override
    public void forgetPassword() {

    }
}
