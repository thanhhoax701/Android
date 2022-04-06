package com.example.b11_tranthanhhoa_b1908387;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Newmessage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newmessage);

        Button btn = (Button)this.findViewById(R.id.send);
        Button exit = (Button)this.findViewById(R.id.exitinbox);

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                EditText phone = (EditText) findViewById(R.id.phone);
                EditText message = (EditText) findViewById(R.id.message);
                try{
                    SmsManager sms = SmsManager.getDefault();
                    sms.sendTextMessage(phone.getText().toString(), null,
                            message.getText().toString(), null, null);
//                    Toast toast = Toast.makeText(Newmessage.this, "SMS sent successful", Toast.LENGTH_LONG);
//                    toast.show();
                    Toast.makeText(Newmessage.this, "SMS sent successful", Toast.LENGTH_LONG).show();
                }catch(Exception e){
//                    Toast toast = Toast.makeText(Newmessage.this, "Sending SMS failed",Toast.LENGTH_LONG);
//                    toast.show();
                    Toast.makeText(Newmessage.this, "Sending SMS failed",Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
            }
        });
    }
}