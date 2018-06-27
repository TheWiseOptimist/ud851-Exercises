package com.example.android.todolist;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.android.todolist.database.AppDatabase;
import com.example.android.todolist.database.TaskDao;
import com.example.android.todolist.database.TaskEntry;

import java.util.List;

// TODO completed   (1) make this class extend AndroidViewModel and implement its default constructor
public class MainViewModel extends AndroidViewModel {

    private static final String LOG_TAG = MainViewModel.class.getSimpleName();

    // TODO completed (2) Add a tasks member variable for a list of TaskEntry objects wrapped in a LiveData
    private LiveData<List<TaskEntry>> tasks;

    public MainViewModel(@NonNull Application application) {
        super(application);
        // TODO completed (4) In the constructor use the loadAllTasks of the taskDao to initialize the tasks variable
        AppDatabase mDb = AppDatabase.getInstance(application); // TODO: 6/26/18
        Log.d(LOG_TAG, "Actively loading tasks from Database");
        tasks = mDb.taskDao().loadAllTasks();
    }


    // TODO completed (3) Create a getter for the tasks variable
    public LiveData<List<TaskEntry>> getTasks() {
        return tasks;
    }


}
