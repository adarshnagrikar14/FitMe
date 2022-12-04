package com.rcoem.mongolearnings;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

@SuppressLint("CustomSplashScreen")
public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        new Handler(Looper.getMainLooper()).postDelayed(() -> {

            if (user != null) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            } else {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }
            SplashScreenActivity.this.finish();
        }, 2000);

    }
}