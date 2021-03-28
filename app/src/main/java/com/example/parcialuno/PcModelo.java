package com.example.parcialuno;

public class PcModelo {
    private String titulo, descripcion;
    private int portada;

    public PcModelo() {
    }

    public PcModelo(String titulo, String descripcion, int portada) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.portada = portada;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPortada() {
        return portada;
    }

    public void setPortada(int portada) {
        this.portada = portada;
    }
}
