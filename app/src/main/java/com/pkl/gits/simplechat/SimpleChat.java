package com.pkl.gits.simplechat;

import android.app.Application;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by root on 21/10/16.
 */

public class SimpleChat extends Application{
    public static final String TAG = "SAMPLE CHAT";

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
