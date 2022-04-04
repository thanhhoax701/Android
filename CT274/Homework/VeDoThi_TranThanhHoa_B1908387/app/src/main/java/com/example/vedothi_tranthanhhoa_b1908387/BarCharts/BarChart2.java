package com.example.vedothi_tranthanhhoa_b1908387.BarCharts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.vedothi_tranthanhhoa_b1908387.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class BarChart2 extends AppCompatActivity {
    BarChart mChart;
    TextView textView,textView2,textView3,textView4,textView5;
    String Des1,Des2,Title;
    BarData databar2;
    double amountbar1,amountbar2;
    ImageButton imageButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart2);

        textView=(TextView)findViewById(R.id.texViewBar);
        textView2=(TextView)findViewById(R.id.textviewtenduong1);
        textView3=(TextView)findViewById(R.id.textviewtenduong2);

        // Tương tác click vào mũi tên trở về.
        imageButton=(ImageButton)findViewById(R.id.imagebuttoncot);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Khai báo gia diện đồ thị BarCharts
        mChart = findViewById(R.id.BarChartMpAndroid);
        // Khai báo Intent và lấy dữ liệu từ BarChartsActivity gởi đến.
        Intent intent = getIntent();
        amountbar1=intent.getDoubleExtra("cot1",123);
        amountbar2=intent.getDoubleExtra("cot2",123);
        Title=intent.getStringExtra("tendothi");
        Des1=intent.getStringExtra("tencot1");
        Des2=intent.getStringExtra("tencot2");
        // Hiển thị tên đồ thị và tên các cột
        textView.setText("Đồ thị: "+Title);
        textView2.setText("1-"+Des1);
        textView3.setText("2-"+Des2);
        // Đặt các thuộc tính của đồ thị
        mChart.setDrawBarShadow(false);
        mChart.setDrawValueAboveBar(true);
        mChart.getDescription().setEnabled(false);
        // if more than 60 entries are displayed in the chart, no values will be
        // drawn
        mChart.setMaxVisibleValueCount(60);
        // scaling can now only be done on x- and y-axis separately
        mChart.setPinchZoom(false);
        mChart.setDrawGridBackground(false);
        XAxis xAxis = mChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextSize(15);
        xAxis.setDrawGridLines(false);
        xAxis.setGranularity(1f); // only intervals of 1 day
        xAxis.setLabelCount(7);
        YAxis leftAxis = mChart.getAxisLeft();
        leftAxis.setLabelCount(8, false);
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        leftAxis.setSpaceTop(15f);
        leftAxis.setTextSize(15);
        leftAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)
        YAxis rightAxis = mChart.getAxisRight();
        rightAxis.setDrawGridLines(false);
        rightAxis.setLabelCount(8, false);
        rightAxis.setTextSize(15);
        rightAxis.setSpaceTop(15f);
        rightAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)
        Legend l = mChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);
        l.setForm(Legend.LegendForm.SQUARE);
        l.setFormSize(9f);
        l.setTextSize(11f);
        l.setXEntrySpace(4f);
        setDataBar2(2, 100); // Xem hàm ở dưới
        mChart.setData(databar2); //Đã khai báo ở trên BarData databar2;
        mChart.setVisibility(View.VISIBLE);
        mChart.invalidate(); // Vẽ lại
    }

    private void setDataBar2(int count, float range) {
        XAxis xAxis= mChart.getXAxis();
        xAxis.setGranularity(1f);
        //float mult=range;
        float start = 1f;
        Double[] Y4={amountbar1,amountbar2};
        ArrayList<BarEntry> yVals2 = new ArrayList<>();
        for (int i = 0; i < count ; i++) {
            double mult = (range);
            double val2 = (double) (Y4[i]);
            yVals2.add(new BarEntry(i+1, (float)(val2)));
        }
        BarDataSet set1; //BarDataSet ở trong thư viện MPAndroidChart
        set1 = new BarDataSet(yVals2, "The year 2022");
        set1.setColors(ColorTemplate.MATERIAL_COLORS);
        int startColor1 = ContextCompat.getColor(this,
                android.R.color.holo_orange_light);
        int startColor2 = ContextCompat.getColor(this,
                android.R.color.holo_blue_light);
        List<Integer> gradientColors = new ArrayList<>();
        gradientColors.add(0, startColor1);
        gradientColors.add(1, startColor2);
        set1.setColors(gradientColors);
        ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
        dataSets.add(set1);
        databar2 = new BarData(dataSets); // Lớp BarData ở trong MPAmdroidChart
        databar2.setValueTextSize(15f);
        databar2.setBarWidth(0.5f);
    }
}