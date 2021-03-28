package com.example.parcialuno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

public class venta extends AppCompatActivity {
    TextView txtProducto, txtPrecio, txtDescripcion, txtCantidad, txtFinal;
    Button btnRegre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venta);

         txtProducto = findViewById(R.id.txvTitulo);
         txtFinal = findViewById(R.id.txvTotal);
         txtPrecio = findViewById(R.id.txvPrecio);
         txtDescripcion = findViewById(R.id.txvDescrip);
         txtCantidad = findViewById(R.id.txvCantidad);
         btnRegre = findViewById(R.id.btnRegresarPrin);

        //Recibiendo valores enviados
        Bundle bundle = getIntent().getExtras();
        String prod = bundle.getString("titulo");
        Double precio = bundle.getDouble("precio");
        String descripcion = bundle.getString("descripcion");
        String cantidad = bundle.getString("cantidad");

        double importe = 99.99;
        int canti = Integer.parseInt(cantidad);
        NumberFormat formatoImporte = NumberFormat.getCurrencyInstance();
        formatoImporte = NumberFormat.getCurrencyInstance(new Locale("en","US"));

        double total = canti * precio;
        String totalF = formatoImporte.format(total).toString();
        String precioF = formatoImporte.format(precio).toString();

        //Asignar valores a los objetos de la ACTIVITY
        txtProducto.setText(prod);
        txtPrecio.setText(precioF);
        txtDescripcion.setText(descripcion);
        txtCantidad.setText(cantidad);
        txtFinal.setText(totalF);

        btnRegre = findViewById(R.id.btnRegresarPrin);
        btnRegre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent act = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(act);
            }

        });
    }
}