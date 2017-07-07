package com.example.yebonkim.etawett;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.yebonkim.etawett.common.PermissionList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkAndRequestPermission();
        Intent i = new Intent(MainActivity.this, GalleryActivity.class);
        startActivity(i);
        finish();
    }

    public void checkAndRequestPermission() {
        int result;

        String[] permissionList = PermissionList.list;

        ActivityCompat.requestPermissions(this, permissionList, 1);
//        for (int i = 0; i < permissionList.length; i++) {
//            Log.d("Yebon", "adsfa");
//            result = ActivityCompat.checkSelfPermission(this, permissionList[i]);
//            if (result != PackageManager.PERMISSION_GRANTED) {
//                ActivityCompat.requestPermissions(this, permissionList, 1);
//            }
//        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1) {
            if (resultCode == RESULT_OK) {
                Intent i = new Intent(MainActivity.this, GalleryActivity.class);
                startActivity(i);
                finish();
            }
        }
        }
}
