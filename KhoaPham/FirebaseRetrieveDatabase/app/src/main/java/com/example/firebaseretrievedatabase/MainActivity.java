package com.example.firebaseretrievedatabase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

// Nhận dữ liệu của node từ firebase về máy bằng cách sử dụng AddChild với Push String
public class MainActivity extends AppCompatActivity {
    DatabaseReference mData;
    TextView txtKhoaHoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtKhoaHoc = (TextView) findViewById(R.id.txtKhoaHoc);

        mData = FirebaseDatabase.getInstance().getReference();

        // Nhận dữ liệu sử dụng AddChild với Push Object
        PhuongTien phuongTien = new PhuongTien("Ô tô", 4);
        mData.child("PhuongTien").push().setValue(phuongTien);

//        mData.child("KhoaHoc").push().setValue("Lập trình Unity", new DatabaseReference.CompletionListener() {
//            @Override
//            public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
//                if (error == null) {
//                    Toast.makeText(MainActivity.this, "Hay lắm em trai!!!", Toast.LENGTH_SHORT).show();
//                }else {
//                    Toast.makeText(MainActivity.this, "Cái nịt cũng không có!!!", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

        mData.child("KhoaHoc").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                // Do dữ liệu lấy về thì liên tục nên cần "\n" để xuống dòng
//                Toast.makeText(MainActivity.this, snapshot.getValue().toString(), Toast.LENGTH_SHORT).show();
                txtKhoaHoc.append(snapshot.getValue().toString() + "\n");
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}