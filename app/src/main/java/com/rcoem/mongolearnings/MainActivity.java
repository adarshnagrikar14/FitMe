package com.rcoem.mongolearnings;

import static java.lang.String.format;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Objects;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    EditText name, weight, height;
    String sName;
    float fWeight, fHeight;
    TextView BMI, mDiet;
    RadioGroup radioGroup;
    RadioButton radioButton;
    LinearLayout linearLayout1, linearLayout2;
    DocumentReference myDB;
    float fBMI;
    TextView mNm, mHt, mWt, mGd, mDT;
    int dpTag;

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
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

        linearLayout1 = findViewById(R.id.noData);
        linearLayout2 = findViewById(R.id.yesData);

        myDB = FirebaseFirestore.getInstance().collection("FitMeUserData").document(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid());

        mNm = findViewById(R.id.myName);
        mHt = findViewById(R.id.myHeight);
        mWt = findViewById(R.id.myWeight);
        mGd = findViewById(R.id.myGender);
        mDT = findViewById(R.id.myDiet);

        TextView mBMI = findViewById(R.id.myBMI);

        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Please wait");
        progressDialog.setMessage("Fetching data...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        myDB.get().addOnSuccessListener(documentSnapshot -> {

            if (documentSnapshot.exists()) {

                progressDialog.dismiss();
                linearLayout1.setVisibility(View.GONE);
                linearLayout2.setVisibility(View.VISIBLE);

                mNm.setText("Name: " + documentSnapshot.getString("Name"));
                mHt.setText("Height: " + documentSnapshot.getString("Height"));
                mWt.setText("Weight: " + documentSnapshot.getString("Weight"));

                if (Objects.requireNonNull(documentSnapshot.getString("Gender")).equals("1")) {
                    mGd.setText("Gender: Male");
                } else {
                    mGd.setText("Gender: Female");
                }

                if (Objects.requireNonNull(documentSnapshot.getString("Diet")).equals("1")) {
                    mDT.setText("Diet Preference: Veg");
                } else {
                    mDT.setText("Diet Preference: Non Veg");
                }

                dpTag = Integer.parseInt(Objects.requireNonNull(documentSnapshot.getString("Diet")));

                float mHeight = Float.parseFloat(Objects.requireNonNull(documentSnapshot.getString("Height")));
                float mWeight = Float.parseFloat(Objects.requireNonNull(documentSnapshot.getString("Weight")));

                fBMI = mWeight / (mHeight * mHeight);

                mBMI.setText("Your BMI: " + String.format("%.02f", fBMI));
            } else {
                linearLayout1.setVisibility(View.VISIBLE);
                linearLayout2.setVisibility(View.GONE);
                progressDialog.dismiss();
            }

        }).addOnFailureListener(e -> {
            Toast.makeText(this, "Error occurred!", Toast.LENGTH_SHORT).show();
            linearLayout1.setVisibility(View.VISIBLE);
            linearLayout2.setVisibility(View.GONE);
            progressDialog.dismiss();
        });

        radioGroup.setOnCheckedChangeListener((radioGroup, i) -> {

            int selectedId = radioGroup.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId);

        });

        CircleImageView imageView = findViewById(R.id.profileImage);
        FirebaseAuth mAuth = FirebaseAuth.getInstance();

        TextView mName = findViewById(R.id.nameTxt);
        mName.setText("Welcome,\n" + mAuth.getCurrentUser().getDisplayName());

        Glide.with(this).load(Objects.requireNonNull(mAuth.getCurrentUser()).getPhotoUrl()).centerCrop().into(imageView);

        findViewById(R.id.checkDiet).setOnClickListener(view -> {
            showDiet(fBMI, dpTag);
            Toast.makeText(this, "Opening Diet plan...", Toast.LENGTH_SHORT).show();
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

    public void openAccount(View view) {
        startActivity(new Intent(this, AccountActivity.class));
    }

    public void openMenu(View view) {

        PopupMenu popupMenu = new PopupMenu(MainActivity.this, view);

        popupMenu.getMenuInflater().inflate(R.menu.main, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(menuItem -> {

            // Toast.makeText(MainActivity.this, "You Clicked " + menuItem.getTitle(), Toast.LENGTH_SHORT).show();

            switch (menuItem.getTitle().toString()) {

                case "About":
                    startActivity(new Intent(this, AboutActivity.class));
                    break;
                case "Contact":
                    startGmail();
                    break;
                case "Feedback":
                    startFeedMail();
                    break;
                case "Logout":
                    logout();
                    break;

            }

            return true;
        });

        popupMenu.show();

    }

    private void logout() {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    private void startFeedMail() {

        // mailto:mohammadfaysalk3@gmail.com

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"mohammadfaysalk3@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "FeedBack for FitMe Application.");
        startActivity(Intent.createChooser(intent, "Choose app"));

    }

    private void startGmail() {
        startActivity(new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:mohammadfaysalk3@gmail.com")));
    }
}
