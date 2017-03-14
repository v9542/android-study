package com.somo.test.model;

import java.io.Serializable;

/**
 * Created by K on 2016-11-12.
 */

public class Data implements Serializable{
    public int id;
    public int profile;
    public String address;
    public String name;
    public String position;


    public Data() {

    }

    public Data(int id, int profile, String address, String name, String position) {
        this.id = id;
        this.profile = profile;
        this.address = address;
        this.name = name;
        this.position = position;
    }
}