package com.example.listanimals;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    ArrayList<Animals> arrayList;
    AnimalsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.lvAnimals);
        arrayList = new ArrayList<>();

        arrayList.add(new Animals("Chó", "6 tuổi", R.drawable.cho));
        arrayList.add(new Animals("Mèo", "2 tuổi", R.drawable.meo));
        arrayList.add(new Animals("Bò", "2 tuổi", R.drawable.bo));
        arrayList.add(new Animals("Heo", "1 tuổi", R.drawable.heo));

        adapter = new AnimalsAdapter(this, R.layout.dong_animals, arrayList);
        lv.setAdapter(adapter);
    }
}