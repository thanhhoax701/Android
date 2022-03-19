package com.example.b7_tranthanhhoa_b1908387;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class XemStudent extends AppCompatActivity {
    DBAdapter db = new DBAdapter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xem_student);

        final EditText so=(EditText)this.findViewById(R.id.stt);
        final TextView ct=(TextView)this.findViewById(R.id.hienthi);
        Button xemsv=(Button)this.findViewById(R.id.btnxemmot);
        Button trove=(Button)this.findViewById(R.id.btntrove);

        xemsv.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                //TODO Auto-generated mehtod stub
                db.open();
                int chiso=Integer.parseInt(so.getText().toString());
                Cursor cc = db.getStudent(chiso);
                //Có thêm
                if (cc.moveToFirst()) {
                    String tx="id: " + cc.getString(0) + "\n" +
                            "MSSV: " + cc.getString(1) + "\n" +
                            "Name: " + cc.getString(2) + "\n" +
                            "Email: " + cc.getString(3) + "\n" +
                            "Phone number: " + cc.getString(4);
                    ct.setText(tx);
                }
                else {
                    String tx2="No student found";
                    ct.setText(tx2);
                    db.close();
                }
            }
        });
        trove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(XemStudent.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}