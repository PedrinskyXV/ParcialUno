package com.example.parcialuno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

public class producto extends AppCompatActivity {
    Button btnConfirmar;
    TextView txtProducto, txtPrecio, txtDescripcion;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);
        btnConfirmar = findViewById(R.id.btnConfirmar);
        txtProducto = findViewById(R.id.txvProducto);
        txtPrecio = findViewById(R.id.txvPrecio);
        txtDescripcion = findViewById(R.id.txvDescripcionP);
        String info = "";
        img = findViewById(R.id.imgPortada);
        Bundle bundle = getIntent().getExtras();
        String titulo = "";
        String producto = bundle.getString("titulo");
        double importe = -1234.56;
        NumberFormat formatoImporte = NumberFormat.getCurrencyInstance();
        //Si se desea forzar el formato español:
        formatoImporte = NumberFormat.getCurrencyInstance(new Locale("en","US"));


        switch (producto.toLowerCase()){
            case "laptops":
                importe = 1396.99;
                titulo = "LG Gram Thin & Light Laptop";
                info = "Pantalla LCD IPS de 14 pulgadas WUXGA (1920 x 1200),Windows 10 Home (64 bits),CPU Intel Core i7-1165G7 de 11ª generación,16 GB LPDDR4X 4266 MHz RAM con 512 GB NVMe SSD,Batería de litio de 80 WH (hasta 25,5 horas),Gráficos Intel Iris Xe,Thunderbolt 4,Teclado retroiluminado";
                img.setImageResource(R.drawable.productolaptop);
                break;
            case "microprocesadores":
                importe = 418.99;
                titulo = "Intel Core i7-11700K";
                info = "Compatible con Intel 500 Series y Select Intel 400 Series chipset,Compatible con tecnología Intel Turbo Boost Max 3.0, Soporte de memoria Intel Optane Compatible con PCIe Gen 4.0, No incluye solución térmica.";
                img.setImageResource(R.drawable.productocpu2);
                break;
            case "tarjetas gráficas":
                importe = 1699;
                titulo = "Nvidia GeForce RTX 2080 Edición Fundadores";
                info = "Alimentado por la unidad de procesamiento gráfico NVIDIA GeForce RTX 2080 (GPU) con una velocidad de reloj de aumento de 1800 MHz para ayudar a satisfacer las necesidades de juegos exigentes.";
                img.setImageResource(R.drawable.productogpu);
                break;
            case "memoria ram":
                importe = 107.99;
                titulo = "Corsair Vengeance RGB PRO 16GB";
                info = "Asegúrate de que esto coincide al ingresar tu número de modelo. Iluminación RGB dinámica multizona Software de próxima generación PCB de rendimiento personalizado Memoria bien blindada. Ancho de banda máximo y tiempos de respuesta reducidos.";
                img.setImageResource(R.drawable.productoram);
                break;
            default:
                img.setImageResource(R.drawable.ic_intel_footer_logo);
                break;
        }

        //String info = bundle.getString("descripcion");
        txtProducto.setText(titulo);
        txtDescripcion.setText(info);
        txtPrecio.setText(formatoImporte.format(importe).toString());
        Spinner spinner = (Spinner) findViewById(R.id.txvCantidad);
        Integer[] datos = new Integer[] {1,2,3};
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this,
                android.R.layout.simple_spinner_item, datos);
        spinner.setAdapter(adapter);

        //int cantidad  = Integer.parseInt(String.valueOf(txtCantidad.getText()));
        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Preparacion de datos de enio
                Intent act2 = new Intent(getApplicationContext(),venta.class);
                //Preparando data a enviar
                act2.putExtra("titulo",txtProducto.getText());
                act2.putExtra("descripcion",txtDescripcion.getText());
                act2.putExtra("precio",txtPrecio.getText());
                //act2.putExtra("cantidad",cantidad);
                startActivity(act2);
            }
        });
    }
}