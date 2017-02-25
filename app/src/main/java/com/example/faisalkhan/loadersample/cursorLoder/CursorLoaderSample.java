package com.example.faisalkhan.loadersample.cursorLoder;

import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.faisalkhan.loadersample.R;

public class CursorLoaderSample extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    private ListView lstContact;
    private CustomContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cursor_loader_sample);
        lstContact = (ListView) findViewById(R.id.lstContacts);
        getLoaderManager().initLoader(1, null, this);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int arg0, Bundle arg1) {
        Uri CONTACT_URI = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        CursorLoader cursorLoader = new CursorLoader(this, CONTACT_URI, null, null, null, null);
        return cursorLoader;
    }
    @Override
    public void onLoadFinished(Loader<Cursor> arg0, Cursor cursor) {
        cursor.moveToFirst();
        adapter = new CustomContactAdapter(this, cursor);
        lstContact.setAdapter(adapter);
    }
    @Override
    public void onLoaderReset(Loader arg0) {
    }
}
