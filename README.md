
# RadioGroup与ViewPage联动

在开发中我们常用到RadioGroup与viewpage之间的联动
如以下页面常见的方式

代码如下：
MainActivity类


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
    
    /**
     *选择当前position
     *
     */
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


MainTabAdapter类


    
    class MainTabAdapter extends FragmentPagerAdapter {
        private String[] mTitles = new String[]{"", "", ""};
        private int[] datas = null;

        public MainTabAdapter(FragmentManager fm, int[]     datas) {
            super(fm);

            this.datas = datas;
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            switch (position) {
                case 0://头条
                    fragment = Fragment1.getInstance();
                    break;
                case 1://评论
                    fragment = Fragment2.getInstance();
                    break;
                case 2://论坛
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
    
    
xml文件如下：activity_main.xml


    <?xml version="1.0" encoding="utf-8"?>
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
              xmlns:app="http://schemas.android.com/apk/res-auto"
              android:layout_width="match_parent"
              android:layout_height="match_parent"
              android:fitsSystemWindows="true"
              android:orientation="vertical">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="54dp"
        android:orientation="horizontal">

        <RadioGroup
            android:id="@+id/rg_ump_layout"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:layout_marginBottom="10dp"
            android:layout_marginLeft="12dp"
            android:layout_marginRight="12dp"
            android:layout_marginTop="10dp"
            android:orientation="horizontal">
            <RadioButton
                android:id="@+id/rb_ump_Position"
                android:layout_width="0dp"
                android:layout_height="match_parent"
                android:layout_weight="1"
                android:background="@drawable/rb_bg_posi"
                android:button="@null"
                android:checked="true"
                android:gravity="center"
                android:text="头条"
               android:textColor="@drawable/title_text_sel"
                android:textSize="15sp"/>

            <RadioButton
                android:id="@+id/rb_ump_unFinish"
                android:layout_width="0dp"
                android:layout_height="match_parent"
                android:layout_weight="1"
                android:background="@drawable/rb_bg_unfini"
                android:button="@null"
                android:gravity="center"
                android:text="评论"
               android:textColor="@drawable/title_text_sel"
                android:textSize="15sp"/>
            <RadioButton
                android:id="@+id/rb_ump_mit"
                android:layout_width="0dp"
                android:layout_height="match_parent"
                android:layout_weight="1"
                android:background="@drawable/rb_bg_mit"
                android:button="@null"
                android:gravity="center"
                android:text="论坛"
               android:textColor="@drawable/title_text_sel"
                android:textSize="15sp"/>
        </RadioGroup>
    </LinearLayout>

    <android.support.v4.view.ViewPager
        android:id="@+id/ump_viewpager"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>
    </LinearLayout>


在res目录的drawable下创建background和字体textColor

>**效果如下：**

![1497775407(1).png](http://upload-images.jianshu.io/upload_images/3012005-aa41e9d65fb3c2d6.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/300)


![pinglun.png](http://upload-images.jianshu.io/upload_images/3012005-303809cda82b8db7.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/300)

>下载demo地址[RadioGroup与ViewPage联动](https://github.com/eirunye/RadioGroupViewPage/tree/master)
