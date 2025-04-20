package com.egg.libreriaapi.modelos;

public class AutorModificarEstadoDTO {
    private String id;
    private String nombreAutor;

    public AutorModificarEstadoDTO() {}

    public String getId() {
        return id;
    }
    public String getNombreAutor() {
        return nombreAutor;
    }
    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }
}
