package com.example.android.todolist;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.android.todolist.database.AppDatabase;
import com.example.android.todolist.database.TaskEntry;

// TODO completed (5) Make this class extend ViewModel
class AddTaskViewModel extends ViewModel {

    // TODO completed (6) Add a task member variable for the TaskEntry object wrapped in a LiveData
    private LiveData<TaskEntry> task;

    // TODO completed (8) Create a constructor where you call loadTaskById of the taskDao to initialize the task variable
    // Note: The constructor should receive the database and the taskId
    AddTaskViewModel(AppDatabase database, int id) {
        task = database.taskDao().loadTaskById(id);
    }

    // TODO completed (7) Create a getter for the task variable
    LiveData<TaskEntry> getTask() {
        return task;
    }
}
