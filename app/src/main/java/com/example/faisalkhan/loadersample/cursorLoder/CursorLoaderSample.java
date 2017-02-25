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

/**
 * CursorLoaderSample is a activity class that will show how to user CursorLoader in android.
 *
 * The concept of Loaders was introduced in Android 3.0 (API Level 11).
 * There are three key benefits of using a CursorLoader:
 *      The query is handled on a background thread for you (courtesy of being built on AsyncTaskLoader)
 *      so that large data queries do not block the UI.
 *      This is something the docs recommended for you to do when you’re using a plain Cursor, but now it's done under the hood.
 *      CursorLoader is auto-updating. In addition to performing the initial query, CursorLoader also registers a ContentObserver
 *      with the data set you requested and calls forceLoad() on itself when the data set changes.
 *      This results in getting async callbacks anytime the data changes in order to update the view.
 *      Now follow these simple steps: Here we will create a list of all the contacts stored in an android device.
 *
 * for more details follow link :- https://developer.android.com/reference/android/content/CursorLoader.html
 *
 * @author Faisa Khan
 *
 */
public class CursorLoaderSample extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    // listView instance
    private ListView lstContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cursor_loader_sample);

        lstContact = (ListView) findViewById(R.id.lstContacts);

        //starting loader to fetch data
        getLoaderManager().initLoader(1, null, this);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int arg0, Bundle arg1) {

        //query to fetch contracts
        Uri CONTACT_URI = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        return new CursorLoader(this, CONTACT_URI, null, null, null, null);
    }
    @Override
    public void onLoadFinished(Loader<Cursor> arg0, Cursor cursor) {
        //close cursor and load data into adapter
        cursor.moveToFirst();
        CustomContactAdapter adapter = new CustomContactAdapter(this, cursor);
        lstContact.setAdapter(adapter);
    }
    @Override
    public void onLoaderReset(Loader arg0) {
    }
}
