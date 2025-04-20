package com.egg.libreriaapi.repositorios;

import com.egg.libreriaapi.entidades.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepositorio extends JpaRepository<Autor, String> {
}
