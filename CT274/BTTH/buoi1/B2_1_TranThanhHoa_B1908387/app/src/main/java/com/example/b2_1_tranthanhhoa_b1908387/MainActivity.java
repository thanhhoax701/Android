package com.example.b2_1_tranthanhhoa_b1908387;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnContextMenu, btnPopupMenu, thoat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnContextMenu = (Button) findViewById(R.id.btnContextMenu);
        btnContextMenu.setOnCreateContextMenuListener(this);
        btnPopupMenu = (Button) findViewById(R.id.btnPopupMenu);
        thoat = (Button) findViewById(R.id.btnthoat);
        thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });

        btnPopupMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu();
            }
        });

    }

    // Tạo ra Option menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_tuychon, menu);
        return true;
    }

    // Xử lý thao tác click chọn item
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Tải ImageView đã khai báo trong Layout để đặt hình vào.
        ImageView hinh = (ImageView) findViewById(R.id.img);
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.item1:
                // Đặt lại ảnh mới với file chimp.png trong res/drawable
                hinh.setImageResource(R.drawable.chimp);
                return true;
            case R.id.item2:
                hinh.setImageResource(R.drawable.crowned_crane);
                return true;
            case R.id.item3:
                hinh.setImageResource(R.drawable.dolphin);
                return true;
            case R.id.item4:
                hinh.setImageResource(R.drawable.drake);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_ngucanh, menu);
    }
    // Xử lý click chọn item trên Context menu
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.item1:
                Toast toast=new Toast(this); // Tạo 1 đối tượng Toast
                toast.setGravity(Gravity.CENTER,100,100); // Đặt vị trí của Toast.
                TextView tv=new TextView(this); // Khai bào 1 TextView.
                tv.setBackgroundColor(Color.BLUE); // Đặt màu nền.
                tv.setTextColor(Color.WHITE); // Đặt màu Text.
                tv.setTextSize(25); // Đặt cỡ chữ.
                Typeface t=Typeface.create("serif",Typeface.BOLD);//Chọn kiểu chữ.
                tv.setTypeface(t); // Đặt kiểu chữ.
                tv.setPadding(10,10,10,10);// Đặt vùng đệm
                tv.setText("Bộ phận tiếp thị; \n Bộ phận nhập hàng; \n Bộ phận giao hàng; \n Bộ phận kế toán;");
                toast.setView(tv); // Đặt text cho toast.
                toast.setDuration(Toast.LENGTH_LONG); // Đặt thời gian hiển thị.
                toast.show(); // Hiển thị toast.
                return true;
            case R.id.item2_1:
                Toast toast1=new Toast(this);
                toast1.setGravity(Gravity.CENTER,100,100);
                TextView tv1=new TextView(this);
                tv1.setBackgroundColor(Color.BLACK);
                tv1.setTextColor(Color.YELLOW);
                tv1.setTextSize(25);
                Typeface t1=Typeface.create("serif",Typeface.BOLD);
                tv1.setTypeface(t1);
                tv1.setPadding(10,10,10,10);
                tv1.setText("1. Trần Ngọc Thơ;\n 2. Nguyễn Văn Toàn;\n 3. Lê Thị Hoa;");
                toast1.setView(tv1);
                toast1.setDuration(Toast.LENGTH_LONG);
                toast1.show();
                return true;
            case R.id.item2_2:
                Toast toast2=new Toast(this);
                toast2.setGravity(Gravity.CENTER,100,100);
                TextView tv2=new TextView(this);
                tv2.setBackgroundColor(Color.BLACK);
                tv2.setTextColor(Color.YELLOW);
                tv2.setTextSize(25);
                Typeface t2=Typeface.create("serif",Typeface.BOLD);
                tv2.setTypeface(t2);
                tv2.setPadding(10,10,10,10);
                tv2.setText("1. Nguyễn văn A; \n 2. Lâm Văn Mới;");
                toast2.setView(tv2);
                toast2.setDuration(Toast.LENGTH_LONG);
                toast2.show();
                return true;
            case R.id.item2_3:
                Toast toast3=new Toast(this);
                toast3.setGravity(Gravity.CENTER,100,100);
                TextView tv3=new TextView(this);
                tv3.setBackgroundColor(Color.BLACK);
                tv3.setTextColor(Color.YELLOW);
                tv3.setTextSize(25);
                Typeface t3=Typeface.create("serif",Typeface.BOLD);
                tv3.setTypeface(t3);
                tv3.setPadding(10,10,10,10);
                tv3.setText("1. Trần Văn Bảy; \n 2. Nguyễn Văn Tâm; \n 3. Châu Thành Quí;");
                toast3.setView(tv3);
                toast3.setDuration(Toast.LENGTH_LONG);
                toast3.show();
                return true;
            case R.id.item2_4:
                Toast toast4=new Toast(this);
                toast4.setGravity(Gravity.CENTER,100,100);
                TextView tv4=new TextView(this);
                tv4.setBackgroundColor(Color.BLACK);
                tv4.setTextColor(Color.YELLOW);
                tv4.setTextSize(25);
                Typeface t4=Typeface.create("serif",Typeface.BOLD);
                tv4.setTypeface(t4);
                tv4.setPadding(10,10,10,10);
                tv4.setText("1. Lê Thị Lý; \n Trần Ngọc Mai.");
                toast4.setView(tv4);
                toast4.setDuration(Toast.LENGTH_LONG);
                toast4.show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }


    // Tạo Popup menu
    private void showPopupMenu(){
        // Tạo 1 popupmenu.
        PopupMenu popupMenu=new PopupMenu(this, btnPopupMenu);
        //Lấy giao diện menu trong resoucse.

        popupMenu.getMenuInflater().inflate(R.menu.menu_popup,popupMenu.getMenu());
        //Lập trình hành động khi chọn item.
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item3_1: btnPopupMenu.setText("MENU COPY");
                    break;
                }
                switch (item.getItemId()) {
                    case R.id.item3_2: btnPopupMenu.setText("MENU PASTE");
                    break;
                }
                switch (item.getItemId()) {
                    case R.id.item3_3: btnPopupMenu.setText("MENU SAVE");
                    break;
                }
                switch (item.getItemId()) {
                    case R.id.item3_4: btnPopupMenu.setText("MENU DELETE");
                        break;
                }
                return false;
            }
        });
        popupMenu.show();
    }
}