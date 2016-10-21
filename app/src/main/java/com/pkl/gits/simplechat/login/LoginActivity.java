package com.pkl.gits.simplechat.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.pkl.gits.simplechat.R;
import com.pkl.gits.simplechat.databinding.ActivityLoginBinding;
import com.pkl.gits.simplechat.login.viewmodel.LoginActivityVM;

import id.gits.mvvmcore.activity.GitsActivity;

public class LoginActivity extends GitsActivity<LoginActivityVM, ActivityLoginBinding> {


    @Override
    protected int getToolbarId() {
        return 0;
    }

    @Override
    public int getResLayout() {
        return R.layout.activity_login;
    }

    @Override
    public LoginActivityVM getViewModel() {
        return new LoginActivityVM(this);
    }

    @Override
    public void bindViewModel(ActivityLoginBinding binding, LoginActivityVM viewModel) {
        binding.setVm(viewModel);
    }
}
