package com.everyone.coffeecontroller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

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

        // Update connection status text
        final TextView connectionStatus = findViewById(R.id.connectionStatusValue);
        final ImageButton connectionSyncButton = findViewById(R.id.connectionStatusSyncButton);
        // TODO: see if the board can actually establish a connection
        connectionStatus.setText(R.string.connection_OK);
        connectionStatus.setTextColor(Color.GREEN);

        // add a click event to the sync button to query connection status
        // TODO: for now this just toggles between status of OK and OFFLINE
        connectionSyncButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(connectionStatus.getText().toString().equals(getString(R.string.connection_OK)))
                {
                    connectionStatus.setText(R.string.connection_OFFLINE);
                    connectionStatus.setTextColor(Color.RED);
                }
                else
                {
                    connectionStatus.setText(R.string.connection_OK);
                    connectionStatus.setTextColor(Color.GREEN);
                }

            }
        });

        // Init tab-bar and its individual tabs
        final TabLayout tabBar = findViewById(R.id.tabBar);
        final TabItem tabBrewNow = findViewById(R.id.tabBrewNow);
        final TabItem tabBrewLater = findViewById(R.id.tabBrewLater);

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