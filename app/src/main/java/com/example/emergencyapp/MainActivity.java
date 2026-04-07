package com.example.emergencyapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView contactText;
    Button addContactBtn, sosBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactText = findViewById(R.id.contactText);
        addContactBtn = findViewById(R.id.addContactBtn);
        sosBtn = findViewById(R.id.sosBtn);

        SharedPreferences prefs = getSharedPreferences("EmergencyApp", MODE_PRIVATE);
        String number = prefs.getString("contact", "No Contact Saved");

        contactText.setText(number);

        addContactBtn.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, AddContactActivity.class));
        });

        sosBtn.setOnClickListener(v -> {
            if (!number.equals("No Contact Saved")) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + number));
                startActivity(intent);
            }
        });
    }
}