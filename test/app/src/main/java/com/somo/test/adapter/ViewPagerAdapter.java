package com.somo.test.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.somo.test.fragment.ImageFragment;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private ArrayList<ImageFragment> mFragments;
    private ViewPager mPager;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);

        mFragments = new ArrayList<>();
    }

    @Override
    public Fragment getItem(int i) {
        return mFragments.get(i%mFragments.size());
    }

    public void setmFragments(ArrayList<ImageFragment> mFragments) {
        this.mFragments = mFragments;
        notifyDataSetChanged();
    }

    public void add(ImageFragment parallaxFragment) {
        mFragments.add(parallaxFragment);
        notifyDataSetChanged();
        mPager.setCurrentItem(getCount() - 1, true);

    }

    public void remove(int i) {
        mFragments.remove(i);
        notifyDataSetChanged();
    }

    public void remove(ImageFragment parallaxFragment) {
        mFragments.remove(parallaxFragment);

        int pos = mPager.getCurrentItem();
        notifyDataSetChanged();

        mPager.setAdapter(this);
        if (pos >= this.getCount()) {
            pos = this.getCount() - 1;
        }
        mPager.setCurrentItem(pos, true);
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    public void setPager(ViewPager pager) {
        mPager = pager;
    }
}
