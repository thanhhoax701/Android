package com.example.b4_tranthanhhoa_b1908387;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class Activity4 extends AppCompatActivity {

    EditText editId,editName;
    Button btnNhap;
    RadioGroup radgroup;
    ListView lvSinhvien;
    ArrayList<Nhom> arrSinhvien = new ArrayList<Nhom>();
    ArrayAdapter<Nhom>adapter = null;
    //Khai báo 1 sinhvien object
    Nhom sinhvien = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        editId = (EditText) findViewById(R.id.editMa);
        editName = (EditText) findViewById(R.id.editTen);
        btnNhap = (Button) findViewById(R.id.btnnhap);
        radgroup = (RadioGroup) findViewById(R.id.radiogroud1);
        lvSinhvien = (ListView) findViewById(R.id.lvsinhvien);
        //đưa Data Source là các sinhvien vào Adapter
        adapter = new ArrayAdapter<Nhom>(this, android.R.layout.simple_list_item_1, arrSinhvien);
        //đưa adapter vào ListView
        lvSinhvien.setAdapter(adapter);
        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                processNhap();
            }
        });
    }

    //Xử lý sự kiện nhập
    public void processNhap() {
        //Lấy ra đúng id của Radio Button được checked
        int radId = radgroup.getCheckedRadioButtonId();
        String id = editId.getText() + "";
        String name = editName.getText() + "";
        if(radId==R.id.radNhom1) {
            //tạo instance là Nhom1
            sinhvien=new Nhom_1();
        }
        else {
            //Tạo instance là Nhom2
            sinhvien=new Nhom_2();
        }
        //Nhom1 hay Nhom2 thì cũng là Sinhvien
        //nên có các hàm này là hiển nhiên
        sinhvien.setId(id);
        sinhvien.setName(name);
        //Đưa sinhvien vào ArrayList
        arrSinhvien.add(sinhvien);
        //Cập nhập giao diện
        adapter.notifyDataSetChanged();
    }
    //Tạo các lớp chức năng để sử dụng trong Activity4
    public abstract class Nhom {
        private String id;
        private String name;
        public String getId() {
            return id;
        }
        public void setId(String id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public abstract double TinhThu();
        @Override
        public String toString() {
            // TODO Auto-generated method stub
            return this.id + " - " + this.name;
        }
    }

    public class Nhom_1 extends Nhom {
        @Override
        public double TinhThu() {
            return 3;
        }
        @Override
        public String toString() {
            // TODO Auto-generated method stub
            return super.toString() + " - Nhom 1 - Thứ" + TinhThu();
        }
    }

    public class Nhom_2 extends Nhom {
        @Override
        public double TinhThu() {
            // TODO Auto-generated method stub
            return 4;
        }
        @Override
        public String toString() {
            // TODO Auto-generated method stub
            return super.toString() + " - Nhom 2 - Thứ" + TinhThu();
        }
    }
}