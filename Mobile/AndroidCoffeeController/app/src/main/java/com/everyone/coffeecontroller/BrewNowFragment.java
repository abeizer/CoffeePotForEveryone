package com.everyone.coffeecontroller;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * The "Brew Now" tab allows the user to instantly trigger the brewing process
 */
public class BrewNowFragment extends Fragment {

    public BrewNowFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_brew_now, container, false);
    }
}