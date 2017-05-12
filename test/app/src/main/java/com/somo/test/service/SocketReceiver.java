package com.somo.test.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.somo.test.server.serverinterface.NetDefine;

import org.bson.BSONObject;
import org.bson.BasicBSONDecoder;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Created by Kimyebon on 2016-09-30.
 */

public class SocketReceiver extends Service {
    private Socket mSocket;

    private BufferedWriter writer;
    private DataInputStream inputStream;

    private String mAddr;
    private int mPort;
    private final int timeout = 5*1000;
    private static boolean mConnected = false;

    protected Context context;
    protected Thread thread;
    protected boolean isServiceAlive;

    SocketCommandExecutor commandExecutor;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        initialize();
        return START_NOT_STICKY;
    }

    protected void initialize() {
        isServiceAlive = true;
        context = getApplicationContext();
        mAddr = NetDefine.getSocketPath();
        mPort = NetDefine.getSocketPort();
        commandExecutor = new SocketCommandExecutor(context);
        mConnected = false;
        thread = new Thread(runnable);
        thread.start();

    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            BSONObject bsonObject;
            BasicBSONDecoder bsonDecoder = new BasicBSONDecoder();

            byte version, namespace;

            short totalLength;
            long timestamp;
            byte[] data;

            connect();

            while (isServiceAlive) {

                if(mConnected) {
                    try {
                        version = inputStream.readByte();
                        namespace = inputStream.readByte();
                        totalLength = inputStream.readShort();
                        timestamp = inputStream.readLong();
                        data = new byte[totalLength];
                        inputStream.read(data);

                        bsonObject = bsonDecoder.readObject(data);

                        commandExecutor.execute(namespace, bsonObject);
                    } catch (IOException e) {
                        e.printStackTrace();
                        disConnect();
                    }
                }else {
                    try {
                        Thread.sleep(30 * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    connect();
                }
            }
        }
    };

    protected boolean connect() {
        try {
            if (mConnected)
                return true;

            SocketAddress socketAddress = new InetSocketAddress(mAddr, mPort);
            mSocket = new Socket();

            mSocket.connect(socketAddress, timeout);

            writer = new BufferedWriter(new OutputStreamWriter(mSocket.getOutputStream()));
            inputStream = new DataInputStream(mSocket.getInputStream());

//            sendString(SharedPreferencesManager.getInstance(context).getToken());

            mConnected = true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean disConnect() {
        if (mConnected == false)
            return true;
        try {
            inputStream.close();
            writer.close();
            mConnected = false;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public void sendString(String str) {
        if (str == null)
            return;

        PrintWriter out = new PrintWriter(writer, true);
        out.println(str);
    }

    public boolean isConnected() {
        return mConnected;
    }

    @Override
    public void onDestroy() {
        isServiceAlive = false;
        super.onDestroy();
    }
}