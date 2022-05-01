package com.example.b11_tranthanhhoa_b1908387;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

    public class Newmessage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newmessage);

        Button btn =this.findViewById(R.id.send);
        Button exit = this.findViewById(R.id.exitinbox);
        TextView hienthi = findViewById(R.id.hienthi);

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                EditText phone =  findViewById(R.id.phone);
                EditText message =  findViewById(R.id.message);
                try{
                    SmsManager sms = SmsManager.getDefault();
                    sms.sendTextMessage(phone.getText().toString(), null, message.getText().toString(), null, null);
                    hienthi.setText("SMS sent successful");
                }catch(Exception e){
                    hienthi.setText("Sending SMS failed");
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