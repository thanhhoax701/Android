package com.example.newfirebasedatabase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Gọi tới node gốc
        mDatabase = FirebaseDatabase.getInstance().getReference();

        // Trường hợp 1: Lưu dữ liệu sử dụng setValue
        // Nếu node con tồn tại thì đè dữ liệu lên dữ liệu của node đó
        mDatabase.child("Họ tên").setValue("Trần Thanh Hòa");

        // Trường hợp 2: Lưu dữ liệu sử dụng setValue với Object
        SinhVien sv = new SinhVien("Trần Thanh Hòa", "Vĩnh Long", 1999);
        mDatabase.child("Sinh viên").setValue(sv);

        // Trường hợp 3: Lưu dữ liệu sử dụng setValue với Map
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("Xe máy", 3);
        mDatabase.child("Phương tiện").setValue(map);

        // Trường hợp 4: Lưu dữ liệu sử dụng setValue với Push
        SinhVien sinhVien = new SinhVien("Nguyễn Kiều Cẩm Lan", "Đồng Tháp", 1996);
//        mDatabase.child("Học viên").push().setValue(sinhVien);


        // Bắt sự kiện hoàn thành khi setValue
        mDatabase.child("KhoaPham").setValue("Lập trình Android với Firebase", new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                if (error == null) {
                    Toast.makeText(MainActivity.this, "Lưu thành công", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Lưu thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}