package com.example.vedothi_tranthanhhoa_b1908387.PieCharts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.vedothi_tranthanhhoa_b1908387.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class pieChart4 extends AppCompatActivity {
    ImageButton imageButton;
    String Des1, Des2, Des3, Des4, Title;
    double amount1, amount2, amount3, amount4;
    TextView textView;
    PieChart pieChartpie;
    PieData data4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart4);

        pieChartpie = (PieChart) findViewById(R.id.PieChartMp);
        imageButton = (ImageButton) findViewById(R.id.imagebutton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        textView = (TextView) findViewById(R.id.laytitle);
        Intent intent = getIntent();
        amount1 = intent.getDoubleExtra("segment1", 123);
        amount2 = intent.getDoubleExtra("segment2", 123);
        amount3 = intent.getDoubleExtra("segment3", 123);
        amount4 = intent.getDoubleExtra("segment4", 123);
        Title = intent.getStringExtra("tendothi");
        Des1 = intent.getStringExtra("Des1");
        Des2 = intent.getStringExtra("Des2");
        Des3 = intent.getStringExtra("Des3");
        Des4 = intent.getStringExtra("Des4");
        textView.setText("????? th???: " + Title);
        //v??? ????? th???
        pieChartpie.setUsePercentValues(true);// ch?? gi???i ch??? b??n trong v??ng tr??n nh???
        pieChartpie.getDescription().setEnabled(false);//b???t d??ng ch??? ch?? th??ch
        pieChartpie.setCenterText(generateCenterSpannableText());//vi???t ch??? b??n trong???????ng tr??n
        pieChartpie.setExtraOffsets(20.f, 0.f, 20.f, 0.f);// ?????nh v??? tr?? c???a ????? th???
        //t???o ???????ng tr??n ??? trong
        pieChartpie.setDrawHoleEnabled(true);//v??? ???????ng vi???n b??n trong
        pieChartpie.setHoleColor(Color.WHITE);//m??u n???n c???a ???????ng tr??n b??n trong
        //t???o ???????ng vi???n b??n trong h??nht tr??n
        pieChartpie.setTransparentCircleColor(Color.WHITE);//m??u c???a ???????ng vi???n
        pieChartpie.setTransparentCircleAlpha(110);//k??ch c??? ???????ng vi???n
        // pieChartpie.setCenterTextColor(Color.RED);//
        pieChartpie.setHoleRadius(52f);//58 s??? ????? c??ng c???a ???????ng vi???n tr??n
        pieChartpie.setTransparentCircleRadius(55f);//61
        pieChartpie.setDrawCenterText(true);
//
        setData4(4, 100);
        pieChartpie.setData(data4);
        pieChartpie.setVisibility(View.VISIBLE);
    }

    private SpannableString generateCenterSpannableText() {
        SpannableString s = new SpannableString("PieChartAndroid");
        s.setSpan(new RelativeSizeSpan(1.5f), 0, 15, 0);
        s.setSpan(new StyleSpan(Typeface.ITALIC), s.length() - 15, s.length(), 0);
        s.setSpan(new ForegroundColorSpan(ColorTemplate.getHoloBlue()), s.length() - 15, s.length(), 0);
        return s;
    }

    private void setData4(int count, float range) {
        String[] mParties = new String[]{Des1, Des2, Des3, Des4};
        float mult = range;
        ArrayList<PieEntry> yEntrys = new ArrayList<>();
        double tong4 = amount1 + amount2 + amount3 + amount4;
        double[] yData4 = {amount1, amount2, amount3, amount4};
        for (int i = 0; i < count; i++) {
            yEntrys.add(new PieEntry((float) (yData4[i] / tong4) * 100,
                    mParties[i]));//i % mParties.length
        }
        PieDataSet dataSet = new PieDataSet(yEntrys, null);
        dataSet.setSliceSpace(3f);//kho???ng c??ch gi???a c??c ph??n ??o???n
        ArrayList<Integer> colors = new ArrayList<Integer>();
        colors.add(Color.BLUE);
        colors.add(Color.GREEN);
        colors.add(Color.MAGENTA);
        colors.add(Color.YELLOW);
        colors.add(ColorTemplate.getHoloBlue());
        dataSet.setColors(colors);
        dataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        data4 = new PieData(dataSet);
        data4.setValueFormatter(new PercentFormatter());//th??m s??? ph???n tr??m
        data4.setValueTextSize(13f); //k??ch th?????c s??? li???u
        pieChartpie.invalidate();
        Legend l = pieChartpie.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);
        l.setEnabled(true);
        l.setTextSize(16);
    }
}