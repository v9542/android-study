package com.somo.test.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.somo.test.R;
import com.somo.test.adapter.MyRecyclerViewAdapter;
import com.somo.test.adapter.ViewPagerAdapter;
import com.somo.test.fragment.ImageFragment;
import com.somo.test.model.Data;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ActionBarActivity extends AppCompatActivity {
    @Bind(R.id.viewPager)
    ViewPager viewPager;

    ViewPagerAdapter adapter;

    ArrayList<ImageFragment> fragmentList;
    int dataSize;
    int[] img = {R.drawable.bg_speech, R.drawable.btn_green_pressed, R.drawable.btn_green_normal};
    Handler transformHandler;
    boolean isPlaying;
    int nowPageIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);
        ButterKnife.bind(this);


        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.setPager(viewPager); //only for this transformer
        setData();
        transformHandler = new Handler();
        transformHandler.postDelayed(transformPageRunnable, 2*1000);
        viewPager.setOnPageChangeListener(pageChangeListener);
    }

    private void setData() {
        Bundle bundleTmp;
        ImageFragment fragmentTmp;

        fragmentList = new ArrayList<ImageFragment>();
        dataSize = 3;
        for (int i = 0; i < dataSize; i++) {
            bundleTmp = new Bundle();
            bundleTmp.putInt("image", img[i]);
            fragmentTmp = new ImageFragment();
            fragmentTmp.setArguments(bundleTmp);
            fragmentList.add(fragmentTmp);
            adapter.add(fragmentTmp);
        }
    }

    Runnable transformPageRunnable = new Runnable() {
        @Override
        public void run() {

                if (nowPageIndex == dataSize) {
                    setPageToPre();
                    loadNextData();
                } else {
                    nowPageIndex++;
                }

                viewPager.setCurrentItem(nowPageIndex);

                if (isPlaying) {
                    transformHandler.postDelayed(this, 2 * 1000);
                }
        }
    };


    protected void setPageToPre() {
        viewPager.setCurrentItem(nowPageIndex - 1);
    }


    private void loadNextData() {
        ImageFragment nextScreen;
        int tmp;

        nextScreen = fragmentList.get(0);
        fragmentList.remove(0);
        fragmentList.add(dataSize - 1, nextScreen);
        tmp = img[0];
        img[0] = img[1];
        img[1] = img[2];
        img[2]=tmp;
        if (isPlaying) {
            adapter.setmFragments(fragmentList);
        }
    }


    ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            nowPageIndex = position;
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            if (state == 1 && nowPageIndex == dataSize-1) {
                setPageToPre();
                loadNextData();
                viewPager.setCurrentItem(nowPageIndex);
            }
        }
    };
}
