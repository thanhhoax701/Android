package com.example.recyclerview_gridlayoutmanagercardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
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

        // spanCount: số cột muốn hiển thị
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        rcvUser.setLayoutManager(gridLayoutManager);

        // Xét dữ liệu cho adapter
        mUserAdapter.setData(getListUser());
        rcvUser.setAdapter(mUserAdapter);
    }

    private List<User> getListUser () {
        List<User> list = new ArrayList<>();
        list.add(new User(R.drawable.bg1, "Username 1"));
        list.add(new User(R.drawable.bg2, "Username 2"));
        list.add(new User(R.drawable.bg3, "Username 3"));

        list.add(new User(R.drawable.bg3, "Username 4"));
        list.add(new User(R.drawable.bg2, "Username 5"));
        list.add(new User(R.drawable.bg1, "Username 6"));

        list.add(new User(R.drawable.bg1, "Username 7"));
        list.add(new User(R.drawable.bg2, "Username 8"));
        list.add(new User(R.drawable.bg3, "Username 9"));

        list.add(new User(R.drawable.bg3, "Username 10"));
        list.add(new User(R.drawable.bg2, "Username 11"));
        list.add(new User(R.drawable.bg1, "Username 12"));

        list.add(new User(R.drawable.bg1, "Username 13"));
        list.add(new User(R.drawable.bg2, "Username 14"));
        list.add(new User(R.drawable.bg3, "Username 15"));

        return list;
    }
}