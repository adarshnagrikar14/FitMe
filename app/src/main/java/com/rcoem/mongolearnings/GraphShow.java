package com.rcoem.mongolearnings;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class GraphShow extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph_show);

        textView = findViewById(R.id.bmiAll);

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

        textView.setText(allBMI);

        findViewById(R.id.openGraph).setOnClickListener(view -> {
            Intent intent = new Intent(this, ViewGraph.class);
            intent.putExtra("AllBMI", allBMI);
            // Log.d("TAG", "calcBMIAll: " + weightS);
            intent.putExtra("AllWeight", weightData);
            intent.putExtra("height", ht2);
            startActivity(intent);
        });

    }

}