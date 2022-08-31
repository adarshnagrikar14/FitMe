package com.rcoem.mongolearnings;

import static java.lang.String.format;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText name, weight, height;
    String sName;
    float fWeight, fHeight;
    TextView BMI, mDiet;
    RadioGroup radioGroup;
    RadioButton radioButton;
    String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);

        BMI = findViewById(R.id.bmi);
        mDiet = findViewById(R.id.diet);

        radioGroup = findViewById(R.id.radioVN);

        radioGroup.setOnCheckedChangeListener((radioGroup, i) -> {

            int selectedId = radioGroup.getCheckedRadioButtonId();
            radioButton = (RadioButton) findViewById(selectedId);

        });

    }

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    public void checkBmi(View view) {

        sName = name.getText().toString();

        String wt = weight.getText().toString();
        String ht = height.getText().toString();

        if (!sName.isEmpty() && !wt.isEmpty() && !ht.isEmpty() && radioButton.getTag() != null) {

            fWeight = Float.parseFloat(wt);
            fHeight = Float.parseFloat(ht);

            float fBMI = fWeight / (fHeight * fHeight);

            int mTag = Integer.parseInt(String.valueOf(radioButton.getTag()));

            Toast.makeText(this, "Opening Diet Plan", Toast.LENGTH_SHORT).show();
            new Handler(Looper.getMainLooper()).postDelayed(() -> showDiet(fBMI, mTag), 3000);

            BMI.setText("Hey " + sName + ", your BMI is " + format("%.2f", fBMI));
        } else {
            Toast.makeText(this, "Enter all details", Toast.LENGTH_SHORT).show();
        }

    }

    private void showDiet(float fBMI, int mTag) {
        @SuppressLint("DefaultLocale") float mBMI = Float.parseFloat(format("%.2f", fBMI));

        Uri uri;

        if (mBMI >= 18.5 && mBMI <= 25.0) {
            if (mTag == 1) {
                uri = Uri.parse("https://drive.google.com/file/d/1L4ob9TZhi9qbsa16zQQyiYHmXm-d8c6v/view?usp=sharing");
            } else {
                uri = Uri.parse("https://drive.google.com/file/d/1T-ZB6C97zZx4_i3w8-XdcFrZVLGzfzO6/view?usp=sharing");
            }
        } else if (mBMI >= 25 && mBMI <= 29.9) {
            if (mTag == 1) {
                uri = Uri.parse("https://drive.google.com/file/d/1L5KC1drFqxtbJLy76lt8wGIqXKwcClAm/view?usp=sharing");
            } else {
                uri = Uri.parse("https://drive.google.com/file/d/1LSpr4VsBtpA4eHLtmmNGBZ8AAINl4YsU/view?usp=sharing");
            }
        } else if (mBMI >= 30) {
            if (mTag == 1) {
                uri = Uri.parse("https://drive.google.com/file/d/1L5KC1drFqxtbJLy76lt8wGIqXKwcClAm/view?usp=sharing");
            } else {
                uri = Uri.parse("https://drive.google.com/file/d/1LFh1GqrwVz5_0eB5yG9oSz3Iwofb5tGi/view?usp=sharing");
            }
        } else {
            if (mTag == 1) {
                uri = Uri.parse("https://drive.google.com/file/d/1LTZONaexoBsCR0Rd0axpMDXY_Hg5mfSa/view?usp=sharing");
            } else {
                uri = Uri.parse("https://drive.google.com/file/d/1LP7KYsgtHA-XER2o-sVDVuqIb5LlR1g1/view?usp=sharing");
            }
        }

        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);

    }

    public void openNew(View view) {
        startActivity(new Intent(this, GraphActivity.class));
    }
}
