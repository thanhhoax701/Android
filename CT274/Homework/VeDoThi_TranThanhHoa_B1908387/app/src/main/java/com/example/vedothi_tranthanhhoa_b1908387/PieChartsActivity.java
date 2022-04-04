package com.example.vedothi_tranthanhhoa_b1908387;

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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vedothi_tranthanhhoa_b1908387.PieCharts.pieChart2;
import com.example.vedothi_tranthanhhoa_b1908387.PieCharts.pieChart3;
import com.example.vedothi_tranthanhhoa_b1908387.PieCharts.pieChart4;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.MPPointF;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class PieChartsActivity extends AppCompatActivity {
    EditText edtDes1, edtDes2, edtDes3, edtDes4, edtDes5, edtDes6, edtDes7, edtDes8, edtDes9;
    EditText edttitle;
    EditText edtso1, edtso2, edtso3, edtso4, edtso5, edtso6, edtso7, edtso8, edtso9;
    TextView tv1, tv2, tv3, tv4, tv5, tv6, tv7, tv8, tv9;
    TextView tvDes;
    TextView tvAmount, tvtlaytitle;
    TextView tvpt, tvTotal, tvTotalPt;
    int vitri;
    String Des1, Des2, Des3, Des4, Des5, Des6, Des7, Des8, Des9;
    double amount1, amount2, amount3, amount4, amount5, amount6, amount7, amount8, amount9;
    double tong3, tong3pt, totalAmount;
    TableLayout tableLayout;
    LinearLayout linearLayout1, linearLayout2;
    TableRow tableRow1, tableRow2, tableRow3, tableRow4, tableRow5, tableRow6, tableRow7, tableRow8, tableRow9;
    LinearLayout linearLayout;
    PieChart pieChartMp;
    BarChart mChart;
    BarData databar2, databar3, databar4, databar5, databar6, databar7, databar8, databar9;
    Spinner spinner;
    int id;
    Button btnVeMp, btnPieChart, btnthoat, btnLineChart, btnbarChart, btnVeBar, btnFxChart, btnthoatbarChart;
    PieData data, data3, data4, data5, data6, data2, data7, data8, data9;
    Button btnsave, btnsavebar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_charts);

        pieChartMp = (PieChart) findViewById(R.id.PieChartMp);
        pieChartMp.setVisibility(View.INVISIBLE);
        btnsave = (Button) findViewById(R.id.btnluu);
        edttitle = (EditText) findViewById(R.id.edtTitle);
        tvTotal = (TextView) findViewById(R.id.tvTotal1);
        tvTotalPt = (TextView) findViewById(R.id.tvTotal2);

        edtso1 = (EditText) findViewById(R.id.edtAmount1);
        edtso2 = (EditText) findViewById(R.id.edtAmount2);
        edtso3 = (EditText) findViewById(R.id.edtAmount3);
        edtso4 = (EditText) findViewById(R.id.edtAmount4);
//        edtso5 = (EditText) findViewById(R.id.edtAmount5);
//        edtso6 = (EditText) findViewById(R.id.edtAmount6);
//        edtso7 = (EditText) findViewById(R.id.edtAmount7);
//        edtso8 = (EditText) findViewById(R.id.edtAmount8);
//        edtso9 = (EditText) findViewById(R.id.edtAmount9);

        edtDes1 = (EditText) findViewById(R.id.edtDescription1);
        edtDes2 = (EditText) findViewById(R.id.edtDescription2);
        edtDes3 = (EditText) findViewById(R.id.edtDescription3);
        edtDes4 = (EditText) findViewById(R.id.edtDescription4);
//        edtDes5 = (EditText) findViewById(R.id.edtDescription5);
//        edtDes6 = (EditText) findViewById(R.id.edtDescription6);
//        edtDes7 = (EditText) findViewById(R.id.edtDescription7);
//        edtDes8 = (EditText) findViewById(R.id.edtDescription8);
//        edtDes9 = (EditText) findViewById(R.id.edtDescription9);

        tv1 = (TextView) findViewById(R.id.tvphantram1);
        tv2 = (TextView) findViewById(R.id.tvphantram2);
        tv3 = (TextView) findViewById(R.id.tvphantram3);
        tv4 = (TextView) findViewById(R.id.tvphantram4);
