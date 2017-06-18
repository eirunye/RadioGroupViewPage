package com.hxnidc.radiogroupviewpage;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener {

    private ViewPager mViewPager;
    private RadioGroup mRadioGroup;
    private MainTabAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        mViewPager = (ViewPager) findViewById(R.id.ump_viewpager);
        mRadioGroup = (RadioGroup) findViewById(R.id.rg_ump_layout);
        mRadioGroup.setOnCheckedChangeListener(this);
        mViewPager.setOnPageChangeListener(this);
        adapter = new MainTabAdapter(getSupportFragmentManager(), null);
        mViewPager.setAdapter(adapter);
        mRadioGroup.check(mRadioGroup.getChildAt(0).getId());
        mViewPager.setOffscreenPageLimit(3);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
        int index = radioGroup.indexOfChild(radioGroup.findViewById(i));
        mViewPager.setCurrentItem(index);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        View childView = mRadioGroup.getChildAt(position);
        if (childView instanceof RadioButton) {
            RadioButton radioButton = (RadioButton) childView;
            mRadioGroup.check(radioButton.getId());
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
