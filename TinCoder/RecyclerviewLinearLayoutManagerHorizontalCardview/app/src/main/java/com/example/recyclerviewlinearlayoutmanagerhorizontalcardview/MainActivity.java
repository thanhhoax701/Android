package com.example.recyclerviewlinearlayoutmanagerhorizontalcardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

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
        listBook.add(new Book(R.drawable.bg1, "Book 1"));
        listBook.add(new Book(R.drawable.bg2, "Book 2"));
        listBook.add(new Book(R.drawable.bg3, "Book 3"));
        listBook.add(new Book(R.drawable.bg4, "Book 4"));

        listBook.add(new Book(R.drawable.bg1, "Book 5"));
        listBook.add(new Book(R.drawable.bg2, "Book 6"));
        listBook.add(new Book(R.drawable.bg3, "Book 7"));
        listBook.add(new Book(R.drawable.bg4, "Book 8"));

        listCategory.add(new Category("Category 1", listBook));
        listCategory.add(new Category("Category 2", listBook));
        listCategory.add(new Category("Category 3", listBook));
        listCategory.add(new Category("Category 4", listBook));
        listCategory.add(new Category("Category 5", listBook));
        listCategory.add(new Category("Category 6", listBook));
        listCategory.add(new Category("Category 7", listBook));
        listCategory.add(new Category("Category 8", listBook));

        return listCategory;
    }
}