package com.example.faisalkhan.loadersample.asyncTaskLoader;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Loader class that extends AsyncTaskLoader
 *
 * Task of this loader class is to load data and send back to its caller class.
 *
 * For more details about AsyncTaskLoader loader follow link:-
 * https://developer.android.com/reference/android/content/AsyncTaskLoader.html
 *
 * @author Faisal Khan
 *
 */
class EmployeeLoader extends AsyncTaskLoader<List<Employee>> {
    EmployeeLoader(Context context) {
        super(context);
    }
    @Override
    public List<Employee> loadInBackground() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("emp 1", "Faisal"));
        list.add(new Employee("emp 2", "Soumya"));
        list.add(new Employee("emp 3", "Lucky"));
        return list;
    }
}