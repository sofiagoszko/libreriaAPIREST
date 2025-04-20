package com.egg.libreriaapi.entidades;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="autor")
public class Autor {

    @Id
    @Column(name = "id_autor")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String idAutor;

    @Column(name="autor_activo")
    private boolean autorActivo;

    @Column(name="nombre_autor")
    private String nombreAutor;

    public Autor() {
    }

    public String getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(String idAutor) {
        this.idAutor = idAutor;
    }

    public boolean isAutorActivo() {
        return autorActivo;
    }

    public void setAutorActivo(boolean autorActivo) {
        this.autorActivo = autorActivo;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }
}
