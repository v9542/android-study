package com.somo.test.activity;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.RemoteViews;
import android.widget.TextView;

import com.somo.test.R;
import com.somo.test.model.Data;
import com.somo.test.receiver.MessageReceiver;
import com.somo.test.util.PixelCalculator;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SplashActivity extends AppCompatActivity {

    Handler mHandler;
    NotificationManager manager;
    Notification noti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        Intent onIntent = new Intent(this, SplashActivity.class).putExtra("isOn", false).setAction("ON_ACTION");
        Intent offIntent = new Intent(this, MessageReceiver.class).putExtra("isOn", true).setAction("OFF_ACTION");
        PendingIntent onPIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), onIntent , PendingIntent.FLAG_UPDATE_CURRENT);

        PendingIntent offPIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), offIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        noti = new Notification.Builder(this).setContentTitle(getResources().getString(R.string.app_name))
                .setContentText("아메리카노가 할인중입니다")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setOngoing(true)
                .addAction(R.drawable.btn_green_highlight, "On", onPIntent)
                .addAction(R.drawable.library_btn_navermap_bg, "Off", offPIntent)
                .build();

        mHandler = new Handler();
        mHandler.postDelayed(runnable, 2 * 1000);

        IntentFilter intentFilter = new IntentFilter();

        intentFilter.addAction("android.provider.Telephony.SMS_RECEIVED");

        registerReceiver(new MessageReceiver(), intentFilter);

//        addImageView();
    }

    protected void addImageView() {
        WindowManager wM = ((WindowManager) getApplicationContext()
                .getSystemService(Context.WINDOW_SERVICE));


        View imageView = new View(this);
        imageView.setBackground(getResources().getDrawable(R.drawable.bg_speech));

        wM.addView(imageView, makeLayout(Gravity.BOTTOM|Gravity.CENTER_VERTICAL));
    }

    protected WindowManager.LayoutParams makeLayout(int gravity) {
        WindowManager.LayoutParams layout = new WindowManager.LayoutParams();

        layout.type = WindowManager.LayoutParams.TYPE_SYSTEM_ERROR;
        layout.gravity = gravity;
        layout.flags =
                WindowManager.LayoutParams.FLAG_FULLSCREEN |
                        WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL |
                        WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE |
                        WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS |
                        WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN |
                        WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH;

        layout.width = PixelCalculator.dpToPx(80);

        layout.height = PixelCalculator.dpToPx(350);

        layout.format = PixelFormat.RGBA_8888;

        return layout;
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            manager.notify(0, noti);
            startActivity(new Intent(SplashActivity.this, RadioActivity.class));
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        unregisterReceiver();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1000) {
            if(resultCode == Activity.RESULT_OK) {
                data.getStringExtra("asdf");
            }
        }
    }
}