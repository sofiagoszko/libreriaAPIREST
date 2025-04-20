package com.egg.libreriaapi.modelos;


public class LibroCreateDTO {
    private Long isbn;
    private String titulo;
    private int ejemplares;
    private String idAutor;
    private String idEditorial;
    private boolean libroActivo;

    public LibroCreateDTO() {
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
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

    public String getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(String idAutor) {
        this.idAutor = idAutor;
    }

    public String getIdEditorial() {
        return idEditorial;
    }

    public void setIdEditorial(String idEditorial) {
        this.idEditorial = idEditorial;
    }

    public boolean isLibroActivo() {
        return libroActivo;
    }

    public void setLibroActivo(boolean libroActivo) {
        this.libroActivo = libroActivo;
    }
}
