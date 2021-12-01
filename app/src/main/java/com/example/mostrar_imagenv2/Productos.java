package com.example.mostrar_imagenv2;

public class Productos {

    String titulo;
    double precio;
    String imagen;

    public Productos(String titulo, double precio, String imagen) {
        this.titulo = titulo;
        this.precio = precio;
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
