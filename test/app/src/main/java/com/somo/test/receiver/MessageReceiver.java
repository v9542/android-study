package com.somo.test.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.somo.test.R;
import com.somo.test.util.PixelCalculator;

/**
 * Created by yebonkim on 2017. 1. 12..
 */

public class MessageReceiver extends BroadcastReceiver {

    static View imageView;
    WindowManager wM;
    Drawable drawable;
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "test", Toast.LENGTH_SHORT).show();
        imageView = new View(context);
        wM = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        drawable = context.getResources().getDrawable(R.drawable.bg_speech);

        if(intent.getBooleanExtra("isOn", true))
            wM.removeView(imageView);
        else
            addImageView();


        Bundle pudsBundle = intent.getExtras();
        Object[] pdus = (Object[]) pudsBundle.get("pdus");
        SmsMessage messages = SmsMessage.createFromPdu((byte[]) pdus[0]);
        Toast.makeText(context, messages.getMessageBody(), Toast.LENGTH_SHORT).show();
        if (messages.getMessageBody().contains("Hi")) {
            abortBroadcast();
        }
    }

    protected void addImageView() {
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
}