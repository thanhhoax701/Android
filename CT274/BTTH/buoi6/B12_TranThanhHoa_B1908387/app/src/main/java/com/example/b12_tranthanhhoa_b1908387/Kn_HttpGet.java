package com.example.b12_tranthanhhoa_b1908387;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class Kn_HttpGet extends AppCompatActivity {
    public InputStream OpenHttpConnection(String urlString) throws IOException {
        /******** (1) Tạo đối tượng InputStream ********/
        InputStream in = null;
        int response = -1;
        URL url = new URL(urlString);
        // Mở kết nối tới urlString
        URLConnection conn = url.openConnection();
        // Nếu không là một HttpURLConnection
        // thì thông báo không có kết nối HTTP
        if (!(conn instanceof HttpURLConnection)) throw new IOException("Not an HTTP connection");
        try {
            /******** (2) Mở kết nối HTTP với URL từ xa ********/
            HttpURLConnection httpConn = (HttpURLConnection) conn;
            /******** (3) Thiết lập các thuộc tính kết nối ********/
            //Hàm đặt cờ để xác định giao thức sẽ
            // tự động theo địa chỉ mới (true) hoặc không
            httpConn.setInstanceFollowRedirects(true);
            //Xác định phương thức kết nối là GET
            httpConn.setRequestMethod("GET");
            //Kết nối với máy chủ
            httpConn.connect();
            /* (4) Lấy đáp ứng HTTP_OK để biết kết nối đã được thiết lập hay chưa */
            response = httpConn.getResponseCode();
            Log.w("Response Code", "" + response);

            /*****************************************************************
             * (5) Nếu kết nối được thiết lập thì tiến hành
             lấy đối tượng InputStream từ kết nối để lấy dữ liệu từ Server
             ******************************************************************/
            if (response == HttpURLConnection.HTTP_OK) {
                in = httpConn.getInputStream();
            }
        } catch (Exception e) {
            Log.e("Networking", e.getLocalizedMessage());
        }
        return in;
    }

    private Bitmap DownloadImage(String URL) {
        Bitmap bitmap = null;
        InputStream in = null;
        try {
            // Mở kết nối đến Server, phương thức đã được định nghĩa ở trên
            in = OpenHttpConnection(URL);
            if (in == null) {
                Log.e("Image URL", "Check connection or URL again!");
                return bitmap;
            }
            // Tải dữ liệu thông qua InputStream in
            // và giải mã vào đối tượng bitmap
            bitmap = BitmapFactory.decodeStream(in);
            in.close();
        } catch (IOException e) {
            Log.e("NetworkingActivity", e.getLocalizedMessage());
        }
        return bitmap;
    }

//     ***************************************************************************/
    public class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        //Thực hiện tải dữ liệu
        // Khi hoàn tất, kết quả được truyền vào phương thức onPostExecute
        @Override
        protected Bitmap doInBackground(String... urls) {
            return DownloadImage(urls[0]);
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            ImageView img = (ImageView) findViewById(R.id.img);
            //Hiển thị ảnh trên màn hình
            img.setImageBitmap(result);
            TextView tv = (TextView) findViewById(R.id.tvURLimg);
            if (result != null)
                tv.setText("Got image.");
            else
                tv.setText("Can't get image.");
        }
    }

    private String DownloadText(String URL) {
        int BUFFER_SIZE = 2000;
        InputStream in = null;
        String str = "";
        try {
            in = OpenHttpConnection(URL);
        } catch (IOException e) {
            Log.e("Networking", e.getLocalizedMessage());
            return str;
        }
        if (in == null) {
            Log.e("Text URL", "Check connection or URL again!");
            return str;
        }
        try {
            InputStreamReader isr = new InputStreamReader(in);
            int charRead;
            char[] inputBuffer = new char[BUFFER_SIZE];
            while ((charRead = isr.read(inputBuffer)) > 0) {
                //Chuyển chars thành String
                String readString = String.copyValueOf(inputBuffer, 0,
                        charRead);
                str += readString;
                inputBuffer = new char[BUFFER_SIZE];
            }
            in.close();
        } catch (IOException e) {
            Log.e("Networking", e.getLocalizedMessage());
            return str;
        }
        return str;
    }

    public class DownloadTextTask extends AsyncTask<String, Void, String> {
        protected String doInBackground(String... urls) {
            return DownloadText(urls[0]);
        }

        @Override
        protected void onPostExecute(String result) {
            TextView tv1 = findViewById(R.id.tv);
            tv1.setText(result);
            TextView tv = findViewById(R.id.tvURLtext);
            if (!result.trim().equals(""))
                tv.setText("Got text.");
            else
                tv.setText("Can't get text.");
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kn_http_get);
//        String URL = "http://192.168.0.103:88/Buoi_6/";

        TextView tvDownload1 = (TextView) findViewById(R.id.tvLoadimg);
        tvDownload1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText loadanh = (EditText) findViewById(R.id.nhapurl1);
                // Nhập https://kynguyenlamdep.com/wp-content/uploads/2020/01/anh-thien-nhien-dep.jpg?is-pending-load=1
                // Nhập https://vcdn-vnexpress.vnecdn.net/2021/03/02/103650164-731814290963011-1374-5806-7233-1614677857.jpg
                // Nhập http://192.168.0.103:88/Buoi_6/cantho_3.png
                String url1 = loadanh.getText().toString();
                TextView txt1 = findViewById(R.id.tvURLimg);
                //Thực thi tải dữ liệu hình ảnh
//                new DownloadImageTask().execute(URL+"cantho_3.png");
                new DownloadImageTask().execute(url1);
//                txt1.setText("Got Image");
            }
        });

        //Thực thi tải dữ liệu văn bản
        TextView tvDownLoad2 = findViewById(R.id.tvLoadtext);
        tvDownLoad2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText loadText = findViewById(R.id.nhapurl2);
                // Nhập https://vanmautuyenchon.net/the-loai-3/nghe-va-ke-lai-cau-chuyen-nang-niu-tung-hat-giong-tap-lam-van-lop-3.html
                // Nhập https://www.ctu.edu.vn/
                // Nhập http://192.168.46.245:88/Buoi_6/Thuhttpget.txt
                String url2 = loadText.getText().toString();
                TextView txt2 = findViewById(R.id.tvURLtext);
                //Thực thi tải dữ liệu hình ảnh
//                new DownloadTextTask().execute(URL+"Thuhttpget.txt");
                new DownloadTextTask().execute(url2);
//                txt2.setText("Got Text");
            }
        });
    }
}