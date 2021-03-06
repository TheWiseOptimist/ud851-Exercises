package com.example.android.background.sync;/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.app.IntentService;
import android.app.Notification;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;

// TODO completed (9) Create WaterReminderIntentService and extend it from IntentService
public class WaterReminderIntentService extends IntentService {

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     */
    //  TODO completed (10) Create a default constructor that calls super with the name of this class
    public WaterReminderIntentService() {
        super("WaterReminderIntentService");
    }

    //  TODO completed (11) Override onHandleIntent
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        //  TODO completed (12) Get the action from the Intent that started this Service
        //  TODO completed (13) Call ReminderTasks.executeTaskForTag and pass in the action to be performed
        ReminderTasks.executeTask(getApplicationContext(), intent.getAction());
        // Class solution:
        //  String action = intent.getAction();
        //  ReminderTasks.executeTask(this, action);
    }
}