package com.example.parcialuno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class integrantes extends AppCompatActivity {
    FloatingActionButton btnRegresar;
    WebView html;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_integrantes);
        WebView html = findViewById(R.id.wvContenido);
        String texto;
        texto = "<html><body style=\"background-color: lightblue; >";
        texto+="<div style=\"border-radius: 25px; border-style:solid;background-color: lightblue; ";
        texto+="padding: 10px;border-width: 2px\">";
        texto+="<p align=\"justify\">";
        texto+="<br><br><strong>Integrantes:</strong><br>&nbsp - Milton Gerardo Aguilera Ramos, 328218<br>&nbsp - Josue Salvador Reyes Melgar, 229415<br>&nbsp - Pedro Alexander Perez Rosales, 323418<br>&nbsp - Willian Alexander Vasquez Hernandez, 273815</p>";
        texto +="</p></div></body></html>";
        html.loadData(texto,"text/html","utf-8");
        btnRegresar = findViewById(R.id.btnRegresar);
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent act = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(act);
            }
        });
    }
}