package com.example.faisalkhan.loadersample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.faisalkhan.loadersample.asyncTaskLoader.AsyncTaskLoaderSample;
import com.example.faisalkhan.loadersample.cursorLoder.CursorLoaderSample;
import com.example.faisalkhan.loadersample.cursorLoder2.CursorLoaderSample2;

import java.util.ArrayList;
import java.util.List;

/**
 * Activity class to list all three example of loader
 *
 * Loaders are introduced in Android 3.0.
 * The main reason because of that loader comes in picture that Loader always loader data in background.
 * So this will never cause the app to feel unresponsive or to not even display an ANR error message
 * We can accomplish this thing using AsyncTask and thread but the problem with these two on orientation change
 * or any unexpected behaviour of app you need to do extra code for handling AsyncTask and thread.
 * But if you are using Loader then it works on unique id so one loader will not execute again until you want.
 * And must batter with AsyncTask and thread in case of unexpected behaviour of app
 *
 * For more details follow links :-
 * https://developer.android.com/guide/components/loaders.html
 * https://developer.android.com/reference/android/app/LoaderManager.html
 * https://developer.android.com/reference/android/app/LoaderManager.LoaderCallbacks.html
 *
 * @author Faisal Khan
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView=(ListView)findViewById(R.id.lv_item);
        List<String> listData=new ArrayList<>();
        listData.add("Async Task Loader Sample");
        listData.add("Cursor Loader 1");
        listData.add("Cursor Loader 2");


        listView.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listData));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        //Start intent to AsyncTaskLoaderSample activity
                        startActivity(new Intent(MainActivity.this,AsyncTaskLoaderSample.class));
                        break;

                    case 1:
                        //Start intent to CursorLoaderSample activity
                        startActivity(new Intent(MainActivity.this,CursorLoaderSample.class));
                        break;

                    case 2:
                        //Start intent to CursorLoaderSample2 activity
                        startActivity(new Intent(MainActivity.this,CursorLoaderSample2.class));
                        break;
                }
            }
        });
    }
}
