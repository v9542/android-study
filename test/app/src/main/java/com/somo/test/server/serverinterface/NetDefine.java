package com.somo.test.server.serverinterface;

/**
 * Created by Omjoon on 16. 2. 1..
 */
public class NetDefine {
    public static final String PATH = "192.168.43.249";
    public static final int PORT = 5000;
    public static final int SOCKET_PORT = 8000;

    public static String getBasicPath() {
        return "http://"+PATH+":"+PORT;
    }


    public static String getSocketPath() {
        return PATH;
    }

    public static int getSocketPort() {
        return PORT;
    }

}
