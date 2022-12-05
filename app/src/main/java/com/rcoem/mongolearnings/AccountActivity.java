package com.rcoem.mongolearnings;

import static java.lang.String.format;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class AccountActivity extends AppCompatActivity {

    EditText name, height, weight;
    RadioGroup radioGroup;
    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        name = findViewById(R.id.name);
        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);

        radioGroup = findViewById(R.id.radioVN);

        radioGroup.setOnCheckedChangeListener((radioGroup, i) -> {

            int selectedId = radioGroup.getCheckedRadioButtonId();
            radioButton = (RadioButton) findViewById(selectedId);

        });

    }

    public void uploadData(View view) {

        String sName = name.getText().toString();

        String wt = weight.getText().toString();
        String ht = height.getText().toString();

        if (!sName.isEmpty() && !wt.isEmpty() && !ht.isEmpty() && radioButton.getTag() != null) {



        } else {
            Toast.makeText(this, "Enter all details", Toast.LENGTH_SHORT).show();
        }

    }
}