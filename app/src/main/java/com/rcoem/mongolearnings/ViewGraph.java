package com.rcoem.mongolearnings;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;

public class ViewGraph extends AppCompatActivity {

    GraphView graphView, graphView2, graphView3, graphView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_graph);

        String allBMI = getIntent().getStringExtra("AllBMI");
        float ht2 = getIntent().getFloatExtra("height", 1.5F);
        ArrayList<Float> weightData = (ArrayList<Float>) getIntent().getSerializableExtra("AllWeight");

        ArrayList<Float> bmiData = new ArrayList<>();

        bmiData.add(weightData.get(0) / ht2);
        bmiData.add(weightData.get(1) / ht2);
        bmiData.add(weightData.get(2) / ht2);
        bmiData.add(weightData.get(3) / ht2);
        bmiData.add(weightData.get(4) / ht2);
        bmiData.add(weightData.get(5) / ht2);
        bmiData.add(weightData.get(6) / ht2);
        bmiData.add(weightData.get(7) / ht2);
        bmiData.add(weightData.get(8) / ht2);
        bmiData.add(weightData.get(9) / ht2);
        bmiData.add(weightData.get(10) / ht2);
        bmiData.add(weightData.get(11) / ht2);

        graphView = findViewById(R.id.idGraphView);
        graphView2 = findViewById(R.id.idGraphView2);
        graphView3 = findViewById(R.id.idGraphView3);
        graphView4 = findViewById(R.id.idGraphView4);

        graphView1(weightData.get(0), weightData.get(1), weightData.get(2), weightData.get(3), weightData.get(4), weightData.get(5));
        graphView2F(weightData.get(6), weightData.get(7), weightData.get(8), weightData.get(9), weightData.get(10), weightData.get(11));
        graphView3F(bmiData.get(0), bmiData.get(1), bmiData.get(2), bmiData.get(3), bmiData.get(4), bmiData.get(5));
        graphView4F(bmiData.get(6), bmiData.get(7), bmiData.get(8), bmiData.get(9), bmiData.get(10), bmiData.get(11));

    }

    private void graphView1(float w1, float w2, float w3, float w4, float w5, float w6) {

        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{
                new DataPoint(1, w1),
                new DataPoint(2, w2),
                new DataPoint(3, w3),
                new DataPoint(4, w4),
                new DataPoint(5, w5),
                new DataPoint(6, w6),
        });

        graphView.setTitle("Weight vs Months: (Jan to June)");
        graphView.setTitleColor(R.color.purple_200);
        graphView.setTitleTextSize(40);
        graphView.addSeries(series);

    }

    private void graphView2F(Float aFloat, Float aFloat1, Float aFloat2, Float aFloat3, Float aFloat4, Float aFloat5) {
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{
                new DataPoint(1, aFloat),
                new DataPoint(2, aFloat1),
                new DataPoint(3, aFloat2),
                new DataPoint(4, aFloat3),
                new DataPoint(5, aFloat4),
                new DataPoint(6, aFloat5),
        });

        graphView2.setTitle("Weight vs Months: (July to Dec)");
        graphView2.setTitleColor(R.color.purple_200);
        graphView2.setTitleTextSize(40);
        graphView2.addSeries(series);

    }

    private void graphView3F(Float aFloat, Float aFloat1, Float aFloat2, Float aFloat3, Float aFloat4, Float aFloat5) {
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{
                new DataPoint(1, aFloat),
                new DataPoint(2, aFloat1),
                new DataPoint(3, aFloat2),
                new DataPoint(4, aFloat3),
                new DataPoint(5, aFloat4),
                new DataPoint(6, aFloat5),
        });

        graphView3.setTitle("BMI vs Months: (Jan to June)");
        graphView3.setTitleColor(R.color.purple_200);
        graphView3.setTitleTextSize(40);
        graphView3.addSeries(series);
    }

    private void graphView4F(Float aFloat, Float aFloat1, Float aFloat2, Float aFloat3, Float aFloat4, Float aFloat5) {
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{
                new DataPoint(1, aFloat),
                new DataPoint(2, aFloat1),
                new DataPoint(3, aFloat2),
                new DataPoint(4, aFloat3),
                new DataPoint(5, aFloat4),
                new DataPoint(6, aFloat5),
        });

        graphView4.setTitle("BMI vs Months: (July to Dec)");
        graphView4.setTitleColor(R.color.purple_200);
        graphView4.setTitleTextSize(40);
        graphView4.addSeries(series);
    }


}