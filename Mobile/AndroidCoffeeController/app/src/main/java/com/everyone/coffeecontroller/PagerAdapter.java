package com.everyone.coffeecontroller;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * Used from the MainActivity to facilitate switching between tab fragments
 */
class PagerAdapter extends FragmentPagerAdapter {

    // The total number of tabs the tabLayout supports
    private int numTabs;

    // Constructor
    public PagerAdapter(FragmentManager fragmentManager, int numTabs){
        super(fragmentManager);
        this.numTabs = numTabs;
    }

    /**
     * Returns the correct fragment based on which tab we are trying to view
     */
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                return new BrewNowFragment();
            case 1:
                return new BrewLaterFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numTabs;
    }
}
