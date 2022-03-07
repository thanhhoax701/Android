package com.example.b4_tranthanhhoa_b1908387;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        final String arr[]=getResources().getStringArray(R.array.myarray);
        ListView lv2 = (ListView) findViewById(R.id.dssv2);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr);
        lv2.setAdapter(adapter);
        final TextView txt = (TextView) findViewById(R.id.svchon2);
        lv2.setOnItemClickListener(
                // Dùng để thiết lập sự kiện cho ListView, interface này có 1 phương thức trừu tượng là onItemClick
                new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                        //đối số arg2 là vị trí phần tử trong Data Source (arr)
                        txt.setText("position :" + arg2 + " ; value =" + arr[arg2]);
                    }


                });
    }
}