package com.example.qrscanner.helper;


import android.content.Context;


import com.example.qrscanner.constant.Constants;
import com.example.qrscanner.db.QRCodeItem;
import com.example.qrscanner.utils.SharedPreferencesUtils;

import java.util.ArrayList;
import java.util.List;

public class CodeHelper implements Constants {
    private static List<QRCodeItem> callRecordList = new ArrayList<>();

    public static void updateAllLists(Context context) {
        SharedPreferencesUtils.initSharedReferences(context);
        try {
            callRecordList.clear();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
