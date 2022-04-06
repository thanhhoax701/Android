package tranduythanh.com;

import java.util.ArrayList;

import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.app.Activity;
import android.content.CursorLoader;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class ShowAllContactActivity extends Activity {
    Button btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_contact);
        btnback = (Button) findViewById(R.id.btnback);
        btnback.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
            }
        });
        showAllContacts1();
    }

    /**
     * hàm danh toàn bộ danh bạ
     * dùng CursorLoader
     */
    public void showAllContacts1() {
        Uri uri = Uri.parse("content://contacts/people");
        ArrayList<String> list = new ArrayList<String>();
        CursorLoader loader = new
                CursorLoader(this, uri, null, null, null, null);
        Cursor c1 = loader.loadInBackground();
        c1.moveToFirst();
        while (c1.isAfterLast() == false) {
            String s = "";
            String idColumnName = ContactsContract.Contacts._ID;
            int idIndex = c1.getColumnIndex(idColumnName);
            s = c1.getString(idIndex) + " - ";
            String nameColumnName = ContactsContract.Contacts.DISPLAY_NAME;
            int nameIndex = c1.getColumnIndex(nameColumnName);
            s += c1.getString(nameIndex);
            c1.moveToNext();
            list.add(s);
        }
        c1.close();
        ListView lv = (ListView) findViewById(R.id.listView1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, list);
        lv.setAdapter(adapter);
    }

    /**
     * hàm danh toàn bộ danh bạ
     * dùng getContentResolver
     */
    public void showAllContacts2() {
        Uri uri = Uri.parse("content://contacts/people");
        ArrayList<String> list = new ArrayList<String>();
        Cursor c1 = getContentResolver()
                .query(uri, null, null, null, null);
        c1.moveToFirst();
        while (c1.isAfterLast() == false) {
            String s = "";
            String idColumnName = ContactsContract.Contacts._ID;
            int idIndex = c1.getColumnIndex(idColumnName);
            s = c1.getString(idIndex) + " - ";
            String nameColumnName = ContactsContract.Contacts.DISPLAY_NAME;
            int nameIndex = c1.getColumnIndex(nameColumnName);
            s += c1.getString(nameIndex);
            c1.moveToNext();
            list.add(s);
        }
        c1.close();
        ListView lv = (ListView) findViewById(R.id.listView1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, list);
        lv.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_show_all_contact, menu);
        return true;
    }

}
