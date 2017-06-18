package com.hxnidc.radiogroupviewpage.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hxnidc.radiogroupviewpage.R;

/**
 * Created by on 2017/6/18 16:09
 * Author：yrg
 * Describe:
 */


public class Fragment1 extends Fragment {

    private static Fragment1 instance = new Fragment1();

    public static Fragment1 getInstance() {
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1_layout, container, false);
        return view;
    }
}
