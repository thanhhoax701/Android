package com.example.b10_tranthanhhoa_b1908387;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Environment;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    EditText textBox;
    Button SaveExt, LoadExt, help;
    static final int READ_BLOCK_SIZE = 100;

    /**
     * Called when the activity is first created.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textBox = (EditText) findViewById(R.id.txtText1);
        SaveExt = (Button) findViewById(R.id.btnSave2);
        LoadExt = (Button) findViewById(R.id.btnLoad2);

        help = (Button) findViewById(R.id.help);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tnt = new Intent(MainActivity.this, StaticResources.class);
                startActivity(tnt);
            }
        });

    }


    // LƯU VÀO BỘ NHỚ TRONG
    public void onClickSaveInternal(View view) {
        String str = textBox.getText().toString();
        try {
            FileOutputStream fOut = openFileOutput("textfile.txt", MODE_APPEND);
            OutputStreamWriter osw = new OutputStreamWriter(fOut);
            //---write the string to the file---
            osw.write(str);
            osw.flush();
            osw.close();
            //---display file saved message---
//            Toast.makeText(getBaseContext(), "File saved successfully!", Toast.LENGTH_SHORT).show();
            displayToast(str);
            //---clears the EditText---
            textBox.setText(" ");
        } catch (IOException ioe) {
            Toast.makeText(this, "File save failed!", Toast.LENGTH_SHORT).show();
            ioe.printStackTrace();
        }
    }


    // TẢI TỪ BỘ NHỚ TRONG
    public void onClickLoadInternal(View view) {
        try {
            //……………………………………………………………………………………………………….
            FileInputStream fIn = openFileInput("textfile.txt");
            InputStreamReader isr = new InputStreamReader(fIn);
            char[] inputBuffer = new char[READ_BLOCK_SIZE];
            String s = "";
            int charRead;
            while ((charRead = isr.read(inputBuffer)) > 0) {
                //---convert the chars to a String---
                String readString = String.copyValueOf(inputBuffer, 0, charRead);
                s += readString;
                inputBuffer = new char[READ_BLOCK_SIZE];
            }
            //---set the EditText to the text that has been
            // read---
            textBox.setText(s);
//            Toast.makeText(getBaseContext(), "File loaded successfully!", Toast.LENGTH_SHORT).show();
            displayToast(s);
        } catch (IOException ioe) {
            Toast.makeText(this, "Vui lòng thêm nội dung vào bộ nhớ trong!!!", Toast.LENGTH_SHORT).show();
            ioe.printStackTrace();
        }
    }


    // LƯU VÀO BỘ NHỚ NGOÀI
    public void onClickSaveExternal(View view) {
        String str = textBox.getText().toString();
        try {
            //---Luu tren SD Card---
            File sdCard = Environment.getExternalStorageDirectory();
            File directory = new File(sdCard.getAbsolutePath() + "/MyFiles");
            directory.mkdirs();
            File file = new File(directory, "textfile.txt");
            // Mở file
            FileOutputStream fOut = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(fOut);
            //---write the string to the file---
            osw.write(str);
            osw.flush();
            osw.close();
            //---display file saved message---
//            Toast.makeText(getBaseContext(), "File saved successfully!", Toast.LENGTH_SHORT).show();
            displayToast(str);
            //---clears the EditText---
            textBox.setText(" ");
        } catch (IOException ioe) {
            Toast.makeText(this, "File save failed!", Toast.LENGTH_SHORT).show();
            ioe.printStackTrace();
        }
    }


    // TẢI TỪ BỘ NHỚ NGOÀI
    public void onClickLoadExternal(View view) {
        try {
            //--- Đọc file lưu trên SD---
            File sdCard = Environment.getExternalStorageDirectory();
            File directory = new File(sdCard.getAbsolutePath() + "/MyFiles");
            File file = new File(directory, "textfile.txt");
            FileInputStream fIn = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fIn);
            char[] inputBuffer = new char[READ_BLOCK_SIZE];
            String s = "";
            int charRead;
            while ((charRead = isr.read(inputBuffer)) > 0) {
                //---convert the chars to a String---
                String readString = String.copyValueOf(inputBuffer, 0, charRead);
                s += readString;
                inputBuffer = new char[READ_BLOCK_SIZE];
            }
            //---set the EditText to the text that has been
            // read---
            textBox.setText(s);
//            Toast.makeText(getBaseContext(), "File loaded successfully!", Toast.LENGTH_SHORT).show();
            displayToast(s);
        } catch (IOException ioe) {
            Toast.makeText(this, "Vui lòng thêm nội dung vào bộ nhớ ngoài!!!", Toast.LENGTH_SHORT).show();
            ioe.printStackTrace();
        }
    }


    // Hiển thị nội dung
    public void displayToast(String str) {
        Toast toast1 = new Toast(this);
        toast1.setGravity(Gravity.CENTER, 0, 50);
        TextView tv1 = new TextView(this);
        tv1.setBackgroundColor(Color.BLACK);
        tv1.setTextColor(Color.YELLOW);
        tv1.setTextSize(25);
        Typeface t1 = Typeface.create("serif", Typeface.BOLD);
        tv1.setTypeface(t1);
        tv1.setPadding(10, 10, 10, 10);
        tv1.setText(str);
        toast1.setView(tv1);
        toast1.setDuration(Toast.LENGTH_LONG);
        toast1.show();
    }


    // XOÁ FILE TRÊN BỘ NHỚ TRONG
    public void onClickDeleteInternal(View view) {
//        Toast.makeText(this, "Hello internal", Toast.LENGTH_SHORT).show();
        String kqxoa = "";
        boolean thongtinxoa = deleteFile("textfile.txt");
//        String a = Boolean.toString(thongtinxoa);
        if (thongtinxoa == true) {
            kqxoa = "Xoá tập tin thành công";
        } else {
            kqxoa = "Xoá tập tin không thành công";
        }
        textBox.setText(" ");
        displayToast(kqxoa);
    }


    // XOÁ FILE TRÊN BỘ NHỚ NGOÀI
    public void onClickDeleteExternal(View view) {
//        Toast.makeText(this, "Hello external", Toast.LENGTH_SHORT).show();
        String kqxoa = "";
        // Tìm đường dẫn đến thư mục chứa tập tin
//        String root = Environment.getExternalStorageState().toString();
//        // Khai báo tập tin
//        File filesdcard = new File(root+"/Myfile.txt");
        File sdCard = Environment.getExternalStorageDirectory();
        File root = new File(sdCard.getAbsolutePath() + "/MyFiles");
        File filesdcard = new File(root, "textfile.txt");
        //Xóa tập tin
        boolean xoatc = filesdcard.delete();
        if (xoatc == true) {
            kqxoa = "Xoá tập tin thành công";
        } else {
            kqxoa = "Xoá tập tin không thành công";
        }
//        Toast.makeText(getBaseContext(),kqxoa,Toast.LENGTH_SHORT).show();
        displayToast(kqxoa);
        textBox.setText(" ");
    }
}