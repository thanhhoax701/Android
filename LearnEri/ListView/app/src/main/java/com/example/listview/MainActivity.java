package com.example.listview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
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
    private Button button, btnCapNhat;
    private EditText editText;
    // Do mảng bắt đầu từ 0 nên để mặc định là -1
    private int vitri = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        listView = (ListView) findViewById(R.id.list);

        // Ánh xạ (lấy ra) button và editText
        button = (Button) findViewById(R.id.btn);
        editText = (EditText) findViewById(R.id.edt);
        btnCapNhat = (Button) findViewById(R.id.btnCapNhat);

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
                // Hiển thị dạng Toast ra màn hình
                // Toast.makeText(context, listData.get(i), Toast.LENGTH_SHORT).show();

                // Hiển thị lên phần nhập text
                editText.setText((listData.get(i)));
                vitri = i;
            }
        });

        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listData.set(vitri, editText.getText().toString());
                // Cập nhật lại dữ liệu
                adapter.notifyDataSetChanged();
            }
        });

        // Nhấn giữ vào item để xóa
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(context);
                dialog.setTitle("Xác nhận");
                dialog.setMessage("Bạn có đồng ý xóa không?");
                dialog.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        listData.remove(position);
                        adapter.notifyDataSetChanged();
                    }
                });
                // Nếu không đồng ý xóa thì đóng dialog lại
                dialog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialog.setCancelable(true);
                    }
                });
                AlertDialog alertDialog = dialog.create();
                alertDialog.show();
                return false;
            }
        });
    }
}