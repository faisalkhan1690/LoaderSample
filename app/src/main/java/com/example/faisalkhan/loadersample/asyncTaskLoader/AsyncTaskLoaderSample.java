package com.example.faisalkhan.loadersample.asyncTaskLoader;

import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.faisalkhan.loadersample.R;

import java.util.ArrayList;
import java.util.List;

public class AsyncTaskLoaderSample extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Employee>> {


    private EmployeeAdapter empAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task_loader_sample);

        empAdapter = new EmployeeAdapter(this, new ArrayList<Employee>());
        ListView employeeListView = (ListView) findViewById(R.id.employees);
        employeeListView.setAdapter(empAdapter);
        getLoaderManager().initLoader(1, null, this).forceLoad();
    }

    @Override
    public Loader<List<Employee>> onCreateLoader(int id, Bundle args) {
        return new EmployeeLoader(this);
    }
    @Override
    public void onLoadFinished(Loader<List<Employee>> loader, List<Employee> data) {
        empAdapter.setEmployees(data);
    }
    @Override
    public void onLoaderReset(Loader<List<Employee>> loader) {
        empAdapter.setEmployees(new ArrayList<Employee>());
    }

}
