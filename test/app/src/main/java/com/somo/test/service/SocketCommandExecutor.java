package com.somo.test.service;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import com.somo.test.activity.MainActivity;

import org.bson.BSONObject;

/**
 * Created by Kimyebon on 2016-09-30.
 */

public class SocketCommandExecutor extends SocketNamespace{
    Context context;
    LocalBroadcastManager broadcastManager;

    public SocketCommandExecutor(Context context) {
        this.context = context;
        broadcastManager = LocalBroadcastManager.getInstance(context);
    }

    public void execute(byte namespace, BSONObject bsonObject) {
        if (Looper.myLooper() == null)
        {
            Looper.prepare();
        }
        switch (namespace) {
            case CHANNER_BANNED:
                sendBroadcastMessage(IntentMessage.CHANNEL_UPDATED_INTENT, IntentMessage.CHANNEL_UPDATED_MESSAGE, "");
                break;
            case CHANNER_INVITED:
            case CHANNER_UPDATED:
                sendBroadcastMessage(IntentMessage.CHANNEL_UPDATED_INTENT, IntentMessage.CHANNEL_UPDATED_MESSAGE, "");
                break;
            case FORCE_LOGOUT:
                context.startActivity(new Intent(context, MainActivity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                        .putExtra("Logout", true)
                );
                break;
        }
    }

    protected void sendBroadcastMessage(String intentName, String messageName, String message) {
        broadcastManager.sendBroadcast(new Intent(intentName).putExtra(messageName, message));
    }

    protected int bsonObjectToId(BSONObject bsonObject) {
        return (int)bsonObject.get("id");
    }


//    protected Employee bsonObjectToEmployee(BSONObject bsonObject) {
//        Employee sender = new Employee();
//
//        sender.setFirst_name((String)bsonObject.get("first_name"));
//        sender.setLast_name((String)bsonObject.get("last_name"));
//        sender.setPosition((Position) bsonObject.get("position"));
//        sender.setUserid((String)bsonObject.get("userid"));
//
//        return sender;
//    }
}