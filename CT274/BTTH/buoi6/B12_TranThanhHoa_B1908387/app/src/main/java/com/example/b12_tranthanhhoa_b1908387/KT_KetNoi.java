package com.example.b12_tranthanhhoa_b1908387;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class KT_KetNoi extends AppCompatActivity {
    EditText edtKt;
    Button btn1, btn2;
    TextView tvKt1, tvKt2;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kt_ket_noi);

        Anhxa();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                tvKt1.setText("Kết nối tốt");
                checkInternetConnection();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(KT_KetNoi.this, "Chưa làm được má ơi!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void Anhxa() {
        edtKt = findViewById(R.id.editKt);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        tvKt1 = findViewById(R.id.tvKt1);
        tvKt2 = findViewById(R.id.tvKt2);
        webView = findViewById(R.id.webView);
    }

    private boolean checkInternetConnection() {
        ConnectivityManager connManager =
                (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connManager.getActiveNetworkInfo();

        if (networkInfo == null) {
            tvKt1.setText("Mạng mặc định không hoạt động");
            return false;
        }

        if (!networkInfo.isConnected()) {
            tvKt1.setText("Mạng không được kết nối");
            return false;
        }

        if (!networkInfo.isAvailable()) {
            tvKt1.setText("Mạng chưa sẵn sàng");
            return false;
        }
        tvKt1.setText("Kết nối tốt");
        tvKt2.setText("WIFI");
        return true;
    }
}