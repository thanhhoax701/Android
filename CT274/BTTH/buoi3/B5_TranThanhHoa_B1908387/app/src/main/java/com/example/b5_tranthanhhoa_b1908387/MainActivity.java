package com.example.b5_tranthanhhoa_b1908387;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Khai báo EditText và Button
        final EditText editValue = findViewById(R.id.value_edit);
        final Button sendButton = findViewById(R.id.send_button);
        // Đáp ứng tương tác người dùng
        sendButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Lấy giá trị từ EditText và chuyển thành String tên là valueString.
                String valueString = editValue.getText().toString();
                long value;
                //Nếu valueString khác trống thì đổi thành số Long và gán cho value, ngược
                //lại thì gán value=0.
                if (!valueString.equals("")) {
                    value = Long.parseLong(valueString);
                } else {
                    value = 0;
                }
                //Tạo 1 đối tượng Bundle để gửi đi cùng Intent
                Bundle sendBundle = new Bundle();
                sendBundle.putLong("value", value);
                //Tạo Intent để khởi chạy Activity2 và gắn đối tượng sendBundble vào Intent
                Intent i = new Intent(MainActivity.this, Activity2.class);
                i.putExtras(sendBundle); // Dùng hàm putExtras
                startActivity(i);
                //Giải phóng Activity1 khỏi Activity Stack vì ta sẽ không quay lại nó nữa
                finish();
            }
        });
    }
}