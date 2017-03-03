package com.somo.test.model.expandable;

import com.bignerdranch.expandablerecyclerview.model.Parent;

import java.io.Serializable;
import java.util.List;

/**
 * Created by K on 2016-11-12.
 */

public class AppParent implements Parent<Child> {
    public String name;
    public List<Child> child;

    public AppParent(String name, List<Child> child) {
        this.name = name;
        this.child = child;
    }

    @Override
    public List<Child> getChildList() {
        return child;
    }

    @Override
    public boolean isInitiallyExpanded() {
        return false;
    }
}