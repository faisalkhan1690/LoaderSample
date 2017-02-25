package com.example.faisalkhan.loadersample.cursorLoder2;

import android.app.LoaderManager;
import android.content.ContentProviderOperation;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import com.example.faisalkhan.loadersample.R;

import java.util.ArrayList;

/**
 * CursorLoaderSample2 is a activity class that will show how to user CursorLoader in android.
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
public class CursorLoaderSample2 extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    private TextView resTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cursor_loader_sample2);

        resTextView = (TextView) findViewById(R.id.res);
        ArrayList<ContentProviderOperation> ops = new ArrayList<>();
        int rawContactInsertIndex = ops.size();
        ops.add(ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI)
                .withValue(ContactsContract.RawContacts.ACCOUNT_TYPE, "Test")
                .withValue(ContactsContract.RawContacts.ACCOUNT_NAME, "CTE").build());

        ops.add(ContentProviderOperation
                .newInsert(ContactsContract.Data.CONTENT_URI)
                .withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID,
                        rawContactInsertIndex)
                .withValue(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE)
                .withValue(ContactsContract.CommonDataKinds.StructuredName.DISPLAY_NAME, "test name")
                .withValue(ContactsContract.CommonDataKinds.Phone.NUMBER, 1234567890).build());
        try {
            //Use below statement to insert a new contact
            //getContentResolver().applyBatch(ContactsContract.AUTHORITY, ops);
        } catch (Exception e) {
            e.printStackTrace();
        }
        getLoaderManager().initLoader(1, null, this);
    }


    @Override
    public Loader<Cursor> onCreateLoader(int arg0, Bundle arg1) {
        Uri CONTENT_URI = ContactsContract.RawContacts.CONTENT_URI;
        return new CursorLoader(this, CONTENT_URI, null, null, null, null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> arg0, Cursor cursor) {
        cursor.moveToFirst();
        StringBuilder res = new StringBuilder();
        while (!cursor.isAfterLast()) {
            res.append("\n").append(cursor.getString(21)).append("-").append(cursor.getString(22));

            cursor.moveToNext();
        }
        resTextView.setText(res);

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        // If the Cursor is being placed in a CursorAdapter, you should use the
        // swapCursor(null) method to remove any references it has to the
        // Loader's data.
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
