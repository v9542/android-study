package com.somo.test.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.somo.test.R;
import com.somo.test.adapter.ExpandableAdapter;
import com.somo.test.adapter.MyRecyclerViewAdapter;
import com.somo.test.model.Data;
import com.somo.test.model.expandable.AppParent;
import com.somo.test.model.expandable.Child;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ExpandableActivity extends AppCompatActivity {
    @Bind(R.id.expandable)
    RecyclerView expandable;

    ExpandableAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable);
        ButterKnife.bind(this);

        Child c1 = new Child("a");
        Child c2 = new Child("b");
        Child c3 = new Child("c");
        Child c4 = new Child("d");
        Child c5 = new Child("e");
        Child c6 = new Child("f");
        Child c7 = new Child("g");

        List<Child> lc1 = new ArrayList<>();
        lc1.add(c1);
        lc1.add(c2);
        lc1.add(c3);
        lc1.add(c4);

        List<Child> lc2 = new ArrayList<>();
        lc2.add(c5);
        lc2.add(c6);
        lc2.add(c7);

        AppParent p1 = new AppParent("p", lc1);
        AppParent p2 = new AppParent("p2", lc2);

        List<AppParent> data = new ArrayList<>();
        data.add(p1);
        data.add(p2);

        adapter = new ExpandableAdapter(this, data);

        expandable.setAdapter(adapter);
        expandable.setLayoutManager(new LinearLayoutManager(this));

    }

}
