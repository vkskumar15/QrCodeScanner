package com.example.qrscanner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.os.Bundle;
import android.widget.Toast;

import com.example.qrscanner.constant.Constants;
import com.example.qrscanner.databinding.ActivityMainBinding;
import com.example.qrscanner.utils.QRResult;
import com.example.qrscanner.utils.SharedPreferencesUtils;
import com.example.qrscanner.views.VikasQrScannerView;
import com.google.zxing.Result;

public class MainActivity extends AppCompatActivity implements VikasQrScannerView.ResultHandler, QRResult.OnClickListener, Constants {
    ActivityMainBinding binding;
    static int CODE_READ_EXTERNAL = 1378;
    int flag = 0;
    private boolean isAutoFocus = true;
    private boolean isSquare = false;

    public static AppCompatActivity newInstance() {

        return new MainActivity();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        checkPermission(Manifest.permission.CAMERA, CODE_READ_EXTERNAL);


        initView();
    }

    private void initView() {

        SharedPreferencesUtils.setMainScreenType(MAIN_SCREEN_QR);

    }


    @Override
    public void handleResult(Result rawResult) {
        stopScanner();
        QRResult.showQRResultDialog(MainActivity.this, rawResult.getText(), MainActivity.this);
    }

    public void startScanner() {
        binding.scannerView.setResultHandler(this);
        binding.scannerView.startCamera();
        binding.scannerView.setFormats();
        binding.scannerView.setAutoFocus(isAutoFocus);
        binding.scannerView.setSquareViewFinder(isSquare);
    }

    public void stopScanner() {
        binding.scannerView.stopCamera();
    }

    public void resumeScanner() {

        binding.scannerView.resumeCameraPreview(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        startScanner();
    }

    @Override
    public void onPause() {
        super.onPause();
        stopScanner();
    }

    @Override
    public void onClick() {
        startScanner();
    }

    public void checkPermission(String permission, int requestCode) {
        if (ContextCompat.checkSelfPermission(MainActivity.this, permission) == -1) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{permission}, requestCode);
            return;
        }
        Toast.makeText(MainActivity.this, "Permission already granted", Toast.LENGTH_SHORT).show();
        flag = 1;
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode != CODE_READ_EXTERNAL) {
            return;
        }
        if (grantResults.length <= 0 || grantResults[0] != 0) {
            Toast.makeText(MainActivity.this, "Read Storage Permission Denied", Toast.LENGTH_SHORT).show();
            return;
        }
        flag = 1;
    }

}