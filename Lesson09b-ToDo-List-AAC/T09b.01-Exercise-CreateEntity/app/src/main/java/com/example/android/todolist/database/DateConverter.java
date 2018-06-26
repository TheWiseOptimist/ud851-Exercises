package com.example.android.todolist.database;

import android.arch.persistence.room.TypeConverter;

import java.sql.Date;

public class DateConverter {

    @TypeConverter
    public static Date toDate(Long timeStamp) {
        return timeStamp == null ? null : new Date(timeStamp);
    }

    @TypeConverter
    public static Long toTimestamp(Date dateStamp) {
        return dateStamp == null ? null : dateStamp.getTime();
    }
}
