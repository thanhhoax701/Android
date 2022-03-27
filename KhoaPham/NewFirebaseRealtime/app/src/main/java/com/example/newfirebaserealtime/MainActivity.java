package com.example.newfirebaserealtime;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    DatabaseReference mData;
    TextView txtKhoaHoc;
    Button btnAndroid, btnIOS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtKhoaHoc = (TextView) findViewById(R.id.txtKhoaHoc);
        btnAndroid = (Button) findViewById(R.id.btnAndroid);
        btnIOS = (Button) findViewById(R.id.btnIOS);

        mData = FirebaseDatabase.getInstance().getReference();
        mData.child("Khóa học").setValue("Lập trình Android");
        // Khi thay đổi trên firebase thì dưới app cũng thay đổi theo và ghi vào txtKhoaHoc
        mData.child("Khóa học").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                txtKhoaHoc.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        // Khi thay đổi dưới app thì trên firebase cũng được cập nhật
        btnAndroid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mData.child("Khóa học").setValue("Android");
            }
        });

        btnIOS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mData.child("Khóa học").setValue("IOS");
            }
        });
    }
}