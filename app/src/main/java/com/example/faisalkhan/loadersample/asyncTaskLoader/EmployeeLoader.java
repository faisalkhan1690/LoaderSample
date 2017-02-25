package com.example.faisalkhan.loadersample.asyncTaskLoader;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class EmployeeLoader extends AsyncTaskLoader<List<Employee>> {
    public EmployeeLoader(Context context) {
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