package com.example.bsahomework1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getCanonicalName();
    private EditText val1Inp ;
    private EditText val2Inp;
    private Button btnCalc;
    private TextView result1;
    private Button btnNavigate;
    private SeekBar valBar;
    private TextView barResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(LOG_TAG, "App started");
        val1Inp =findViewById(R.id.value1);
        val2Inp =findViewById(R.id.value2);
        btnCalc = findViewById(R.id.btnCalc);
        result1 = findViewById(R.id.result1);
        btnNavigate = findViewById(R.id.navigate);
        valBar = findViewById(R.id.valBar);
        barResult = findViewById(R.id.barResult);


        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double res = editTextToDouble(val1Inp) - editTextToDouble(val2Inp);
                result1.setText((String.valueOf(res)));
            }

        });

        btnNavigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double res = editTextToDouble(val1Inp) - editTextToDouble(val2Inp);
                Intent i = new Intent(MainActivity.this, ShowResultActivity.class);
                i.putExtra(ShowResultActivity.KEY, String.valueOf(res));
                startActivity(i);
            }

        });

        valBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChgVal;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChgVal = progress;
                barResult.setText((String.valueOf(progressChgVal)));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                barResult.setText((String.valueOf(progressChgVal)));
            }
        });
    }

    private double editTextToDouble(EditText num){
        String tmp = num.getText().toString();
        if (!"".equals(tmp) ){
            return Double.parseDouble(tmp);
        }
        return 0;
    }
}