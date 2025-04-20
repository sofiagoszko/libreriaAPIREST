package com.egg.libreriaapi.servicios;

import com.egg.libreriaapi.entidades.Autor;
import com.egg.libreriaapi.modelos.AutorModificarEstadoDTO;
import com.egg.libreriaapi.repositorios.AutorRepositorio;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AutorServicio {

    @Autowired
    private AutorRepositorio autorRepositorio;

    @Transactional
    public Autor guardarAutor(String nombre){
        Autor autor = new Autor();
        autor.setNombreAutor(nombre);
        autor.setAutorActivo(true);
        return autorRepositorio.save(autor);
    }

    public List<Autor> listarAutores() {
        return autorRepositorio.findAll();
    }

    public Autor buscarAutorPorId(String id) {
        return autorRepositorio.findById(id).orElseThrow(() -> new EntityNotFoundException("no existe el autor solicitado"));
    }

    @Transactional
    public void eliminarAutor(String id) {
        Autor autor = buscarAutorPorId(id);
        autor.setAutorActivo(false);
    }

    @Transactional
    public Autor actulizarAutor(AutorModificarEstadoDTO autorDTO, String id) {
        Autor autor = buscarAutorPorId(id);
        autor.setNombreAutor(autorDTO.getNombreAutor());
        return autorRepositorio.save(autor);
    }
}
