package com.egg.libreriaapi.modelos;

public class LibroListarActivosDTO {
    private String titulo;
    private int ejemplares;

    public LibroListarActivosDTO(String titulo, int ejemplares) {
        this.titulo = titulo;
        this.ejemplares = ejemplares;
    }

    public LibroListarActivosDTO() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(int ejemplares) {
        this.ejemplares = ejemplares;
    }
}
