package com.example.b8_tranthanhhoa_b1908387;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.CursorLoader;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    ArrayList<String> arrList = null;
    ArrayAdapter<String> adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickAddName(View view) {
        // Add a new student record
        ContentValues values = new ContentValues();
        values.put(StudentsProvider.NAME, ((EditText) findViewById(R.id.editText2)).getText().toString());
        values.put(StudentsProvider.BUOI, ((EditText) findViewById(R.id.editText3)).getText().toString());
        Uri uri = getContentResolver().insert(StudentsProvider.CONTENT_URI, values);
        Toast.makeText(getBaseContext(), uri.toString(), Toast.LENGTH_LONG).show();
    }

    public void onClickRetrieveStudents(View view) {
        Uri students = StudentsProvider.CONTENT_URI;
        String[] projection = {StudentsProvider._ID, StudentsProvider.NAME, StudentsProvider.BUOI};
        CursorLoader loader = new CursorLoader(this, students, projection, null, null, null);
        Cursor c = loader.loadInBackground();
//        c.moveToFirst();
//        String s = "";
//        while (!c.isAfterLast()){
//            for (int i=0; i<c.getColumnCount();i++){
//                s+= c.getString(i)+"-";
//            }
//            s+="\n";
//            c.moveToNext();
//        }
//        // Thay vì hiển thị Danh sách SV bằng Toast như dòng lệnh mẫu bên dưới, SV hãy sửa lại để hiển thị
//        // Danh sách sinh viên đã nhập vào bằng 1 TextView hoặc ListView
//        // (Khi đó phải thêm vào giao diện của MainActivity một TextView, ban đầu là trống, hoặc một ListView).
//        Toast.makeText(this,s,Toast.LENGTH_LONG).show();
//        c.close();
        lv = (ListView) findViewById(R.id.lv);
        arrList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrList);
        lv.setAdapter(adapter);
        if (c.moveToFirst()) {
            do {
                String msg = "STT: " + c.getString(0) + "\n" +
                        "Họ tên: " + c.getString(1) + "\n" +
                        "Buổi: " + c.getString(2);
                arrList.add(msg);
                adapter.notifyDataSetChanged();
                c.moveToNext();
            }
            while (c.isAfterLast() == false);
//            lv.setOnItemLongClickListener(new AdapterView
//                    .OnItemLongClickListener() {
//                @Override
//                public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
//                    arrList.remove(arg2);//xóa phần tử thứ arg2
//                    adapter.notifyDataSetChanged();
//                    return false;
//                }
//            });
        } else {
            Toast.makeText(this, "Chưa có sinh viên", Toast.LENGTH_SHORT).show();
        }
    }
}