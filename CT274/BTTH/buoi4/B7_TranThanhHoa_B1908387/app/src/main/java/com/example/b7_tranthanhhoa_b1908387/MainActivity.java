package com.example.b7_tranthanhhoa_b1908387;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DBAdapter db = new DBAdapter(this);
    ListView lv;
    ArrayList<String> arrList=null;
    ArrayAdapter<String> adapter=null;
    String msg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button themsv = (Button) this.findViewById(R.id.btnthemsv);
        Button xemtatcasv = (Button) this.findViewById(R.id.btnxemtatca);
        Button xemmotsv = (Button) this.findViewById(R.id.btnxemmotsv);
        Button suamotsv = (Button) this.findViewById(R.id.btncapnhatsv);
        Button xoamotsv = (Button) this.findViewById(R.id.btnxoasv);
        Button back = (Button) this.findViewById(R.id.btntrove);

        //---Thêm một sinh viên---
        themsv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO Auto-generated mehtod stub
                Intent it = new Intent(MainActivity.this, ThemStudent.class);
                startActivity(it);
            }
        });

        //---get all sinh viêns---
        lv=(ListView) findViewById(R.id.lvperson);
        //Tạo ArrayList object
        arrList=new ArrayList<String>();
        //Gán Data Source (ArrayList object) vào ArrayAdapter
        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arrList);
        //gán Adapter vào ListView
        lv.setAdapter(adapter);
        xemtatcasv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO Auto-generated mehtod stub
                db.open();
                Cursor c = db.getAllStudent();
                if (c.moveToFirst()) {
                    do {
                        String msg = "id: " + c.getString(0) + "\n" +
                                "MSSV: " + c.getString(1) + "\n" +
                                "Name: " + c.getString(2) + "\n" +
                                "Email: " + c.getString(3) + "\n" +
                                "Phone number: " +c.getString(4);;
                        arrList.add(msg);
                        adapter.notifyDataSetChanged();
                        c.moveToNext();
                    }
                    //while (c.moveToNext());
                    while (c.isAfterLast()==false);
                }
                else {
                    Toast.makeText(MainActivity.this, "Vui lòng thêm sinh viên!!!", Toast.LENGTH_SHORT).show();
                }
                db.close();
            }
        });

        //---Xem 1 sinh viên---
        xemmotsv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO Auto-generated mehtod stub
                Intent it = new Intent(MainActivity.this, XemStudent.class);
                startActivity(it);
            }
        });

        // Sửa 1 sinh viên
        suamotsv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO Auto-generated mehtod stub
                Intent it = new Intent(MainActivity.this, SuaStudent.class);
                startActivity(it);
            }
        });

        // Xoá 1 sinh viên
        xoamotsv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO Auto-generated mehtod stub
                Intent it = new Intent(MainActivity.this, XoaStudent.class);
                startActivity(it);
            }
        });

        //Trở về
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //finish();
                Intent it = new Intent(MainActivity.this, MainActivity.class);
                startActivity(it);
            }
        });

    }
}