package com.hxnidc.radiogroupviewpage;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.hxnidc.radiogroupviewpage.fragment.Fragment1;
import com.hxnidc.radiogroupviewpage.fragment.Fragment2;
import com.hxnidc.radiogroupviewpage.fragment.Fragment3;

/**
 * Created by on 2017/6/18 16:07
 * Author：yrg
 * Describe:
 */


class MainTabAdapter extends FragmentPagerAdapter {
    private String[] mTitles = new String[]{"", "", ""};
    private int[] datas = null;

    public MainTabAdapter(FragmentManager fm, int[] datas) {
        super(fm);

        this.datas = datas;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0://详情
                fragment = Fragment1.getInstance();
                break;
            case 1://我的
                fragment = Fragment2.getInstance();
                break;
            case 2://交易
                fragment = Fragment3.getInstance();
                break;

        }

        return fragment;
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
