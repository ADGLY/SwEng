package com.github.adgly.bootcamp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.github.adgly.bootcamp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @SuppressWarnings("unused")
    public void sayHello(View view) {
        Intent intent = new Intent(this, GreetingActivity.class);
        EditText mainName = findViewById(R.id.mainName);
        String message = "Have a nice day, " + mainName.getText().toString() + " !";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}