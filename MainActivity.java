package com.example.exemple_mataro;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnSuma;
    Button btnResta;
    Button btnMultiplicacio;
    Button btnDivisio;

    EditText editOperandoA;
    EditText editOperandoB;
    EditText editResultat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnSuma = findViewById(R.id.btnSuma);
        btnResta = findViewById(R.id.btnResta);
        btnMultiplicacio = findViewById(R.id.btnMultiplicacio);
        btnDivisio = findViewById(R.id.btnDivisio);

        editOperandoA = findViewById(R.id.editOperandoA);
        editOperandoB = findViewById(R.id.editOperandoB);
        editResultat = findViewById(R.id.editResultat);

        btnSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double a = Double.parseDouble(editOperandoA.getText().toString());
                double b = Double.parseDouble(editOperandoB.getText().toString());

                double resultat = a + b;

                editResultat.setText(String.valueOf(resultat));
            }
        });
        btnResta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double a = Double.parseDouble(editOperandoA.getText().toString());
                double b = Double.parseDouble(editOperandoB.getText().toString());

                double resultat = a - b;

                editResultat.setText(String.valueOf(resultat));
            }
        });
        View.OnClickListener listenerOperacions = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double a = Double.parseDouble(editOperandoA.getText().toString());
                double b = Double.parseDouble(editOperandoB.getText().toString());

                double resultat = 0;

                if(view == btnMultiplicacio) {
                    resultat = a * b;
                }
                else if(view == btnDivisio) {

                    if(b == 0) {
                        editResultat.setText("No es pot dividir per zero");
                    }
                    else {
                        resultat = a / b;
                        editResultat.setText(String.valueOf(resultat));
                    }
                }

                if(view == btnMultiplicacio) {
                    editResultat.setText(String.valueOf(resultat));
                }
            }
        };

        btnDivisio.setOnClickListener(listenerOperacions);
        btnMultiplicacio.setOnClickListener(listenerOperacions);
    }
}