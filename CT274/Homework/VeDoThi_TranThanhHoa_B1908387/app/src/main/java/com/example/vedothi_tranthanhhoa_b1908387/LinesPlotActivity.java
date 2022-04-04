package com.example.vedothi_tranthanhhoa_b1908387;

import static java.lang.Float.parseFloat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.androidplot.xy.CatmullRomInterpolator;
import com.androidplot.xy.LineAndPointFormatter;
import com.androidplot.xy.SimpleXYSeries;
import com.androidplot.xy.XYGraphWidget;
import com.androidplot.xy.XYPlot;
import com.androidplot.xy.XYSeries;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Arrays;

public class LinesPlotActivity extends AppCompatActivity {
    private XYPlot plot;
    Float[] domainLabels;
    Float[] series1Numbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lines_plot);

        // Tạo một thể hiện đồ thị XYPlot:
        plot = (XYPlot) findViewById(R.id.plot);
        //Lấy về Bundle được gửi kèm Intent rồi lấy ra các ArrayList đã được gởi đến.
        Bundle receiveBundle = this.getIntent().getExtras();
        final ArrayList<String> numberx = receiveBundle.getStringArrayList("xLabels");
        final ArrayList<String> numbery = receiveBundle.getStringArrayList("yData");
        // Chuyển các ArrayList thành Array, 1 cặp mảng giá trị trên trục x và trục y
        final Float[] domainLabels = new Float[numberx.size()];
        for (int i = 0; i < numberx.size(); i++) {
            domainLabels[i] = parseFloat(numberx.get(i));
        }
        final Float[] series1Numbers = new Float[numbery.size()];
        for (int i = 0; i < numbery.size(); i++) {
            series1Numbers[i] = parseFloat(numbery.get(i));
        }
        // chuyển mảng series1Numbers vào danh sách số liệu XYSeries':
        // (Y_VALS_ONLY có nghĩa là dùng giá trị trên trục x (domainLabels) làm chỉ mục phần tử)
        XYSeries series1 = new SimpleXYSeries(Arrays.<Float>asList(series1Numbers),
                SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "Series1");
        // Tạo các định dạng dùng cho việc vẽ một chuỗi sử dụng LineAndPointRenderer
        // và cấu hình chúng từ tập tin xml xml:
        LineAndPointFormatter series1Format =
                new LineAndPointFormatter(this,
                        R.xml.line_point_formatter_with_labels);
        // Để cho đẹp, thêm sự làm mịn cho đồ thị đường
        // Xem tại URL: http://androidplot.com/smooth-curves-and-androidplot/
        series1Format.setInterpolationParams(
                new CatmullRomInterpolator.Params(10,
                        CatmullRomInterpolator.Type.Centripetal));
        // Thêm một series vào the xyplot:
        plot.addSeries(series1, series1Format);
        plot.getGraph().getLineLabelStyle(XYGraphWidget.Edge.BOTTOM).setFormat(new Format() {
            @Override
            public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
                int i = Math.round(((Number) obj).floatValue());
                return toAppendTo.append(domainLabels[i]);
            }

            @Override
            public Object parseObject(String source, ParsePosition pos) {
                return null;
            }
        });
    }
}