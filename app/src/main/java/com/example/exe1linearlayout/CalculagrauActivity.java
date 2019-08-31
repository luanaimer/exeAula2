package com.example.exe1linearlayout;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;

public class CalculagrauActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculagrau);

        Button btnConverter = findViewById(R.id.bntConverter);

        btnConverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                double vlrCelsius = 0;
                double vlrFahrenheit = 0;

                EditText edCelsius = findViewById(R.id.edCelsius);
                EditText edFahrenheit = findViewById(R.id.edFahrenheit);

                if (!(edCelsius.getText().toString().isEmpty())){
                    vlrCelsius = Double.parseDouble(edCelsius.getText().toString());
                }
                if (!(edFahrenheit.getText().toString().isEmpty())){
                    vlrFahrenheit = Double.parseDouble(edFahrenheit.getText().toString());
                }

                if (!edCelsius.getText().toString().isEmpty()){
                    vlrFahrenheit = (vlrCelsius * (9/5)) + 32;
                    edFahrenheit.setText(Double.toString(vlrFahrenheit));
                }
                else if (!edFahrenheit.getText().toString().isEmpty()){
                    vlrCelsius = (vlrFahrenheit - 32) * (0.55);
                    edCelsius.setText(Double.toString(vlrCelsius));
                }


            }
        });
    }
}
