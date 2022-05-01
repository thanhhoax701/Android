package com.example.b4_tranthanhhoa_b1908387;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        //1. Khởi tạo dữ liệu cho mảng arr (còn gọi là data source)
        final String arr[] = {"Nguyen Van Manh", "Tran Van Giau", "Le Van Sung", "Pham van Tien"};
        //2. Lấy đối tượng Listview dựa vào id
        ListView lv1 = findViewById(R.id.dssv1);
        //3. Gán Data source vào ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr);
        //4. Đưa Data source vào ListView
        lv1.setAdapter(adapter);
        //5. Khai báo TextView
        final TextView txt = findViewById(R.id.svchon1);
        //6. Thiết lập sự kiện cho Listview, khi chọn phần tử nào thì hiển thị lên TextView
        lv1.setOnItemClickListener(
                // Dùng để thiết lập sự kiện cho ListView, interface này có 1 phương thức trừu tượng là onItemClick
                new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                        //đối số arg2 là vị trí phần tử trong Data Source (arr)
                        txt.setText("position :" + arg2 + " ; value =" + arr[arg2]);
                    }
                });
    }
}