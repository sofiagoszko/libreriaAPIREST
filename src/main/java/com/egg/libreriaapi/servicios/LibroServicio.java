package com.egg.libreriaapi.servicios;

import com.egg.libreriaapi.entidades.Autor;
import com.egg.libreriaapi.entidades.Editorial;
import com.egg.libreriaapi.entidades.Libro;
import com.egg.libreriaapi.modelos.LibroCreateDTO;
import com.egg.libreriaapi.modelos.LibroListarActivosDTO;
import com.egg.libreriaapi.repositorios.LibroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LibroServicio {
    @Autowired
    private LibroRepositorio libroRepositorio;
    @Autowired
    private AutorServicio autorServicio;
    @Autowired
    private EditorialServicio editorialServicio;

    @Transactional
    public void crearLibro(LibroCreateDTO libroCreateDTO) {
        Libro libroNuevo = new Libro();
        libroNuevo.setIdLibro(libroCreateDTO.getIsbn());
        libroNuevo.setTitulo(libroCreateDTO.getTitulo());
        libroNuevo.setEjemplares(libroCreateDTO.getEjemplares());
        libroNuevo.setLibroActivo(libroCreateDTO.isLibroActivo());
        Autor autor = autorServicio.buscarAutorPorId(libroCreateDTO.getIdAutor());
        if (autor != null) {
            libroNuevo.setAutor(autor);
        }
        Editorial editorial = editorialServicio.buscarEditorialPorId(libroCreateDTO.getIdEditorial());
        if (editorial != null) {
            libroNuevo.setEditorial(editorial);
        }
       libroRepositorio.save(libroNuevo);
    }

    public List<LibroListarActivosDTO> listarLibroActivos() {
        return libroRepositorio.encontrarActivos();
    }
}
