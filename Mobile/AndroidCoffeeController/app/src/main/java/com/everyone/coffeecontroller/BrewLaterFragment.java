package com.everyone.coffeecontroller;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * The "Brew Later" tab allows the user to schedule a time in the future for the
 * brewing process to be triggered.
 */
public class BrewLaterFragment extends Fragment {

    public BrewLaterFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_brew_later, container, false);
    }
}