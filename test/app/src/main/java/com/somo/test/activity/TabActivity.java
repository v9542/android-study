package com.somo.test.activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ViewPropertyAnimatorCompatSet;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import com.somo.test.R;
import com.somo.test.adapter.MainViewPageAdapter;
import com.somo.test.model.Data;
import com.somo.test.view.SlidingTabLayout;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TabActivity extends AppCompatActivity {

    @Bind(R.id.viewPager)
    ViewPager viewPager;
    @Bind(R.id.tabLayout)
    SlidingTabLayout mainTabLayout;
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    MainViewPageAdapter viewPageAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        ButterKnife.bind(this);

        initializeActionBar();
        setTabView();

        task.execute();
    }

    AsyncTask task = new AsyncTask() {
        @Override
        protected Object doInBackground(Object[] params) {
            try {
                Document doc = Jsoup.connect("http://www.melon.com/search/total/index.htm").data("q", "박효신").get();

                Elements songs = doc.select("a.fc_gray");

                for (Element s : songs) {
                    System.out.println(s.text());
                }
            }catch(IOException e) {
                e.printStackTrace();;
            }
            return null;
        }
    };

    private void initializeActionBar() {
        setSupportActionBar(toolbar);
    }

    protected void setTabView() {
        viewPageAdapter = new MainViewPageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPageAdapter);
        mainTabLayout.setViewPager(viewPager);
        mainTabLayout.setCustomTabView(R.layout.sliding_tab, R.id.tab_title);
        viewPager.setOffscreenPageLimit(1);
    }
}
