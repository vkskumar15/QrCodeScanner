package com.example.qrscanner.helper;

import android.content.Context;

import com.example.qrscanner.db.DatabaseHelper;
import com.j256.ormlite.android.apptools.OpenHelperManager;


public class FactoryHelper {
    private static DatabaseHelper databaseHelper;

    public static DatabaseHelper getHelper(){
        return databaseHelper;
    }
    public static void setHelper(Context context){
        databaseHelper = OpenHelperManager.getHelper(context, DatabaseHelper.class);
    }
    public static void releaseHelper(){
        OpenHelperManager.releaseHelper();
        databaseHelper = null;
    }
}
