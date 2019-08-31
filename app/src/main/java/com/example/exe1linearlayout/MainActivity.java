package com.example.exe1linearlayout;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCalcGrau = findViewById(R.id.btnCalcGrau);
        Button btnCalcPot = findViewById(R.id.btnCalcPot);

        btnCalcGrau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent i = new Intent(MainActivity.this, CalculagrauActivity.class);
                startActivity(i);
            }
        });

        btnCalcPot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent i = new Intent(MainActivity.this, CalculapotenciaActivity.class);
                startActivity(i);
            }
        });

    }
}
