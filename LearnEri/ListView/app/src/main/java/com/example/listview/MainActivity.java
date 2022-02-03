package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // Danh sách ListView
//    private ListView listView;
//    private String[] listData;
//    private ArrayAdapter<String> adapter;
//    private Context context;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        context = this;
//        listView = (ListView) findViewById(R.id.list);
//
//        // Cách 1: Lấy dữ liệu từ file strings.xml
//        // listData = context.getResources().getStringArray(R.array.listVideo);
//
//        // Cách 2: Sử dụng dữ liệu trực tiếp khi chèn vào
//        listData = new String[] {
//                "Bài 1: Giới thiệu về Android",
//                "Bài 2: Cài đặt môi trường lập trình",
//                "Bài 3: Tạo project Hello World"
//        };
//
//        adapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, listData);
//        listView.setAdapter(adapter);
//    }


    // Tạo danh sách từ ArrayList
    private ListView listView;
    private ArrayList<String> listData;
    private ArrayAdapter<String> adapter;
    private Context context;
    private Button button;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        listView = (ListView) findViewById(R.id.list);

        // Ánh xạ (lấy ra) button và editText
        button = (Button) findViewById(R.id.btn);
        editText = (EditText) findViewById(R.id.edt);

        listData = new ArrayList<>();
        listData.add("Bài 1: Giới thiệu về Android");
        listData.add("Bài 2: Cài đặt môi trường lập trình");
        listData.add("Bài 3: Tạo project Hello World");
        listData.add("Bài 4: Các thành phần giao diện cơ bản (Phần 1)");
        listData.add("Bài 5: Các thành phần giao diện cơ bản (Phần 2)");

        adapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, listData);
        listView.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String item = editText.getText().toString().trim();
                // bắt buộc phải nhập dữ liệu
                if (TextUtils.isEmpty(item)) {
                    Toast.makeText(context, "Bạn chưa nhập dữ liệu", Toast.LENGTH_SHORT).show();
                    return;
                }
                listData.add(item);
                // Cập nhật lại dữ liệu trong ListView
                adapter.notifyDataSetChanged();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(context, listData.get(i), Toast.LENGTH_SHORT).show();
            }
        });
    }
}