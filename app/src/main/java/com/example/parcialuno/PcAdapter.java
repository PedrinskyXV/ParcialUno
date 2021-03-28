package com.example.parcialuno;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PcAdapter extends RecyclerView.Adapter<PcAdapter.ViewHolder> implements View.OnClickListener{
    private View.OnClickListener listener;
    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView titulo, descripcion;
        ImageView fotoPortada;
        public ViewHolder(View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.txvTitulo);
            descripcion = itemView.findViewById(R.id.txvDescripcion);
            fotoPortada = itemView.findViewById(R.id.imvPortada);
        }
    }

    public List<PcModelo> pcModeloList;
    public PcAdapter(List<PcModelo> pcModeloList){
        this.pcModeloList=pcModeloList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_pc,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        view.setOnClickListener(this);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.titulo.setText(pcModeloList.get(position).getTitulo());
        holder.descripcion.setText(pcModeloList.get(position).getDescripcion());
        holder.fotoPortada.setImageResource(pcModeloList.get(position).getPortada());
    }

    @Override
    public int getItemCount() {
        return  pcModeloList.size();
    }
    public void setOnClickListener (View.OnClickListener listener) { this.listener = listener; }
    @Override
    public void onClick(View v) {
        if (listener != null){
            listener.onClick(v);
        }
    }
}
