package com.egg.libreriaapi.repositorios;

import com.egg.libreriaapi.entidades.Libro;
import com.egg.libreriaapi.modelos.LibroListarActivosDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LibroRepositorio extends JpaRepository<Libro, Long> {
    @Query("SELECT new com.egg.libreriaapi.modelos.LibroListarActivosDTO(l.titulo, l.ejemplares) " +
            "FROM Libro l WHERE l.libroActivo = true")
    List<LibroListarActivosDTO> encontrarActivos();
}
