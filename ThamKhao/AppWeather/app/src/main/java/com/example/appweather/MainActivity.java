package com.example.appweather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    EditText edtSearch;
    Button btnChangeActivity;
    TextView txtViewName, txtViewCountry, txtViewTemp, txtViewStatus, txtViewHumidity, txtViewCloud, txtViewMill, txtViewDay;
    ImageView iconSearch, imgIcon;

    String City = "", lat, lon;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        Anhxa();
        // gán 1 thành phố mặc định khi mở app
        getCurrentWeatherData("Saigon");
        getOneCallApi(lat, lon);

        iconSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String city = edtSearch.getText().toString();
                // Cách 1
                if (city.equals("")) {
                    city = "Saigon";
                    getCurrentWeatherData(City);
                }
                else {
                    City = city;
                    getCurrentWeatherData(City);
                }
                // Cách 2
//                if (TextUtils.isEmpty(city)) {
//                    Toast.makeText(context, "Bạn chưa nhập dữ liệu", Toast.LENGTH_SHORT).show();
//                    return;
//                }
                getCurrentWeatherData(city);
            }
        });

        btnChangeActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String city = edtSearch.getText().toString();
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("name", city);
                startActivity(intent);
            }
        });
    }

    public void getCurrentWeatherData(String data) {
        // Thực thi những request mà mình gửi đi
        // Cú pháp Request của thư viện Volley
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        String url = "https://api.openweathermap.org/data/2.5/weather?q="+data+"&units=metric&lang=vi&appid=7b16a3bb0d4c6253ab56ca6a2a14f500";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Dòng dưới là hiển thị ra Logcat để coi thử thôi
                         Log.d("ketqua", response);
                        try {
                            // Gán biến response vào để đọc dữ liệu từ Object
                            JSONObject jsonObject = new JSONObject(response);

                            // Lấy lon và lat
                            JSONObject jsonObjectLonLat = jsonObject.getJSONObject("coord");
                            lat = jsonObjectLonLat.getString("lon");
                            lon = jsonObjectLonLat.getString("lat");
                            Log.d("lat", lat);
                            Log.d("lon", lon);

                            // Lấy ra tên thành phố
                            String name = jsonObject.getString("name");

                            // Xét text cho tên thành phố
                            txtViewName.setText("Tên thành phố: " + name);

                            // Lấy ra ngày tháng
                            String day = jsonObject.getString("dt");
                            // Chuyển biến day về dạng long
                            long l = Long.valueOf(day);
                            // Giá trị mili giây
                            Date date = new Date(l*1000L);
                            // Định dạng thứ ngày tháng năm giờ phút giây
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE, d MMM yyyy HH:mm:ss");
                            String Day = simpleDateFormat.format(date);

                            // Xét text cho ngày
                            txtViewDay.setText(Day);


                            // Lấy dữ liệu từ tag "weather" ---------
                            // Dòng đầu có nghĩa là lấy dữ liệu trong tag weather từ object lớn về
                            JSONArray jsonArrayWeather= jsonObject.getJSONArray("weather");
                            JSONObject jsonObjectWeather = jsonArrayWeather.getJSONObject(0);
                            // Lấy phần tử trong "weather"
                            String status = jsonObjectWeather.getString("description");
                            String icon = jsonObjectWeather.getString("icon");

                            // Vào đường dẫn https://openweathermap.org/weather-conditions -> vào mục How to get icon URL để lấy link icon
                            // Gọi lại thư viện PICASSO
                            // Sử dụng with để cho biết đang ở trang hiện tại
                            // sử dụng load để lấy đường dẫn của icon về
                            // sử dụng into để hiển thị ra màn hình, bên trong into là tên biến của cái icon đã được đặt để hiển thị
                            Picasso.with(MainActivity.this).load("https://openweathermap.org/img/wn/"+icon+".png").into(imgIcon);

                            // Xét text cho status: kiểu như in ra màn hình vậy
                            txtViewStatus.setText(status);


                            // Lấy dữ liệu từ tag "main" ---------
                            // Dòng đầu có nghĩa là lấy dữ liệu trong tag main từ object lớn về
                            JSONObject jsonObjectMain = jsonObject.getJSONObject("main");
//                            String nhietdo = jsonObjectMain.getString("temp");
                            String doam = jsonObjectMain.getString("humidity");

                            // Nhiệt độ có kiểu dữ liệu là double
                            // -> cần chuyển đổi nhiệt độ sang kiểu int
//                            Double a = Double.valueOf(nhietdo);
                            // Đổi về kiểu int bằng intValue rồi đổi sang chuỗi
//                            String Nhietdo = String.valueOf(a.intValue());

                            // Xét text cho nhiệt độ và độ ẩm
//                            txtViewTemp.setText(Nhietdo+"°C");
                            txtViewHumidity.setText(doam+"%");


                            // Lấy dữ liệu từ tag "wind" ---------
                            JSONObject jsonObjectWind = jsonObject.getJSONObject("wind");
                            String gio = jsonObjectWind.getString("speed");

                            // Xét text cho tốc độ  gió
                            txtViewMill.setText(gio+"m/s");


                            // Lấy dữ liệu từ tag "clouds" ---------
                            JSONObject jsonObjectCloud = jsonObject.getJSONObject("clouds");
                            String may = jsonObjectCloud.getString("all");
                            txtViewCloud.setText(may+"%");


                            // Lấy dữ liệu từ tag "sys" ---------
                            JSONObject jsonObjectSys = jsonObject.getJSONObject("sys");
                            String country = jsonObjectSys.getString("country");

                            // Xét text cho country
                            txtViewCountry.setText("Tên quốc gia: " + country);
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

    public void getOneCallApi (String lat1, String lon1) {
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
//        String url = "https://api.openweathermap.org/data/2.5/onecall?lat="+lat+"&lon="+lon+"&appid=7b16a3bb0d4c6253ab56ca6a2a14f500";
        String url = "https://api.openweathermap.org/data/2.5/onecall?lat="+lat1+"&lon="+lon1+"&appid=7b16a3bb0d4c6253ab56ca6a2a14f500";
        Log.d("url", url);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("HI", response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONObject jsonObjectCurrent = jsonObject.getJSONObject("current");
                            String nhietdo = jsonObjectCurrent.getString("temp");

                            // Nhiệt độ có kiểu dữ liệu là double
                            // -> cần chuyển đổi nhiệt độ sang kiểu int
                            Double a = Double.valueOf(nhietdo);
                            // Đổi về kiểu int bằng intValue rồi đổi sang chuỗi
                            String Nhietdo = String.valueOf(a.intValue());

                            // Xét text cho nhiệt độ và độ ẩm
                            txtViewTemp.setText(Nhietdo+"°C");


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("error", "hoa");
                    }
                });
        requestQueue.add(stringRequest);
    }

    // Ánh xạ để lấy từng thành phần đã được đặt id
    private void Anhxa() {
        edtSearch = (EditText) findViewById(R.id.editTextSearch);
        iconSearch = (ImageView) findViewById(R.id.iconSearch);
        btnChangeActivity = (Button) findViewById(R.id.buttonChangeActivity);
        txtViewName = (TextView) findViewById(R.id.textViewName);
        txtViewCountry = (TextView) findViewById(R.id.textViewCountry);
        txtViewTemp = (TextView) findViewById(R.id.textViewTemp);
        txtViewStatus = (TextView) findViewById(R.id.textViewStatus);
        txtViewHumidity = (TextView) findViewById(R.id.textViewHumidity);
        txtViewCloud = (TextView) findViewById(R.id.textViewCloud);
        txtViewMill = (TextView) findViewById(R.id.textViewMill);
        txtViewDay = (TextView) findViewById(R.id.textViewDay);
        imgIcon = (ImageView) findViewById(R.id.imageIcon);
    }


    // Tạo option menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_tuychon, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Tải ImageView đã khai báo trong Layout để đặt hình vào.
        ImageView hinh = (ImageView) findViewById(R.id.imageIcon);
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.item1:
                return true;
            case R.id.item2:
                return true;
            case R.id.item3:
                String city = edtSearch.getText().toString();
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("name", city);
                startActivity(intent);
                return true;
            case R.id.item4:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}