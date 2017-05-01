package com.somo.test.server.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by yebonkim on 2017. 4. 6..
 */

public class Person {
    @SerializedName("id")
    public int id;
    public String name;
    public int age;
    public long datetime;

    public Person(int id, String name, int age, long datetime) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.datetime = datetime;
    }
}
