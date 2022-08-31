package com.rcoem.mongolearnings;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class GraphActivity extends AppCompatActivity {

    EditText one, two, three, four, five, six, seven, eight, nine, ten, eleven, twelve, height;
    String one1, two2, three3, four4, five5, six6, seven7, eight8, nine9, ten10, eleven11, twelve12, heightM;

    SharedPreferences sharedPreferences;

    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);

        editor = sharedPreferences.edit();

        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        ten = findViewById(R.id.ten);
        eleven = findViewById(R.id.eleven);
        twelve = findViewById(R.id.twelve);

        height = findViewById(R.id.height);

        one.setText(sharedPreferences.getString("number0", ""));
        two.setText(sharedPreferences.getString("number1", ""));
        three.setText(sharedPreferences.getString("number2", ""));
        four.setText(sharedPreferences.getString("number3", ""));
        five.setText(sharedPreferences.getString("number4", ""));
        six.setText(sharedPreferences.getString("number5", ""));
        seven.setText(sharedPreferences.getString("number6", ""));
        eight.setText(sharedPreferences.getString("number7", ""));
        nine.setText(sharedPreferences.getString("number8", ""));
        ten.setText(sharedPreferences.getString("number9", ""));
        eleven.setText(sharedPreferences.getString("number10", ""));
        twelve.setText(sharedPreferences.getString("number11", ""));

        height.setText(sharedPreferences.getString("height", ""));

        one.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                editVal(0, charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        two.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                editVal(1, charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        three.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                editVal(2, charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        four.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                editVal(3, charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        five.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                editVal(4, charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        six.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                editVal(5, charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        seven.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                editVal(6, charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        eight.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                editVal(7, charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        nine.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                editVal(8, charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        ten.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                editVal(9, charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        eleven.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                editVal(10, charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        twelve.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                editVal(11, charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    private void editVal(int i, String toString) {
        editor.putString("number" + i, toString);
        editor.apply();
    }


    public void calcBMIAll(View view) {

        one1 = one.getText().toString();
        two2 = two.getText().toString();
        three3 = three.getText().toString();
        four4 = four.getText().toString();
        five5 = five.getText().toString();
        six6 = six.getText().toString();
        seven7 = seven.getText().toString();
        eight8 = eight.getText().toString();
        nine9 = nine.getText().toString();
        ten10 = ten.getText().toString();
        eleven11 = eleven.getText().toString();
        twelve12 = twelve.getText().toString();

        heightM = height.getText().toString();

        if (!one1.isEmpty() && !two2.isEmpty() && !three3.isEmpty() && !four4.isEmpty()
                && !five5.isEmpty() && !six6.isEmpty() && !seven7.isEmpty() && !eight8.isEmpty() &&
                !nine9.isEmpty() && !ten10.isEmpty() && !eleven11.isEmpty() && !twelve12.isEmpty() && !heightM.isEmpty()) {

            ArrayList<Float> weightS = new ArrayList<>();
            weightS.add(Float.parseFloat(one1));
            weightS.add(Float.parseFloat(two2));
            weightS.add(Float.parseFloat(three3));
            weightS.add(Float.parseFloat(four4));
            weightS.add(Float.parseFloat(five5));
            weightS.add(Float.parseFloat(six6));
            weightS.add(Float.parseFloat(seven7));
            weightS.add(Float.parseFloat(eight8));
            weightS.add(Float.parseFloat(nine9));
            weightS.add(Float.parseFloat(ten10));
            weightS.add(Float.parseFloat(eleven11));
            weightS.add(Float.parseFloat(twelve12));

            float ht = Float.parseFloat(heightM);

            editor.putString("height", String.valueOf(ht));
            editor.apply();

            float ht2 = ht * ht;

            String BMI = "January: " + weightS.get(0) / ht2
                    + "\nFebruary: " + weightS.get(1) / ht2
                    + "\nMarch: " + weightS.get(2) / ht2
                    + "\nApril: " + weightS.get(3) / ht2
                    + "\nMay: " + weightS.get(4) / ht2
                    + "\nJune: " + weightS.get(5) / ht2
                    + "\nJuly: " + weightS.get(6) / ht2
                    + "\nAugust: " + weightS.get(7) / ht2
                    + "\nSeptember: " + weightS.get(8) / ht2
                    + "\nOctober: " + weightS.get(9) / ht2
                    + "\nNovember: " + weightS.get(10) / ht2
                    + "\nDecember: " + weightS.get(11) / ht2;

            Intent intent = new Intent(this, GraphShow.class);
            intent.putExtra("AllBMI", BMI);
            Log.d("TAG", "calcBMIAll: " + weightS);
            intent.putExtra("AllWeight", weightS);
            intent.putExtra("height", ht2);
            startActivity(intent);

        } else {
            Toast.makeText(this, "Enter all details", Toast.LENGTH_SHORT).show();
        }

    }

    public void clearWeight(View view) {

        for (int i = 0; i < 12; i++) {

            editor.putString("number" + i, "");
            editor.apply();

        }

        startActivity(new Intent(this, GraphActivity.class));
        finish();

    }
}