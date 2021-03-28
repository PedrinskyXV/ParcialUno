package com.example.parcialuno;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rcvPc;
    private PcAdapter pcAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcvPc = findViewById(R.id.rcvLista);
        rcvPc.setLayoutManager(new LinearLayoutManager(this));
        pcAdapter = new PcAdapter(obtenerPc());
        rcvPc.setAdapter(pcAdapter);
        pcAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Seleccion  "
                        +obtenerPc().get(rcvPc.getChildAdapterPosition(v)).getTitulo(), Toast.LENGTH_SHORT).show();
                String aux = "";
                aux = obtenerPc().get(rcvPc.getChildAdapterPosition(v)).getTitulo();
                Intent act = new Intent(MainActivity.this,producto.class);
                act.putExtra("titulo",aux);
                aux = obtenerPc().get(rcvPc.getChildAdapterPosition(v)).getDescripcion();
                act.putExtra("descripcion",aux);
                startActivity(act);
            }
        });
        Bundle bundle = getIntent().getExtras();
    }
    public List<PcModelo> obtenerPc(){
        List<PcModelo> pc = new ArrayList<>();
        pc.add(new PcModelo("Laptops","Las laptops y dispositivos mas potentes del mercado.",
                R.drawable.laptops));
        pc.add(new PcModelo("MicroProcesadores","Los más potentes y veloces del mercado a precio accesible.",
                R.drawable.procesador));
        pc.add(new PcModelo("Tarjetas Gráficas","Para los juegos más exigentes y con la mejor resolución.",
                R.drawable.grafica));
        pc.add(new PcModelo("Memoria RAM","Las más confiables y de mayor transaccion de datos.",
                R.drawable.ram));
        return pc;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuoverflow,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.btnIntegrantes){
            Intent intent = new Intent(getApplicationContext(),integrantes.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}