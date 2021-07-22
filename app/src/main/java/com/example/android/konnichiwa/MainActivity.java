package com.example.android.konnichiwa;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // LEARN AUDIO FOCUS FROM YOUTUBE AND IMPLEMENT IT IN THE APP

        Button myButton = findViewById(R.id.numberButton);
        myButton.setOnClickListener(view -> {
            // Toast.makeText(this, "Opening Numbers Activity", Toast.LENGTH_SHORT).show();
            Intent myIntent = new Intent(MainActivity.this, NumbersActivity.class);
            startActivity(myIntent);
        });
         myButton = findViewById(R.id.familyButton);
        myButton.setOnClickListener(view -> {
            // Toast.makeText(this, "Opening Family Activity", Toast.LENGTH_SHORT).show();
            Intent myIntent = new Intent(MainActivity.this, FamilyActivity.class);
            startActivity(myIntent);
        });
        myButton = findViewById(R.id.colorsButton);
        myButton.setOnClickListener(view -> {
            // Toast.makeText(this, "Opening Color Activity", Toast.LENGTH_SHORT).show();
            Intent myIntent = new Intent(MainActivity.this, ColorActivity.class);
            startActivity(myIntent);
        });
        myButton = findViewById(R.id.phrasesButton);
        myButton.setOnClickListener(view -> {
            // Toast.makeText(this, "Opening Phrases Activity", Toast.LENGTH_SHORT).show();
            Intent myIntent = new Intent(MainActivity.this, PhrasesActivity.class);
            startActivity(myIntent);
        });
    }
}