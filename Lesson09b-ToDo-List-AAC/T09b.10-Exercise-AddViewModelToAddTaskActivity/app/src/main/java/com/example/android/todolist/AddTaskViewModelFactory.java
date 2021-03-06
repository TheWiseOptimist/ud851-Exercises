package com.example.android.todolist;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.android.todolist.database.AppDatabase;
import com.example.android.todolist.database.TaskEntry;

// TODO completed (1) Make this class extend ViewModel ViewModelProvider.NewInstanceFactory
public class AddTaskViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    // TODO completed (2) Add two member variables. One for the database and one for the taskId
    private final AppDatabase mDb;
    private final int mTaskId;

    // TODO completed (3) Initialize the member variables in the constructor with the parameters received
    AddTaskViewModelFactory(AppDatabase database, int id) {
        this.mDb = database;
        this.mTaskId = id;
    }

    // TODO completed (4) Uncomment the following method (note - I created it from scratch)

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
//        return super.create(modelClass);
        return (T) new AddTaskViewModel(mDb, mTaskId);
    }

    // Note: This can be reused with minor modifications
    /*@Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        //noinspection unchecked
        return (T) new AddTaskViewModel(mDb, mTaskId);*/
}

