package com.example.exe1linearlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Switch;

public class CalculapotenciaActivity extends AppCompatActivity {

    private enum TenumTpCalc {POTENCIA, CORRENTE};
    private TenumTpCalc enumTpCalc;

    private EditText eValorUm;
    private EditText eValorDois;

    private TextView tpResultado;
    private TextView tValorDois;
    private TextView tResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculapotencia);
        enumTpCalc = TenumTpCalc.POTENCIA;

        eValorUm = findViewById(R.id.edValorUm);
        eValorDois = findViewById(R.id.edValorDois);

        tpResultado = findViewById(R.id.tTpResultado);
        tValorDois = findViewById(R.id.tValorDois);
        tResultado = findViewById(R.id.tResultado);
    }

    public void alteraCalculo(View view){
        Switch sCalcPotencia = findViewById(R.id.sCaculaPotencia);

        eValorUm.setText("");
        eValorDois.setText("");
        tResultado.setText("");

        if (sCalcPotencia.isChecked()){
            enumTpCalc = TenumTpCalc.POTENCIA;
            tValorDois.setText("Amperagem");
            tpResultado.setText("Potência: ");
        }
        else{
            enumTpCalc = TenumTpCalc.CORRENTE;
            tValorDois.setText("Potência");
            tpResultado.setText("Corrente: ");
        }
    }

    public void calcular(View view) {
        double amperagem = 0;
        double voltagem = 0;
        double potencia = 0;
        if (enumTpCalc == TenumTpCalc.POTENCIA) {
            amperagem = Double.parseDouble(eValorUm.getText().toString());
            voltagem = Double.parseDouble(eValorDois.getText().toString());
            potencia = voltagem * amperagem;
            tResultado.setText(Double.toString(potencia));
        } else {
            amperagem = Double.parseDouble(eValorUm.getText().toString());
            potencia = Double.parseDouble(eValorDois.getText().toString());
            voltagem = potencia / amperagem;
            tResultado.setText(Double.toString(voltagem));
        }

        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        if(imm.isActive())
            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);

    }

}
