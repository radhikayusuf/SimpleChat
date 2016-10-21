package com.pkl.gits.simplechat.main;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.pkl.gits.simplechat.R;
import com.pkl.gits.simplechat.SimpleChat;
import com.pkl.gits.simplechat.databinding.ActivityMainBinding;
import com.pkl.gits.simplechat.main.viewmodel.MainActivityVM;

import id.gits.mvvmcore.activity.GitsActivity;

public class MainActivity extends GitsActivity<MainActivityVM, ActivityMainBinding> {
    public FirebaseAuth.AuthStateListener mauthListener;
    public FirebaseAuth mAuth;
    public String TAG = SimpleChat.TAG;
    public String id = "";

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

        mAuth = FirebaseAuth.getInstance();
        mauthListener = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user != null){
                    Log.d(TAG, "Main onAuthStateChanged: sign in "+user.getUid());
                    id = user.getUid();
                }else {
                    Log.d(TAG, "Main onAuthStateChanged: sign out");
                }
            }
        };


        return new MainActivityVM(this,id);
    }

    @Override
    public void bindViewModel(ActivityMainBinding binding, MainActivityVM viewModel) {
        binding.setVm(viewModel);

    }
    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mauthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mauthListener != null) {
            mAuth.removeAuthStateListener(mauthListener);
        }
    }
}

