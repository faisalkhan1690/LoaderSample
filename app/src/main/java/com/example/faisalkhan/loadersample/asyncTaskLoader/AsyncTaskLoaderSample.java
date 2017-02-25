package com.example.faisalkhan.loadersample.asyncTaskLoader;

import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.faisalkhan.loadersample.R;

import java.util.ArrayList;
import java.util.List;

/**
 * AsyncTaskLoaderSample is a activity class that will show how to user AsyncTaskLoader in android.
 *
 * android.content.AsyncTaskLoader<D> is a loader that uses AsyncTask to perform the task.
 * It is an abstract class and to use it we need to extend and override its methods.
 * In our example we will iterate a list using ListView.
 * Find some methods that need to be overridden.
 *
 *              loadInBackground() :
 *                      Performs actual task in background and returns the result.
 *              onCanceled(D data) :
 *                      This method is called if task is cancelled before completion. It is used to clean up data post cancellation.
 *              cancelLoadInBackground() :
 *                      We override this method to cancel the background process. If there is no process in background, it is not going to be called.
 *
 * for more info follow link :- https://developer.android.com/reference/android/content/AsyncTaskLoader.html
 *
 * @author Faisal Khan
 *
 */
public class AsyncTaskLoaderSample extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Employee>> {

    //adapter class reference
    private EmployeeAdapter empAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task_loader_sample);

        // creating adapter class with empty class object
        empAdapter = new EmployeeAdapter(this, new ArrayList<Employee>());

        ListView employeeListView = (ListView) findViewById(R.id.employees);
        employeeListView.setAdapter(empAdapter);

        //start loading data using loader
        getLoaderManager().initLoader(1, null, this).forceLoad();
    }

    @Override
    public Loader<List<Employee>> onCreateLoader(int id, Bundle args) {
        // when loader object create d
        return new EmployeeLoader(this);
    }
    @Override
    public void onLoadFinished(Loader<List<Employee>> loader, List<Employee> data) {
        //once loader finish laoding data
        empAdapter.setEmployees(data);

    }
    @Override
    public void onLoaderReset(Loader<List<Employee>> loader) {
        //will call when loader restart
        empAdapter.setEmployees(new ArrayList<Employee>());
    }

}
