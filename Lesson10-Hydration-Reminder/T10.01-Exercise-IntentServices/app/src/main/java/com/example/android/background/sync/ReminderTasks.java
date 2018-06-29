package com.example.android.background.sync;

import android.content.Context;

// TODO completed (1) Create a class called ReminderTasks
public class ReminderTasks {

    // TODO completed (2) Create a public static constant String called ACTION_INCREMENT_WATER_COUNT
    public static final String ACTION_INCREMENT_WATER_COUNT = "action_increment_water_count";

    // TODO completed (6) Create a public static void method called executeTask
    // TODO completed (7) Add a Context called context and String parameter called action to the parameter list
    public static void executeTask(Context context, String action) {
        // TODO completed (8) If the action equals ACTION_INCREMENT_WATER_COUNT, call this class's incrementWaterCount
        if (action.equals(ACTION_INCREMENT_WATER_COUNT)) {
            incrementWaterCount(context);
        }
    }

    // TODO completed (3) Create a private static void method called incrementWaterCount
    // TODO completed (4) Add a Context called context to the argument list
    private static void incrementWaterCount(Context context) {

        // TODO (5) From incrementWaterCount, call the PreferenceUtility method that will ultimately update the water count


    }
}



