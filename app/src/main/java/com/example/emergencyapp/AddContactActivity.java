package com.example.emergencyapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class AddContactActivity extends AppCompatActivity {

    EditText phoneInput;
    Button saveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        phoneInput = findViewById(R.id.phoneInput);
        saveBtn = findViewById(R.id.saveBtn);

        saveBtn.setOnClickListener(v -> {
            String number = phoneInput.getText().toString();

            SharedPreferences prefs = getSharedPreferences("EmergencyApp", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("contact", number);
            editor.apply();

            finish();
        });
    }
}