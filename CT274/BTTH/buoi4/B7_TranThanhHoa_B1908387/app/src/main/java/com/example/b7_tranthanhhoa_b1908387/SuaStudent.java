package com.example.b7_tranthanhhoa_b1908387;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SuaStudent extends AppCompatActivity {
    DBAdapter db = new DBAdapter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua_student);

        final EditText sott = (EditText) this.findViewById(R.id.stt);//Thêm
        final EditText masosv = (EditText) this.findViewById(R.id.mssv);//Thêm
        final EditText ten = (EditText) this.findViewById(R.id.hoten);
        final EditText email = (EditText) this.findViewById(R.id.email);
        final EditText sodienthoai = (EditText) this.findViewById(R.id.phone);
        final TextView ct = (TextView) this.findViewById(R.id.studentduocthem);
        Button suacontact = (Button) this.findViewById(R.id.btnsua);
        Button trove = (Button) this.findViewById(R.id.btntrove);

        suacontact.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                db.open();
                String masosinhvien = masosv.getText().toString();
                String tensv = ten.getText().toString();
                String e_mail = email.getText().toString();
                String sdt = sodienthoai.getText().toString();
                int chiso = Integer.parseInt(sott.getText().toString());
                //---update contact---
                if (db.updateStudent(chiso, masosinhvien, tensv, e_mail, sdt))
                    ct.setText("thành công.");
                else
                    ct.setText("không thành công, đây là giá trị cũ, vui lòng thực hiện lại lần nữa");
                // Hiển thị contact được sửa
                Cursor c = db.getAllStudent();
                c.moveToPosition(chiso - 1);
                String tx = "id: " + c.getString(0) + "\n" +
                        "MSSV: " + c.getString(1) + "\n" +
                        "Name: " + c.getString(2) + "\n" +
                        "Email: " + c.getString(3) + "\n" +
                        "Phone number: " + c.getString(4);
                ct.setText(tx);
                db.close();
            }
        });
        trove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(SuaStudent.this, MainActivity.class);
                startActivity(intent3);
            }
        });

    }
}