package com.everyone.coffeecontroller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;


/**
 * Main Activity.
 * Contains tabs to let the user trigger the brewing process immediately
 * or schedule the brewing process to begin at a later time
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Init tab-bar and its individual tabs
        TabLayout tabBar = findViewById(R.id.tabBar);
        TabItem tabBrewNow = findViewById(R.id.tabBrewNow);
        TabItem tabBrewLater = findViewById(R.id.tabBrewLater);

        // Init viewPager + pagerAdapter for swiping between tabs
        final ViewPager viewPager = findViewById(R.id.viewPager);
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(), tabBar.getTabCount());
        viewPager.setAdapter(pagerAdapter);

        // Add click event to the tabBar
        tabBar.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}