package com.example.realtimedatabase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText edTData;
    Button btnPushData, btnGetData;
    TextView tvGetData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Push dữ liệu của Map
        Map<String, Boolean> map = new HashMap<>();
        map.put("key1", true);
        map.put("key2", false);

        Anhxa();

        btnPushData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pushData();
            }
        });

        btnGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getData();
            }
        });
    }

    private void pushData() {
        // Đẩy dữ liệu lên
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("channel");
        // Chuyển sang kiểu int
//        myRef.setValue(Integer.parseInt(edTData.getText().toString().trim()));
        myRef.setValue(edTData.getText().toString().trim(), new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                Toast.makeText(MainActivity.this, "Push data success", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getData() {
        // Lấy dữ liệu về
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("user").child("mssv");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Chuyển sang kiểu int
//                int value = dataSnapshot.getValue(Integer.class);
//                tvGetData.setText(String.valueOf(value));
                String value = dataSnapshot.getValue(String.class);
                tvGetData.setText(value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(MainActivity.this, "Sai rồi", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void Anhxa() {
        edTData = findViewById(R.id.edtPushData);
        btnPushData = findViewById(R.id.btnPushData);
        btnGetData = findViewById(R.id.btnGetData);
        tvGetData = findViewById(R.id.tvGetData);
    }


}