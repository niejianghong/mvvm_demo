package com.ronnie.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.ronnie.BR;

/**
 * Created by Ronnie on 2018/11/12.
 */

public abstract class BindingActivity<VB extends ViewDataBinding, VM extends BaseViewModel<? extends BaseNavigator>> extends BaseActivity
        implements BaseNavigator{
    private VB viewDataBinding;
    private VM viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        performDataBinding();
    }

    private void performDataBinding() {
        viewDataBinding = DataBindingUtil.setContentView(this, getLayout());
        viewModel = viewModel == null ? getViewModel() : viewModel;
        viewDataBinding.setVariable(getBindingVariable(), viewModel);
        viewDataBinding.executePendingBindings();
    }

    public VB getViewDataBinding() {
        return viewDataBinding;
    }

    protected int getBindingVariable() {
        return BR.viewModel;
    }

    @LayoutRes
    protected abstract int getLayout();

    protected abstract VM getViewModel();
}
