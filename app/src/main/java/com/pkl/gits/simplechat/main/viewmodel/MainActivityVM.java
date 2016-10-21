package com.pkl.gits.simplechat.main.viewmodel;

import android.content.Context;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.pkl.gits.simplechat.SimpleChat;
import com.pkl.gits.simplechat.main.dao.RelationDao;
import com.pkl.gits.simplechat.main.dao.UserDao;

import java.util.ArrayList;
import java.util.List;

import id.gits.mvvmcore.viewmodel.GitsVM;

/**
 * Created by root on 21/10/16.
 */

public class MainActivityVM extends GitsVM {
    public String TAG = SimpleChat.TAG;
    List<RelationDao> relationDaos = new ArrayList<>();
    private DatabaseReference databaseReference;
    private DatabaseReference databaseReference2;

    public MainActivityVM(Context context, final String id) {
        super(context);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("relation").child(id);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()){
                    Log.wtf(TAG, "key: "+  ds.getKey() +" => id" + id);
                    if(ds.getKey().equalsIgnoreCase(id)){
                        Log.d(TAG, "onDataChangenya : "+ds.toString());
                    }
                        /*
                        relationDaos.add(datas.getValue(RelationDao.class));
                        Log.d(TAG, "State Hasil : "+(datas.getValue(RelationDao.class).getFriend_state()));
                    */
                    //}
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

//        Log.d(TAG, "MainActivityVM: id :"+id);
//        databaseReference2 = databaseReference.child(id);
//
//        databaseReference2.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                Log.d(TAG, "onDataChange12: "+dataSnapshot.toString());
//                for(DataSnapshot ds : dataSnapshot.getChildren()){
//                    Log.d(TAG, "onDataChange22: "+ds.toString());
//                    for(DataSnapshot datas : ds.getChildren()){
//                        Log.d(TAG, "onDataChange32: "+datas.toString());
//                        /*
//                        relationDaos.add(datas.getValue(RelationDao.class));
//                        Log.d(TAG, "State Hasil : "+(datas.getValue(RelationDao.class).getFriend_state()));
//                    */
//                    }
//                }
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
    }
}
