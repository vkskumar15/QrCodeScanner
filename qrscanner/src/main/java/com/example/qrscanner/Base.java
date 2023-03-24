package com.example.qrscanner;

import android.app.Application;
import android.content.Context;

import com.example.qrscanner.helper.FactoryHelper;
import com.example.qrscanner.utils.SharedPreferencesUtils;


public class Base extends Application {

    @Override
    public void onCreate() {
        super.onCreate();


        SharedPreferencesUtils.initSharedReferences(this);
        FactoryHelper.setHelper(getApplicationContext());
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }
}
