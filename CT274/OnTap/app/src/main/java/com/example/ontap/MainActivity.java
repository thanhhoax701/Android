package com.example.ontap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    EditText edt1;
    CheckBox checkBox;
    Button btnContextmenu, btnExit;
    ImageView imgShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Anhxa();

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                boolean checked = ((CheckBox) view).isChecked();
                if (((CheckBox) view).isChecked()) {
                    btnContextmenu.setVisibility(View.VISIBLE);
                }
                else {
                    btnContextmenu.setVisibility(View.INVISIBLE);
                }
            }
        });


        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        registerForContextMenu(btnContextmenu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_context, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuItem_xemAnh:
                imgShow.setImageResource(R.drawable.pitpull);
                break;
            case R.id.menuItem_diemTB:
                startActivity(new Intent(this, Activity2.class));
                break;
        }
        return true;
    }

    private void Anhxa() {
        edt1 = findViewById(R.id.edt1);
        checkBox = findViewById(R.id.checkbox);
        btnContextmenu = findViewById(R.id.btnContextMenu);
        imgShow = findViewById(R.id.imgShow);
        btnExit = findViewById(R.id.btnExit);
    }
}