package com.example.recyclerviewlinearlayoutmanagerverticalcardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rcvUser;
    private UserAdapter mUserAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcvUser = findViewById(R.id.rcv_user);
        mUserAdapter = new UserAdapter(this);

        // Horizontal thì đổi lại
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcvUser.setLayoutManager(linearLayoutManager);

        // Xét dữ liệu cho adapter
        mUserAdapter.setData(getListUser());
        rcvUser.setAdapter(mUserAdapter);
    }

    private List<User> getListUser () {
        List<User> list = new ArrayList<>();
        list.add(new User(R.drawable.may, "Bây giờ", "16°C", "1m/s"));
        list.add(new User(R.drawable.may, "15:00", "17°C", "2m/s"));
        list.add(new User(R.drawable.may, "15:00", "18°C", "3m/s"));

        list.add(new User(R.drawable.may, "15:00", "19°C", "4m/s"));
        list.add(new User(R.drawable.may, "15:00", "20°C", "5m/s"));
        list.add(new User(R.drawable.may, "15:00", "21°C", "6m/s"));

        return list;
    }
}