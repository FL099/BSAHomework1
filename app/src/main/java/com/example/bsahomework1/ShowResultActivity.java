package com.example.bsahomework1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ShowResultActivity extends AppCompatActivity {

    public static final String KEY = "result";
    private TextView result2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_result);

        result2 = findViewById(R.id.result2);

        String result = getIntent().getStringExtra(KEY);
        result2.setText(result);

    }
}