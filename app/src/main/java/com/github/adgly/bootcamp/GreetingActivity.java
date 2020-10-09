package com.github.adgly.bootcamp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GreetingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greeting);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        TextView textView = findViewById(R.id.greetingMessage);
        textView.setText(message);
    }

    public void goToWeather(@SuppressWarnings("unused") View view) {
        Intent intent = new Intent(this, WeatherActivity.class);
        startActivity(intent);
    }
}