package com.somo.test.model.expandable;

import java.io.Serializable;

/**
 * Created by K on 2016-11-12.
 */

public class Child implements Serializable{
    public String name;

    public Child(String name) {
        this.name = name;
    }
}