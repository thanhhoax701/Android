package com.example.recyclerviewlinearlayoutmanagerhorizontalcardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import book.Book;
import book.BookAdapter;
import category.Category;
import category.CategoryAdapter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rcvCategory;
    private CategoryAdapter categoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcvCategory = findViewById(R.id.rcv_category);
        categoryAdapter = new CategoryAdapter(this);

        // Category hướng vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        rcvCategory.setLayoutManager(linearLayoutManager);

        categoryAdapter.setData(getListCategory());
        rcvCategory.setAdapter(categoryAdapter);
    }

    private List<Category> getListCategory () {
        List<Category> listCategory = new ArrayList<>();

        List<Book> listBook = new ArrayList<>();
        listBook.add(new Book(R.drawable.may, "Bây giờ", "16°C", "1m/s"));
        listBook.add(new Book(R.drawable.may, "15:00", "17°C", "2m/s"));
        listBook.add(new Book(R.drawable.may, "16:00", "18°C", "3m/s"));
        listBook.add(new Book(R.drawable.may, "17:00", "19°C", "4m/s"));

        listBook.add(new Book(R.drawable.may, "18:00", "20°C", "5m/s"));
        listBook.add(new Book(R.drawable.may, "19:00", "21°C", "6m/s"));
        listBook.add(new Book(R.drawable.may, "20:00", "22°C", "7m/s"));
        listBook.add(new Book(R.drawable.may, "11:00", "23°C", "8m/s"));

        listCategory.add(new Category("Dự báo theo giờ", listBook));

        return listCategory;
    }
}