package com.example.android.todolist.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;
import android.util.Log;

@Database(entities = {TaskEntry.class}, version = 1, exportSchema = false)
@TypeConverters(DateConverter.class)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase sInstance;
    private static final String DATABASE_NAME = "todolist";
    private static final Object LOCK = new Object();
    private static final String LOG_TAG = AppDatabase.class.getSimpleName();

    public AppDatabase getsInstance(Context context) {
        if (sInstance == null) synchronized (LOCK) {
            sInstance = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class,
                    DATABASE_NAME)
                    .build();
        }
        Log.d(LOG_TAG, "getting database instance");
        return sInstance;
    }

    public abstract TaskDao taskDao();
}
