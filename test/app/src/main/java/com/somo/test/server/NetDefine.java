package com.somo.test.server;

/**
 * Created by Omjoon on 16. 2. 1..
 */
public class NetDefine {
    public static final String PATH = "52.78.146.99";
    public static final int PORT = 5555;

    public static String getBasicPath() {
        return "http://"+PATH;
    }

    public static String getSocketPath() {
        return PATH;
    }


}
