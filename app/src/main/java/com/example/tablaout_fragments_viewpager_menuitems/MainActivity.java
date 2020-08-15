package com.example.tablaout_fragments_viewpager_menuitems;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.os.Build;
import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

/**
 * 1. Add the design library in the app gradle for using the Tab layout.
 * 2. Change the default theme to NoActionBar in the style folder so that we can have our tool bar
 * 3. Prepare the layout file and define Toolbar, TabLayout and ViewPager.
 */

public class MainActivity extends AppCompatActivity {


    private Toolbar mToolbar;
    private TabLayout mTabLayout;
    private ViewPager mViewpager;
    private TabItem mTabChats;
    private TabItem mTabStatus;
    private TabItem mTabCalls;
    private PageAdapter mPageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = findViewById(R.id.toolbar);
        mTabLayout = findViewById(R.id.tablayout);
        mViewpager = findViewById(R.id.view_pager);
        mTabChats = findViewById(R.id.tab_chats);
        mTabStatus = findViewById(R.id.tab_status);
        mTabCalls = findViewById(R.id.tab_calls);

        setSupportActionBar(mToolbar);
        mPageAdapter = new PageAdapter(getSupportFragmentManager(), mTabLayout.getTabCount());
        mViewpager.setAdapter(mPageAdapter);
        getSupportActionBar().setTitle("TabLayout");

        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewpager.setCurrentItem(tab.getPosition());

                if (tab.getPosition() == 0) {
                    mToolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    mTabLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimary));
                    }
                } else if (tab.getPosition() == 1) {
                    mToolbar.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                    mTabLayout.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(getResources().getColor(R.color.colorAccent));
                    }
                } else {
                    mToolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                    mTabLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
                    }
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        // This is done so that the tabs and the pager remains in sync
        mViewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
    }
}