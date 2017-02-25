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
                        startActivity(new Intent(MainActivity.this,AsyncTaskLoaderSample.class));
                        break;

                    case 1:
                        startActivity(new Intent(MainActivity.this,CursorLoaderSample.class));
                        break;

                    case 2:
                        startActivity(new Intent(MainActivity.this,CursorLoaderSample2.class));
                        break;
                }
            }
        });
    }
}
