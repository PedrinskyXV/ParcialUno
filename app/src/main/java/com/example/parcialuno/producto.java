package com.example.parcialuno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class producto extends AppCompatActivity {
    Button btnConfirmar;
    TextView txtProducto, txtPrecio, txtDescripcion;
    EditText txtCantidad;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);
        btnConfirmar = findViewById(R.id.btnConfirmar);
        txtProducto = findViewById(R.id.txvProducto);
        txtPrecio = findViewById(R.id.txvPrecio);
        txtCantidad = findViewById(R.id.txvCantidad);
        txtDescripcion = findViewById(R.id.txvDescripcionP);
        img = findViewById(R.id.imgPortada);
        Bundle bundle = getIntent().getExtras();
        String producto = bundle.getString("titulo");
        switch (producto){
            case "Laptops":
                txtPrecio.setText("$ 1200");
                img.setImageResource(R.drawable.laptops);
                break;
            case "MicroProcesadores":
                txtPrecio.setText("$ 750.89");
                img.setImageResource(R.drawable.procesador);
                break;
            case "Tarjetas Gráficas":
                txtPrecio.setText("$ 2500.99");
                img.setImageResource(R.drawable.grafica);
                break;
            case "Memoria Ram":
                txtPrecio.setText("$ 65.00");
                img.setImageResource(R.drawable.ram);
                break;
        }
        String info = bundle.getString("descripcion");
        txtProducto.setText(producto);
        txtDescripcion.setText(info);
        int cantidad  = Integer.parseInt(String.valueOf(txtCantidad.getText()));
        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Preparacion de datos de enio
                Intent act2 = new Intent(getApplicationContext(),venta.class);
                //Preparando data a enviar
                act2.putExtra("titulo",producto);
                act2.putExtra("descripcion",info);
                act2.putExtra("precio",txtPrecio.getText());
                act2.putExtra("cantidad",cantidad);
                startActivity(act2);
            }
        });
    }
}