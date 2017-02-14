package com.somo.test;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

/**
 * Created by yebonkim on 2016. 12. 1..
 */

public class Util {
    public static void showDialog(Context context, String description, String title, String okMessage) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(description)
                .setTitle(title)
                .setCancelable(false)
                .setPositiveButton(okMessage, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
        builder.show();
    }
}