//        tv5 = (TextView) findViewById(R.id.tvphantram5);
//        tv6 = (TextView) findViewById(R.id.tvphantram6);
//        tv7 = (TextView) findViewById(R.id.tvphantram7);
//        tv8 = (TextView) findViewById(R.id.tvphantram8);
//        tv9 = (TextView) findViewById(R.id.tvphantram9);

        tvtlaytitle = (TextView) findViewById(R.id.laytitle);

        tableRow1 = (TableRow) findViewById(R.id.tableRow1);
        tableRow2 = (TableRow) findViewById(R.id.tableRow2);
        tableRow3 = (TableRow) findViewById(R.id.tableRow3);
        tableRow4 = (TableRow) findViewById(R.id.tableRow4);
//        tableRow5 = (TableRow) findViewById(R.id.tableRow5);
//        tableRow6 = (TableRow) findViewById(R.id.tableRow6);
//        tableRow7 = (TableRow) findViewById(R.id.tableRow7);
//        tableRow8 = (TableRow) findViewById(R.id.tableRow8);
//        tableRow9 = (TableRow) findViewById(R.id.tableRow9);

        tableLayout = (TableLayout) findViewById(R.id.tableLayout);
        btnVeMp = (Button) findViewById(R.id.btnVePieCharts);
        btnthoat = (Button) findViewById(R.id.btnthoatPieCharts);
        btnsave = (Button) findViewById(R.id.btnluu);
        btnthoat.setVisibility(View.INVISIBLE);
        btnsave.setVisibility(View.INVISIBLE);
        //tableLayout.setVisibility(View.INVISIBLE);

        //tạo biểu tròn
        //tạo spinner
        spinner = (Spinner) findViewById(R.id.spinnerMp);
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(0);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
//        arrayList.add(5);
//        arrayList.add(6);
//        arrayList.add(7);
//        arrayList.add(8);
//        arrayList.add(9);
        //Đưa spinner vào ArrayAdapter
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, arrayList);

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new MpAndroidChart());

        //vẽ đồ thị (pieChartMp là thể hiện của giao diện đồ thị PieChartMP)
        pieChartMp.setUsePercentValues(true);
        //pieChartMp.getDescription().setEnabled(false);
        pieChartMp.setExtraOffsets(5, 10, 5, 5);
        pieChartMp.setDragDecelerationFrictionCoef(0.95f);
        pieChartMp.setCenterText(generateCenterSpannableText());
        pieChartMp.setExtraOffsets(20.f, 0.f, 20.f, 0.f);
        //tạo đường tròn ở trong
        pieChartMp.setDrawHoleEnabled(true);
        pieChartMp.setHoleColor(Color.WHITE);
        //tạo đường viền bên trong hình tròn
        pieChartMp.setTransparentCircleColor(Color.WHITE);
        pieChartMp.setTransparentCircleAlpha(110);
        pieChartMp.setCenterTextColor(Color.BLACK);
        //
        pieChartMp.setHoleRadius(52f);//58
        pieChartMp.setTransparentCircleRadius(55f);//61
        pieChartMp.setDrawCenterText(true);
        pieChartMp.setRotationAngle(0);
        // enable rotation of the chart by touch
        pieChartMp.setRotationEnabled(true);
        pieChartMp.setHighlightPerTapEnabled(true);

        btnVeMp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnthoat.setVisibility(View.VISIBLE);
                btnsave.setVisibility(View.VISIBLE);
                //tableLayout.setVisibility(View.VISIBLE);
                tvtlaytitle.setVisibility(View.INVISIBLE);
                switch (vitri) {
                    case 2:
                        Des1 = edtDes1.getText().toString();
                        Des2 = edtDes2.getText().toString();
                        //lấy title
                        String lay2 = edttitle.getText().toString();
                        tvtlaytitle.setText("Đồ thị:" + lay2);
                        //lấy dữ liệu
                        amount1 = Double.parseDouble(edtso1.getText().toString());
                        amount2 = Double.parseDouble(edtso2.getText().toString());
                        //tính số phần trăm từng phần
                        DecimalFormat df = new DecimalFormat("0.0");// làm tròn với 3 chữ sốthập phân, muốn bao nhiêu chữ số sau dấu phẩy //thì thêm bấy nhiêu số 0.
                        double tong3pt2 = amount1 + amount2;
                        double in12 = ((amount1 / tong3pt2) * 100);
                        double in22 = ((amount2 / tong3pt2) * 100);
                        String edtphantram12 = df.format(in12);
                        String edtphantram22 = df.format(in22);
                        tv1.setText(edtphantram12);
                        tv2.setText(edtphantram22);
                        //tổng số liệu nhập vào
                        double tong = amount1 + amount2;
                        String togAmount = Double.toString(tong);
                        tvTotal.setText(togAmount);
                        //tổng số phần trăm
                        double tong2 = in12 + in22;
                        String tongpt = df.format(tong2);
                        tvTotalPt.setText(tongpt);
                        //tạo setData
                        setData2(2, 100);
                        pieChartMp.setData(data2);
                        pieChartMp.setVisibility(View.INVISIBLE);
                        //intent
                        Intent intent2 = new Intent(PieChartsActivity.this, pieChart2.class);
                        intent2.putExtra("segment2", amount2);
                        intent2.putExtra("segment1", amount1);
                        intent2.putExtra("tendothi", lay2);
                        intent2.putExtra("Des1", Des1);
                        intent2.putExtra("Des2", Des2);
                        startActivity(intent2);
                        break;
                    case 3:
                        Des1 = edtDes1.getText().toString();
                        Des2 = edtDes2.getText().toString();
                        Des3 = edtDes3.getText().toString();
                        //lấy title
                        String lay3 = edttitle.getText().toString();
                        tvtlaytitle.setText("Đồ thị:" + lay3);
                        //lấy dữ liệu
                        amount1 = Double.parseDouble(edtso1.getText().toString());
                        amount2 = Double.parseDouble(edtso2.getText().toString());
                        amount3 = Double.parseDouble(edtso3.getText().toString());
                        //tính số phần trăm từng phần
//                        DecimalFormat df3 = new DecimalFormat("0.0");// làm tròn với 3 chữ số thập phân, muốn bao nhiêu chữ số sau dấu phẩy //thì thêm bấy nhiêu số 0.
//                        tong3pt = amount1 + amount2 + amount3;
//                        double in13 = ((amount1 / tong3pt) * 100);
//                        double in23 = ((amount2 / tong3pt) * 100);
//                        double in33 = ((amount3 / tong3pt) * 100);
//                        String edtphantram13 = df3.format(in13);
//                        String edtphantram23 = df3.format(in23);
//                        String edtphantram33 = df3.format(in33);
//                        tv1.setText(edtphantram13);
//                        tv2.setText(edtphantram23);
//                        tv3.setText(edtphantram33);
//                        //tổng số liệu nhập vào
//                        double tong3 = amount1 + amount2 + amount3;
//                        String togAmount3 = Double.toString(tong3);
//                        tvTotal.setText(togAmount3);
//                        //tổng số phần trăm
//                        double tong23 = in13 + in23 + in33;
//                        String tongpt3 = df3.format(tong23);
//                        tvTotalPt.setText(tongpt3);
                        DecimalFormat df33 = new DecimalFormat("0.0");
                        double tong3pt3 = amount1 + amount2 + amount3;
                        double in133 = ((amount1 / tong3pt3) * 100);
                        double in233 = ((amount2 / tong3pt3) * 100);
                        double in333 = ((amount3 / tong3pt3) * 100);
                        String edtphantram133 = df33.format(in133);
                        String edtphantram233 = df33.format(in233);
                        String edtphantram333 = df33.format(in333);
                        tv1.setText(edtphantram133);
                        tv2.setText(edtphantram233);
                        tv3.setText(edtphantram333);
                        //tổng số liệu nhập vào
                        double tong33 = amount1 + amount2 + amount3;
                        String togAmount33 = df33.format(tong33);
                        tvTotal.setText(togAmount33);
                        //tổng số phần trăm
                        double tong233 = in133 + in233 + in333;
                        String tongpt33 = df33.format(tong233);
                        tvTotalPt.setText(tongpt33);
                        //tạo setData
                        setData3(3, 100);
                        pieChartMp.setData(data3);
                        pieChartMp.setVisibility(View.INVISIBLE);
                        Intent intent3 = new Intent(PieChartsActivity.this, pieChart3.class);
                        //Bundle bundle2=new Bundle();
                        intent3.putExtra("segment2", amount2);
                        intent3.putExtra("segment1", amount1);
                        intent3.putExtra("segment3", amount3);
                        intent3.putExtra("tendothi", lay3);
                        intent3.putExtra("Des1", Des1);
                        intent3.putExtra("Des2", Des2);
                        intent3.putExtra("Des3", Des3);
                        startActivity(intent3);
                        break;
                    case 4:
                        //lấy title
                        String lay4 = edttitle.getText().toString();
                        tvtlaytitle.setText("Đồ thị:" + lay4);
                        //lấy dữ liệu
                        amount1 = Double.parseDouble(edtso1.getText().toString());
                        amount2 = Double.parseDouble(edtso2.getText().toString());
                        amount3 = Double.parseDouble(edtso3.getText().toString());
                        amount4 = Double.parseDouble(edtso4.getText().toString());
                        //tính số phần trăm từng phần
                        DecimalFormat df34 = new DecimalFormat("0.0");// làm tròn với 3 chữ số thập phân, muốn bao nhiêu chữ số sau dấu phẩy //thì thêm bấy nhiêu số 0.
                        double tong3pt4 = amount1 + amount2 + amount3 + amount4;
                        double in134 = ((amount1 / tong3pt4) * 100);
                        double in234 = ((amount2 / tong3pt4) * 100);
                        double in334 = ((amount3 / tong3pt4) * 100);
                        double in444 = ((amount4 / tong3pt4) * 100);
                        String edtphantram134 = df34.format(in134);
                        String edtphantram234 = df34.format(in234);
                        String edtphantram334 = df34.format(in334);
                        String edtphantram444 = df34.format(in444);
                        tv1.setText(edtphantram134);
                        tv2.setText(edtphantram234);
                        tv3.setText(edtphantram334);
                        tv4.setText(edtphantram444);
                        //tổng số liệu nhập vào
                        double tong34 = amount1 + amount2 + amount3 + amount4;
                        String togAmount34 = df34.format(tong34);
                        tvTotal.setText(togAmount34);
                        //tổng số phần trăm
                        double tong234 = in134 + in234 + in334 + in444;
                        String tongpt34 = df34.format(tong234);
                        tvTotalPt.setText(tongpt34);
                        //tạo setData
                        setData4(4, 100);
                        pieChartMp.setData(data4);
                        pieChartMp.setVisibility(View.INVISIBLE);
                        Intent intent4 = new Intent(PieChartsActivity.this, pieChart4.class);
                        //Bundle bundle2=new Bundle();
                        intent4.putExtra("segment2", amount2);
                        intent4.putExtra("segment1", amount1);
                        intent4.putExtra("segment3", amount3);
                        intent4.putExtra("segment4", amount4);
                        intent4.putExtra("tendothi", lay4);
                        intent4.putExtra("Des1", Des1);
                        intent4.putExtra("Des2", Des2);
                        intent4.putExtra("Des3", Des3);
                        intent4.putExtra("Des4", Des4);
                        startActivity(intent4);
                        break;
                }

            }
        });

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pieChartMp.saveToPath("Hinh Pie2", "");
                Toast.makeText(PieChartsActivity.this, "Lưu hình ảnh pie thành công", Toast.LENGTH_LONG).show();
            }
        });

        Legend l = pieChartMp.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setTextSize(12);
        l.setDrawInside(false);
        l.setEnabled(true);

        // Xử lỳ nut Thoát
        btnthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
    }

    //Các class và method ngoài onCreate
    private void setData2(int count, float range) {
        //Des3=edtDes3.getText().toString();
        String[] mParties = new String[]{Des1, Des2};
        float mult = range;
        ArrayList<PieEntry> yEntrys = new ArrayList<>();
        // ArrayList<PieEntry> entries = new ArrayList<PieEntry>();
        // NOTE: The order of the entries when being added to the entries array determinestheir position around the center of
        // the chart.
        double tong2 = amount1 + amount2;
        double[] yData2 = {amount1, amount2};
        for (int i = 0; i < count; i++) {
            yEntrys.add(new PieEntry((float) (yData2[i] / tong2) * 100,
                    mParties[i % mParties.length]));
        }
        PieDataSet dataSet = new PieDataSet(yEntrys, null);
        dataSet.setSliceSpace(3f);
        //dataSet.setIconsOffset(new MPPointF(0, 40)); xem lại
        dataSet.setSelectionShift(5f);
        dataSet.setValueTextColor(Color.BLACK);
        // add a lot of colors
        ArrayList<Integer> colors = new ArrayList<Integer>();
        colors.add(Color.BLUE);
        colors.add(Color.GREEN);
        colors.add(Color.MAGENTA);
        colors.add(Color.YELLOW);
        colors.add(ColorTemplate.getHoloBlue());
        dataSet.setColors(colors);
        dataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        data2 = new PieData(dataSet);
        data2.setValueFormatter(new PercentFormatter());
        data2.setValueTextSize(12f);
        data2.setValueTextColor(Color.BLACK);
        // undo all highlights
        pieChartMp.invalidate();
        Legend l = pieChartMp.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);
        l.setEnabled(true);
    }

    private void setData3(int count, float range) {
        Des1 = edtDes1.getText().toString();
        Des2 = edtDes2.getText().toString();
        Des3 = edtDes3.getText().toString();
        String[] mParties = new String[]{Des1, Des2, Des3};
        float mult = range;
        ArrayList<PieEntry> yEntrys = new ArrayList<>();
        tong3 = amount1 + amount2 + amount3;
        double[] yData3 = {amount1, amount2, amount3};
        for (int i = 0; i < count; i++) {
            // yEntrys.add(new PieEntry((float)()
            yEntrys.add(new PieEntry((float) (yData3[i] / tong3) * 100,
                    mParties[i % mParties.length]));
        }
        PieDataSet dataSet = new PieDataSet(yEntrys, null);
        dataSet.setSliceSpace(3f);
        dataSet.setIconsOffset(new MPPointF(0, 40));
        dataSet.setSelectionShift(5f);
        dataSet.setValueLineColor(Color.BLACK);
        // add a lot of colors
        ArrayList<Integer> colors = new ArrayList<Integer>();
        colors.add(Color.BLUE);
        colors.add(Color.GREEN);
        colors.add(Color.MAGENTA);
        colors.add(Color.YELLOW);
        colors.add(ColorTemplate.getHoloBlue());
//
        dataSet.setColors(colors);
//
        dataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        data3 = new PieData(dataSet);
        data3.setValueFormatter(new PercentFormatter());
        data3.setValueTextSize(12f);
        data3.setValueTextColor(Color.BLACK);
        // undo all highlights
        pieChartMp.invalidate();
        Legend l = pieChartMp.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);
        l.setEnabled(true);
    }

    private void setData4(int count, float range) {
        Des1 = edtDes1.getText().toString();
        Des2 = edtDes2.getText().toString();
        Des3 = edtDes3.getText().toString();
        Des4 = edtDes4.getText().toString();
        String[] mParties = new String[]{Des1, Des2, Des3, Des4};
        float mult = range;
        ArrayList<PieEntry> yEntrys = new ArrayList<>();
        // NOTE: The order of the entries when being added to the entries array determinestheir position
        // around the center of the chart.
        double tong4 = amount1 + amount2 + amount3 + amount4;
        double[] yData4 = {amount1, amount2, amount3, amount4};
        for (int i = 0; i < count; i++) {
            yEntrys.add(new PieEntry((float) (yData4[i] / tong4) * 100,
                    mParties[i % mParties.length]));
        }
        PieDataSet dataSet = new PieDataSet(yEntrys, null);
        dataSet.setSliceSpace(3f);
        dataSet.setIconsOffset(new MPPointF(0, 40));
        dataSet.setSelectionShift(5f);
        // add a lot of colors
        ArrayList<Integer> colors = new ArrayList<Integer>();
        colors.add(Color.BLUE);
        colors.add(Color.GREEN);
        colors.add(Color.MAGENTA);
        colors.add(Color.YELLOW);
        colors.add(ColorTemplate.getHoloBlue());
        dataSet.setColors(colors);
        dataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        data4 = new PieData(dataSet);
        data4.setValueFormatter(new PercentFormatter());
        data4.setValueTextSize(12f);
        data4.setValueTextColor(Color.BLACK);
        // undo all highlights
        pieChartMp.invalidate();
        Legend l = pieChartMp.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);
        l.setEnabled(true);
    }

    private SpannableString generateCenterSpannableText() {
        SpannableString s = new SpannableString("PieChartAndroid");
        s.setSpan(new RelativeSizeSpan(1.5f), 0, 15, 0);
        s.setSpan(new StyleSpan(Typeface.ITALIC), s.length() - 15, s.length(), 0);
        s.setSpan(new ForegroundColorSpan(ColorTemplate.getHoloBlue()), s.length() - 15,
                s.length(), 0);
        return s;
    }

    //
    class MpAndroidChart implements
            AdapterView.OnItemSelectedListener {
        //Khi có chọn lựa thì vào hàm này
        public void onItemSelected(AdapterView<?> arg0,
                                   View arg1,
                                   int arg2,
                                   long arg3) {
            vitri = arg2;
            switch (arg2) {
                case 0:
                    pieChartMp.setVisibility(View.INVISIBLE);
                    tvTotal.setText("0");
                    tvTotalPt.setText("0");
                    tableRow1.setVisibility(View.INVISIBLE);
                    tableRow2.setVisibility(View.INVISIBLE);
                    tableRow3.setVisibility(View.INVISIBLE);
                    tableRow4.setVisibility(View.INVISIBLE);
//                    tableRow5.setVisibility(View.INVISIBLE);
//                    tableRow6.setVisibility(View.INVISIBLE);
//                    tableRow7.setVisibility(View.INVISIBLE);
//                    tableRow8.setVisibility(View.INVISIBLE);
//                    tableRow9.setVisibility(View.INVISIBLE);
                    Toast.makeText(PieChartsActivity.this, "Xin vui lòng chọn số phần tử từ 2 đến 4", Toast.LENGTH_LONG).show();
                    break;
                case 1:
                    pieChartMp.setVisibility(View.INVISIBLE);
                    tvTotal.setText("0");
                    tvTotalPt.setText("0");
                    Toast.makeText(PieChartsActivity.this, "Xin vui lòng chọn số phần tử từ 2 đến 4", Toast.LENGTH_LONG).show();
                    tableRow1.setVisibility(View.INVISIBLE);
                    tableRow2.setVisibility(View.INVISIBLE);
                    tableRow3.setVisibility(View.INVISIBLE);
                    tableRow4.setVisibility(View.INVISIBLE);
//                    tableRow5.setVisibility(View.INVISIBLE);
//                    tableRow6.setVisibility(View.INVISIBLE);
//                    tableRow7.setVisibility(View.INVISIBLE);
//                    tableRow8.setVisibility(View.INVISIBLE);
//                    tableRow9.setVisibility(View.INVISIBLE);
                    break;
                case 2:
                    tableRow1.setVisibility(View.VISIBLE);
                    tableRow2.setVisibility(View.VISIBLE);
                    tableRow3.setVisibility(View.INVISIBLE);
                    tableRow4.setVisibility(View.INVISIBLE);
//                    tableRow5.setVisibility(View.INVISIBLE);
//                    tableRow6.setVisibility(View.INVISIBLE);
//                    tableRow7.setVisibility(View.INVISIBLE);
//                    tableRow8.setVisibility(View.INVISIBLE);
//                    tableRow9.setVisibility(View.INVISIBLE);
                    break;
                case 3:
                    tableRow1.setVisibility(View.VISIBLE);
                    tableRow2.setVisibility(View.VISIBLE);
                    tableRow3.setVisibility(View.VISIBLE);
                    tableRow4.setVisibility(View.INVISIBLE);
                    tableRow5.setVisibility(View.INVISIBLE);
//                    tableRow6.setVisibility(View.INVISIBLE);
//                    tableRow7.setVisibility(View.INVISIBLE);
//                    tableRow8.setVisibility(View.INVISIBLE);
//                    tableRow9.setVisibility(View.INVISIBLE);
                    break;
                case 4:
                    tableRow1.setVisibility(View.VISIBLE);
                    tableRow2.setVisibility(View.VISIBLE);
                    tableRow3.setVisibility(View.VISIBLE);
                    tableRow4.setVisibility(View.VISIBLE);
//                    tableRow5.setVisibility(View.INVISIBLE);
//                    tableRow6.setVisibility(View.INVISIBLE);
//                    tableRow7.setVisibility(View.INVISIBLE);
//                    tableRow8.setVisibility(View.INVISIBLE);
//                    tableRow9.setVisibility(View.INVISIBLE);
                    break;
            }
        }

        //Nếu không chọn gì cả
        public void onNothingSelected(AdapterView<?> arg0) {
            //selection.setText("");
        }

    }
}