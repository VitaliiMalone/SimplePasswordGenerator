package com.example.android.simplepasswordgenerator.presentation.home.common;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dagger.android.support.AndroidSupportInjection;

public abstract class BaseFragment<Binding extends ViewDataBinding> extends Fragment {
    private static final String LOG_TAG = BaseFragment.class.getSimpleName();

    private Binding binding;
    protected Context mContext;

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false);
        initView();
        return binding.getRoot();
    }

    public Binding getBinding() {
        return binding;
    }

    public abstract BasePresenter getPresenter();

    @LayoutRes
    public abstract int getLayoutRes();

    protected abstract void initView();

    @Override
    public void onDestroy() {
        mContext = null;
        if (getPresenter() != null) {
            getPresenter().detachView();
        }
        super.onDestroy();
    }

}
