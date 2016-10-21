package com.pkl.gits.simplechat.login;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.pkl.gits.simplechat.R;
import com.pkl.gits.simplechat.SimpleChat;
import com.pkl.gits.simplechat.databinding.ActivityLoginBinding;
import com.pkl.gits.simplechat.login.viewmodel.LoginActivityVM;

import id.gits.mvvmcore.activity.GitsActivity;

public class LoginActivity extends GitsActivity<LoginActivityVM, ActivityLoginBinding> {
    public FirebaseAuth.AuthStateListener mauthListener;
    public FirebaseAuth mAuth;
    public String TAG = SimpleChat.TAG;

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

        mAuth = FirebaseAuth.getInstance();
        mauthListener = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user != null){
                    Log.d(TAG, "onAuthStateChanged: sign in "+user.getUid());
                }else {
                    Log.d(TAG, "onAuthStateChanged: sign out");
                }
            }
        };


        return new LoginActivityVM(this,mAuth);
    }

    @Override
    public void bindViewModel(ActivityLoginBinding binding, LoginActivityVM viewModel) {
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
