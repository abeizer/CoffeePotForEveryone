package com.everyone.coffeecontroller;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import java.time.LocalTime;

/**
 * The "Brew Later" tab allows the user to schedule a time in the future for the
 * brewing process to be triggered.
 */
public class BrewLaterFragment extends Fragment {

    private TimePicker timePicker;
    private Button scheduleBrewButton;
    private Button cancelScheduledBrewButton;
    private boolean brewScheduled = false;
    private LocalTime scheduledTime = null;

    // Constructor
    public BrewLaterFragment() {
        // Required empty public constructor
    }

    /**
     * Create the view
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_brew_later, container, false);
    }

    /**
     * After the view is created
     */
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        this.timePicker = view.findViewById(R.id.timePicker);
        this.scheduleBrewButton = view.findViewById(R.id.scheduleBrewButton);
        this.cancelScheduledBrewButton = view.findViewById(R.id.cancelScheduledBrewButton);
        this.timePicker.setHour(LocalTime.now().getHour());
        this.timePicker.setMinute(LocalTime.now().getMinute());
        this.updateDisplay();

        // Set up our button listeners
        scheduleBrewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                brewScheduled = true;
                scheduledTime = LocalTime.of(timePicker.getHour(), timePicker.getMinute());
                updateDisplay();

                // Show a toast message
                // TODO: format 24hr --> 12 hr, or "scheduled to start in x hrs/minutes"
                String toastString = "Coffee Scheduled for " + scheduledTime.toString();
                Toast.makeText(view.getContext(), toastString, Toast.LENGTH_SHORT).show();
            }
        });
        cancelScheduledBrewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                brewScheduled = false;
                updateDisplay();

                // Show a toast message
                String toastString = "Coffee Cancelled";
                Toast.makeText(view.getContext(), toastString, Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * This can be called to update which buttons for this fragment should be set visible
     * or invisible
     */
    private void updateDisplay()
    {
        if(this.brewScheduled)
        {
            // If we already have a time scheduled,
            // then the cancel button should be displayed
            // and the time picker should be disabled
            scheduleBrewButton.setVisibility(View.GONE);
            cancelScheduledBrewButton.setVisibility(View.VISIBLE);
            timePicker.setEnabled(false);
        }
        else
        {
            // If we do not yet have a time selected,
            // then the schedule button should be displayed
            // and the time picker should be enabled
            scheduleBrewButton.setVisibility(View.VISIBLE);
            cancelScheduledBrewButton.setVisibility(View.GONE);
            timePicker.setEnabled(true);
        }
    }
}