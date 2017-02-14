package com.somo.test.activity;

import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.somo.test.R;
import com.somo.test.adapter.MyRecyclerViewAdapter;
import com.somo.test.model.Data;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ActionBarActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    boolean scroll_down;
    ArrayList<Data> data;

    MyRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actionbar);
        ButterKnife.bind(this);

        initializeActionBar();

        setData();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, data);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnScrollListener(scrollListener);

    }


    private void setData() {
        data = new ArrayList<>();
        Data temp = new Data();
        temp.profile = R.mipmap.ic_launcher;
        temp.address = "주소";
        temp.name = "text test";
        temp.position = "직업";
        Data temp2 = new Data();
        temp.profile = R.mipmap.ic_launcher;
        temp.address = "주소2";
        temp.name = "text2 test2";
        temp.position = "직업2";
        data.add(temp);
        data.add(temp2);
        for(int i=0; i<3; i++) {
            data.add(temp);
            data.add(temp2);
        }
    }

    RecyclerView.OnScrollListener scrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);

            if(scroll_down)
                getSupportActionBar().show();
            else
                getSupportActionBar().hide();
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);


            if (dy > 70) {
                //scroll down
                scroll_down = true;

            } else if (dy < -5) {
                //scroll up
                scroll_down = false;
            }
        }
    };

    private void initializeActionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("aaa");
    }

}
