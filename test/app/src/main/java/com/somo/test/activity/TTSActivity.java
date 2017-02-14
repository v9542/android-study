package com.somo.test.activity;

import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.balysv.materialmenu.MaterialMenuDrawable;
import com.somo.test.R;
import com.somo.test.adapter.MainViewPageAdapter;
import com.somo.test.adapter.MyRecyclerViewAdapter;
import com.somo.test.model.Data;
import com.somo.test.view.SlidingTabLayout;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TTSActivity extends AppCompatActivity implements TextToSpeech.OnInitListener{
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.drawerLayout)
    DrawerLayout drawerLayout;
    @Bind(R.id.drawerRecyclerView)
    RecyclerView recyclerView;
    @Bind(R.id.image)
    ImageView imageView;

    TextToSpeech tts;
    MaterialMenuDrawable materialMenu;
    MyRecyclerViewAdapter adapter;
    List<Data> data;

    boolean direction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tts);
        ButterKnife.bind(this);

        initializeActionBar();
        drawerInit();
        recyclerViewInit();
        tts = new TextToSpeech(this, this);
//        AnimationDrawable animationDrawable = (AnimationDrawable)imageView.getBackground();
//        animationDrawable.start();
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.alphaani);
        imageView.startAnimation(animation);
    }

    private void initializeActionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (direction) {
                    drawerLayout.closeDrawer(Gravity.LEFT);
                } else {
                    drawerLayout.openDrawer(Gravity.LEFT);
                }
            }
        });
        materialMenu = new MaterialMenuDrawable(this, Color.WHITE, MaterialMenuDrawable.Stroke.REGULAR);
//        materialMenu.setIconState(MaterialMenuDrawable.IconState.ARROW);
        toolbar.setNavigationIcon(materialMenu);
    }

    private void drawerInit() {
        drawerLayout.setDrawerListener(new DrawerLayout.SimpleDrawerListener() {

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                materialMenu.setTransformationOffset(
                        MaterialMenuDrawable.AnimationState.BURGER_ARROW,
                        direction ? 2 - slideOffset : slideOffset
                );
            }

            @Override
            public void onDrawerOpened(android.view.View drawerView) {
                direction = true;
            }

            @Override
            public void onDrawerClosed(android.view.View drawerView) {
                direction = false;
            }
        });
    }

    private void recyclerViewInit() {
        data = new ArrayList<Data>();
        setData();
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        adapter = new MyRecyclerViewAdapter(this, data);
        recyclerView.setAdapter(adapter);
    }

    private void setData() {
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
//        for(int i=0; i<3; i++) {
//            data.add(temp);
//            data.add(temp2);
//        }
    }

    @Override
    public void onInit(int status) {
        if(status == TextToSpeech.SUCCESS) {
            String msg = "모히토";
            String msg2 = "안드로이드";

            tts.speak(msg, TextToSpeech.QUEUE_FLUSH, null);
            tts.speak(msg2, TextToSpeech.QUEUE_ADD, null);
        }
    }


    @Override
    protected void onStop() {
        super.onStop();
        drawerLayout.closeDrawer(Gravity.LEFT);
    }

    @Override
    public void onBackPressed() {
        drawerLayout.closeDrawer(Gravity.LEFT);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        tts.shutdown();
    }
}
