package com.example.b7_tranthanhhoa_b1908387;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class XoaStudent extends AppCompatActivity {
    DBAdapter db = new DBAdapter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xoa_student);

        final EditText so=(EditText)this.findViewById(R.id.sttxoa);
        final TextView ct=(TextView)this.findViewById(R.id.hienthi);
        Button xoacontact=(Button)this.findViewById(R.id.btnxoasv);
        Button btntrove=(Button)this.findViewById(R.id.btntrove);
        xoacontact.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                db.open();
                int chiso=Integer.parseInt(so.getText().toString());
                //---delete a contact---
                if (db.deleteStudent(chiso))
                    ct.setText("thành công.");
                else
                    ct.setText("không thành công, đổi STT và thực hiện lại.");
                db.close();
            }
        });

        btntrove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4=new Intent(XoaStudent.this,MainActivity.class);
                startActivity(intent4);
            }
        });

    }
}