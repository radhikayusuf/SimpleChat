package com.pkl.gits.simplechat.main;

import com.pkl.gits.simplechat.R;
import com.pkl.gits.simplechat.databinding.ActivityMainBinding;
import com.pkl.gits.simplechat.main.viewmodel.MainActivityVM;

import id.gits.mvvmcore.activity.GitsActivity;

public class MainActivity extends GitsActivity<MainActivityVM, ActivityMainBinding> {

    @Override
    protected int getToolbarId() {
        return 0;
    }

    @Override
    public int getResLayout() {
        return R.layout.activity_main;
    }

    @Override
    public MainActivityVM getViewModel() {
        return new MainActivityVM(this);
    }

    @Override
    public void bindViewModel(ActivityMainBinding binding, MainActivityVM viewModel) {
        binding.setVm(viewModel);
    }
}
