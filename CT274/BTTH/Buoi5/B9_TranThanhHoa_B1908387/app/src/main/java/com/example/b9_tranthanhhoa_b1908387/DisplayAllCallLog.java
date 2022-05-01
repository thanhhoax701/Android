package com.example.b9_tranthanhhoa_b1908387;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

public class DisplayAllCallLog extends AppCompatActivity {
    Button backCall;
    ListView lvCallLog;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_all_call_log);

        backCall = findViewById(R.id.btnTroveCall);
        lvCallLog = findViewById(R.id.lvCallLog);

        ArrayList<String> list2 = new ArrayList<String>();
        ContentResolver cr2 = getContentResolver();
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list2);
        lvCallLog.setAdapter(adapter2);
        // Lấy lịch sử cuộc gọi
        String[] projection = new String[]{CallLog.Calls.DATE, CallLog.Calls.NUMBER, CallLog.Calls.DURATION};
        if (checkSelfPermission(Manifest.permission.READ_CALL_LOG) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        Cursor managedCursor = getContentResolver().query(CallLog.Calls.CONTENT_URI, projection,
                        CallLog.Calls.DURATION + "<?", new String[]{"30"},
                        CallLog.Calls.DATE + " Asc"); // Asc: sắp theo thứ tự tăng dần
        int number = managedCursor.getColumnIndex(CallLog.Calls.NUMBER);
        int type = managedCursor.getColumnIndex(CallLog.Calls.TYPE);
        int date = managedCursor.getColumnIndex(CallLog.Calls.DATE);
        int duration = managedCursor.getColumnIndex(CallLog.Calls.DURATION);
        //Log.d("Call_Logs", "Call Details :");
        while (managedCursor.moveToNext()) {
            // lay cac cot trong cursor
            String phNumber = managedCursor.getString(number);
            //String callType = managedCursor.getString(type);
            String callDate = managedCursor.getString(date);
            Date callDayTime = new Date(Long.valueOf(callDate));
            String callDuration = managedCursor.getString(duration);

            // hiển thị toan bo lich su cuoc goi
            String cuocgoi = "Phone Number:--- " + phNumber
                    + " \nCall Type:--- " + "?" + " \nCall Date:--- "
                    + callDayTime + " \nCall duration in sec :--- "
                    + callDuration + "\n----------------------------------";
            list2.add(cuocgoi);
            adapter2.notifyDataSetChanged();
        }
        managedCursor.close();

        // Trở về
        backCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}