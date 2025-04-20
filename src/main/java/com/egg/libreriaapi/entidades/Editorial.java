package com.egg.libreriaapi.entidades;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name = "editorial")
public class Editorial {

    @Id
    @Column(name = "id_editorial")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String idEditorial;

    @Column(name = "editorial_activa")
    private Boolean editorialActiva;

    @Column(name = "nombre_editorial")
    private String nombreEditorial;

    public Editorial() {
    }

    public String getIdEditorial() {
        return idEditorial;
    }

    public void setIdEditorial(String idEditorial) {
        this.idEditorial = idEditorial;
    }

    public Boolean getEditorialActiva() {
        return editorialActiva;
    }

    public void setEditorialActiva(Boolean editorialActiva) {
        this.editorialActiva = editorialActiva;
    }

    public String getNombreEditorial() {
        return nombreEditorial;
    }

    public void setNombreEditorial(String nombreEditorial) {
        this.nombreEditorial = nombreEditorial;
    }
}
