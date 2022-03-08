package com.example.b4_tranthanhhoa_b1908387;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Activity3 extends AppCompatActivity {

    EditText txtTen;
    TextView txtChon;
    Button btn3;
    ListView lv3;
    ArrayList<String> arrayList = null;
    ArrayAdapter<String> arrayAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        txtTen=(EditText) findViewById(R.id.txtTen);
        txtChon=(TextView) findViewById(R.id.txtSelection);

        lv3 = (ListView) findViewById(R.id.lvPerson);
        //1. Tạo ArrayList object
        arrayList = new ArrayList<String>();

        //2. Gán Data Source (ArrayList object) vào ArrayAdapter
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);

        //3. gán Adapter vào ListView
        lv3.setAdapter(arrayAdapter);
        btn3 = (Button) findViewById(R.id.btnNhap);

        //4. Xử lý sự kiện nhấn nút Nhập
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList.add(txtTen.getText()+"");
                arrayAdapter.notifyDataSetChanged();
            }
        });

        //5. Xử lý sự kiện chọn một phần tử trong ListView
        lv3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0,View arg1, int arg2,long arg3) {
                txtChon.setText("position : " + arg2 + "; value =" + arrayList.get(arg2));
            }
        });
        
        //6. xử lý sự kiện Long click
        lv3.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                arrayList.remove(arg2);//xóa phần tử thứ arg2
                arrayAdapter.notifyDataSetChanged();
                return false;
            }
        });

//        lv3.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
//                arrayList.remove(i);//xóa phần tử thứ arg2
//                arrayAdapter.notifyDataSetChanged();
//                return false;
//            }
//        });
    }
}