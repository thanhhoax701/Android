package com.example.appweather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity2 extends AppCompatActivity {

    String cityName = "";

    ImageView imgBack;
    TextView txtCityName;
    ListView lstView;

    CustomAdapter customAdapter;
    ArrayList<Thoitiet> mangthoitiet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Anhxa();

        // Nhận dữ liệu về
        Intent intent = getIntent();
        String city = intent.getStringExtra("name");
        Log.d("ketqua", "Du lieu truyen qua: " + city);
        if (city.equals("")) {
            cityName = "Saigon";
            get7DaysData(cityName);
        }
        else {
            cityName = city;
            get7DaysData(cityName);
        }
        // Trở về màn hình trước bằng action onBackPressed();
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void Anhxa() {
        imgBack = (ImageView) findViewById(R.id.imageViewBack);
        txtCityName = (TextView) findViewById(R.id.textViewCityName);
        lstView = (ListView) findViewById(R.id.listView);

        mangthoitiet = new ArrayList<Thoitiet>();
        customAdapter = new CustomAdapter(MainActivity2.this, mangthoitiet);
        lstView.setAdapter(customAdapter);
    }

    private void get7DaysData(String data) {
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity2.this);
        String url = "http://api.openweathermap.org/data/2.5/forecast/daily?q="+data+"&lang=vi&units=metric&cnt=7&appid=7b16a3bb0d4c6253ab56ca6a2a14f500";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
//                        Log.d("Ketqua", "JSON: " + response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            // Lấy dữ liệu từ tag "city"
                            JSONObject jsonObjectCity = jsonObject.getJSONObject("city");
                            String cityName = jsonObjectCity.getString("name");
                            txtCityName.setText(cityName);

                            JSONArray jsonArrayList = jsonObject.getJSONArray("list");
                            // Do các thẻ có thuộc tính giống nhau
                            // => dùng for để đọc giá trị của từng thẻ trong tag "list"
                            for (int i = 0; i < jsonArrayList.length(); i++) {
                                JSONObject jsonObjectList = jsonArrayList.getJSONObject(i);
                                String day= jsonObjectList.getString("dt");

                                // Chuyển biến day về dạng long
                                long l = Long.valueOf(day);
                                // Chuyển thành mili giây
                                Date date = new Date(l * 1000L);
                                // Định dạng thứ ngày tháng năm
                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, d MMM");
                                String Day = simpleDateFormat.format(date);

                                JSONObject jsonObjectTemp = jsonObjectList.getJSONObject("temp");
                                String maxTemp = jsonObjectTemp.getString("max");
                                String minTemp = jsonObjectTemp.getString("min");
                                // -> cần chuyển đổi nhiệt độ sang kiểu int
                                Double x = Double.valueOf(maxTemp);
                                Double y = Double.valueOf(minTemp);
                                // Đổi về kiểu int bằng intValue rồi đổi sang chuỗi
                                String NhietdoMax = String.valueOf(x.intValue());
                                String NhietdoMin = String.valueOf(y.intValue());

                                JSONArray jsonArrayWeather = jsonObjectList.getJSONArray("weather");
                                // Do nó có 1 thẻ object thôi
                                JSONObject jsonObjectWeather = jsonArrayWeather.getJSONObject(0);
                                String status = jsonObjectWeather.getString("description");
                                String icon = jsonObjectWeather.getString("icon");

//                                String Day = "Thứ 6 16-10/2001";
//                                String status = "Mưa";
//                                String icon = "04n";
//                                String NhietdoMax = "30°C";
//                                String NhietdoMin = "10°C";
                                mangthoitiet.add(new Thoitiet(Day, status, icon, NhietdoMax, NhietdoMin));
                            }

                            // Cập nhật khi có dữ liệu mới
                            customAdapter.notifyDataSetChanged();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        // thực thi stringRequest
        requestQueue.add(stringRequest);
    }

}