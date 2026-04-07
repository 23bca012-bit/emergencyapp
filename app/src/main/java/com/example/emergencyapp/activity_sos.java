package com.example.emergencyapp;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class activity_sos extends AppCompatActivity {

    TextView sosText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sos);

        sosText = findViewById(R.id.sosText);
        sosText.setText("Calling Emergency Contact...");
    }
}
