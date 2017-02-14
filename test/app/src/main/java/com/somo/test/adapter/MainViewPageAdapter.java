package com.somo.test.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.somo.test.fragment.AFragment;
import com.somo.test.fragment.BFragment;
import com.somo.test.fragment.ChannelFragment;

/**
 * Created by Kimyebon on 2016-09-28.
 */

public class MainViewPageAdapter extends FragmentPagerAdapter {

    //탭 이름은 SlidingTabLayout.java 에서 변경해줘야함
    Fragment[] fragmentList = {new ChannelFragment(), new AFragment(),
            new BFragment()
    };
    public MainViewPageAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
        if (position < fragmentList.length) {
            return fragmentList[position];
        }
        return null;
    }


    @Override
    public String getPageTitle(int position) {
        //not used
        if (position < fragmentList.length) {
            return "";
        }
        return null;
    }
    @Override
    public int getCount() {
        return fragmentList.length;
    }
}