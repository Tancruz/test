package com.example.serviceexample;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

import org.greenrobot.eventbus.EventBus;

public class MyIntentService extends IntentService {

    public static final String TAG="Ausree";

    public MyIntentService() {
        super("Hello");
        Log.i(TAG, "MyIntentService: Default constructor is running on "+ Thread.currentThread().getName());
    }

//    public MyIntentService(String name) {
//        super(name);
//        Log.i(TAG, "MyIntentService: Parameterised constructor is running on "+ Thread.currentThread().getName());
//    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "MyIntentService: onCreate is running on "+ Thread.currentThread().getName());
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.i(TAG, "MyIntentService: onHandleIntent is running on "+ Thread.currentThread().getName());

        Bundle b = intent.getBundleExtra("bundle");
        int st=b.getInt("sleepTime");
        //int st=intent.getIntExtra("sleepTime",0);

        try {
            Thread.sleep(st);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "MyIntentService: onDestroy is running on "+ Thread.currentThread().getName());
        EventBus.getDefault().post(new Pojo());
    }
}
