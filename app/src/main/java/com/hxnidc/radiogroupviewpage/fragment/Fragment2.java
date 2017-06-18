package com.hxnidc.radiogroupviewpage.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hxnidc.radiogroupviewpage.R;

/**
 * Created by on 2017/6/18 16:10
 * Author：yrg
 * Describe:
 */


public class Fragment2 extends Fragment{

    private static Fragment2 instance = new Fragment2();

    public static Fragment2 getInstance() {
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2_layout,container,false);
        return view;
    }
}
