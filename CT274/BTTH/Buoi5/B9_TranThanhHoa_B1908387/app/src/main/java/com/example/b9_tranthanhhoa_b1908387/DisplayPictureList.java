package com.example.b9_tranthanhhoa_b1908387;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class DisplayPictureList extends AppCompatActivity {
    Button backPicture;
    ListView lvPicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_picture_list);

        // Trở về của Picture
        backPicture = (Button) findViewById(R.id.btnPictureTrove);
        backPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        lvPicture = (ListView) findViewById(R.id.lvPicture);
        ArrayList<String> listImage = new ArrayList<String>();
        ArrayAdapter<String> adapterImage = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, listImage);
        lvPicture.setAdapter(adapterImage);
        // get toan bo danh sach hình ảnh
        String[] projection = new String[]{
                MediaStore.Images.Media._ID,
                MediaStore.Images.Media.TITLE,
                MediaStore.Images.Media.DATE_ADDED
        };
        Cursor cursor = getApplicationContext().getContentResolver().query(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                projection, null, null, null);
        int count = 0;
        if (cursor.moveToFirst()) {
            do {
                String ds = "count: " + count
                        + "\n_id: " + cursor.getString(0)
                        + "\ntitle: " + cursor.getString(1)
                        + "\ndata_added: " + cursor.getString(2)
                        + "\n--------------------------";
                listImage.add(ds);
                adapterImage.notifyDataSetChanged();
                count++;
            }
            while (cursor.moveToNext());
        }
        cursor.close();

        lvPicture.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(DisplayPictureList.this, listImage.get(i), Toast.LENGTH_SHORT).show();
            }
        });
    }
}