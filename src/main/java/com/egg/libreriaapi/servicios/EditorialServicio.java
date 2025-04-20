package com.egg.libreriaapi.servicios;

import com.egg.libreriaapi.entidades.Editorial;
import com.egg.libreriaapi.modelos.EditorialCreateDTO;
import com.egg.libreriaapi.repositorios.EditorialRespositorio;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EditorialServicio {
    @Autowired
    private EditorialRespositorio editorialRespositorio;

//    @Transactional
//    public Editorial guardarEditorial(String nombreEditorial){
//        Editorial editorial = new Editorial();
//        editorial.setNombreEditorial(nombreEditorial);
//        editorial.setEditorialActiva(true);
//        return editorialRespositorio.save(editorial);
//    }

    @Transactional
    public void guardarEditorial(EditorialCreateDTO editorialDTO){
        Editorial editorial = new Editorial();
        editorial.setNombreEditorial(editorialDTO.getNombreEditorial());
        editorial.setEditorialActiva(true);
        editorialRespositorio.save(editorial);
    }

    public List<Editorial> listarEditorial(){
        return editorialRespositorio.findAll();
    }

    public List<Editorial> listarEditorialesActivas(){
        return editorialRespositorio.findByEditorialActivaTrue();
    }

    public List<Editorial> listarEditorialesInactivas(){
        return editorialRespositorio.findByEditorialActivaFalse();
    }

    public Editorial buscarEditorialPorId(String id){
        return editorialRespositorio.findById(id).orElseThrow(()-> new EntityNotFoundException("No se encontró la editorial"));
    }

    @Transactional
    public void eliminarEditorial(String id){
        Editorial editorial = buscarEditorialPorId(id);
        editorial.setEditorialActiva(false);
    }

    @Transactional
    public Editorial actualizarEditorial(String id, String nombreEditorial){
        Editorial editorial = buscarEditorialPorId(id);
        editorial.setNombreEditorial(nombreEditorial);
        return editorialRespositorio.save(editorial);
    }
}
