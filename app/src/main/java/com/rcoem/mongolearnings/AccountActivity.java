package com.rcoem.mongolearnings;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class AccountActivity extends AppCompatActivity {

    EditText name, height, weight;
    RadioGroup radioGroup1, radioGroup2;
    RadioButton radioButton, radioButton2;
    DocumentReference myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        name = findViewById(R.id.name);
        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);

        radioGroup1 = findViewById(R.id.radioVN);
        radioGroup2 = findViewById(R.id.radioMF);

        radioGroup1.setOnCheckedChangeListener((radioGroup, i) -> {

            int selectedId = radioGroup.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId);

        });

        radioGroup2.setOnCheckedChangeListener((radioGroup, i) -> {
            int selectedId2 = radioGroup.getCheckedRadioButtonId();
            radioButton2 = findViewById(selectedId2);
        });

        myDB = FirebaseFirestore.getInstance().collection("FitMeUserData")
                .document(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid());

        myDB.get().addOnSuccessListener(documentSnapshot -> {

            if (documentSnapshot.exists()) {

                String mName = documentSnapshot.getString("Name");
                name.setText(mName);

                String mHeight = documentSnapshot.getString("Height");
                height.setText(mHeight);

                String mWeight = documentSnapshot.getString("Weight");
                weight.setText(mWeight);

                // Gender radio btn
                String mGender = documentSnapshot.getString("Gender");
                assert mGender != null;
                int mG = Integer.parseInt(mGender);
                if (mG == 1) {
                    radioButton = findViewById(R.id.male);
                } else {
                    radioButton = findViewById(R.id.female);
                }
                radioButton.setChecked(true);

                // Diet radio btn
                String mDiet = documentSnapshot.getString("Diet");
                assert mDiet != null;
                int mD = Integer.parseInt(mDiet);
                if (mD == 1) {
                    radioButton2 = findViewById(R.id.veg);
                } else {
                    radioButton2 = findViewById(R.id.nonVeg);
                }
                radioButton2.setChecked(true);

            }

        });

    }

    public void uploadData(View view) {

        String sName = name.getText().toString();

        String wt = weight.getText().toString();
        String ht = height.getText().toString();

        if (!sName.isEmpty() && !wt.isEmpty() && !ht.isEmpty() && radioButton.getTag() != null && radioButton2.getTag() != null) {

            ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("Adding data...");
            progressDialog.setMessage("Please wait");
            progressDialog.show();

            int gTag = Integer.parseInt(String.valueOf(radioButton2.getTag()));
            int dTag = Integer.parseInt(String.valueOf(radioButton.getTag()));

            Map<String, String> data = new HashMap<>();
            data.put("Name", sName);
            data.put("Height", ht);
            data.put("Weight", wt);
            data.put("Gender", String.valueOf(gTag));
            data.put("Diet", String.valueOf(dTag));

            myDB.set(data).addOnSuccessListener(unused -> {
                progressDialog.dismiss();
                Toast.makeText(this, "Data added successfully", Toast.LENGTH_SHORT).show();
                performExit();
            }).addOnFailureListener(e -> {
                progressDialog.dismiss();
                Toast.makeText(this, "Error occurred!", Toast.LENGTH_SHORT).show();
            });

        } else {
            Toast.makeText(this, "Enter all details", Toast.LENGTH_SHORT).show();
        }

    }

    private void performExit() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}