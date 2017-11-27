package com.gaom.flingbehaviordemo;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;


import java.util.ArrayList;
import java.util.List;

public class MainViewPagerActivity extends AppCompatActivity {
    ViewPager  viewpager;
    TabLayout tablayout_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.abc);

        viewpager = ( ViewPager) findViewById(R.id.viewpager);
        tablayout_user = ( TabLayout) findViewById(R.id.tablayout_user);

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(AFragment.newInstance("1", "0"));
        fragments.add(BFragment.newInstance("2", "0"));
        FragAdapter adapter = new FragAdapter(getSupportFragmentManager(), fragments);
        viewpager.setAdapter(adapter);
        tablayout_user.setupWithViewPager(viewpager);

    }





    public class FragAdapter extends FragmentPagerAdapter {
        String[] a = new String[]{"动态", "文章" };
        private List<Fragment> mFragments;

        public FragAdapter(FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            mFragments = fragments;
        }

        public Fragment getItem(int position) {

            return mFragments.get(position);
        }

        public int getCount() {
            return 2;
        }

        public CharSequence getPageTitle(int position) {
            return this.a[position];
        }
    }
}
