package com.pkl.gits.simplechat.login.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.pkl.gits.simplechat.SimpleChat;
import com.pkl.gits.simplechat.main.MainActivity;

import id.gits.mvvmcore.viewmodel.GitsVM;

/**
 * Created by root on 21/10/16.
 */

public class LoginActivityVM extends GitsVM {
    public FirebaseAuth auth;
    public String TAG = SimpleChat.TAG;
    public ObservableField<String> LoginEmail = new ObservableField<>();
    public ObservableField<String> LoginPass = new ObservableField<>();

    public LoginActivityVM(Context context, FirebaseAuth mauth) {
        super(context);
        auth = mauth;
        LoginEmail.set("maqiel2600@gmail.com");
        LoginPass.set("sararesaja132");
    }


    public void onClickLogin(View v){
        auth.signInWithEmailAndPassword(LoginEmail.get(),LoginPass.get()).addOnCompleteListener(((Activity) mContext), new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Log.d(TAG, "onComplete: Success " + task.isSuccessful());
                    Intent in = new Intent(mContext, MainActivity.class);
                    mContext.startActivity(in);
                }else {
                    Log.d(TAG, "onFailed: Failed " + task.getException());
                }
            }
        });
    }
}
