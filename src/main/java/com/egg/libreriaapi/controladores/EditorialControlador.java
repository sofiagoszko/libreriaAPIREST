package com.egg.libreriaapi.controladores;

import com.egg.libreriaapi.entidades.Editorial;
import com.egg.libreriaapi.modelos.EditorialCreateDTO;
import com.egg.libreriaapi.servicios.EditorialServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/editorial")
public class EditorialControlador {
    @Autowired
    private EditorialServicio editorialServicio;

    @PostMapping()
    public ResponseEntity<EditorialCreateDTO> crearEditorial(@RequestBody EditorialCreateDTO editorialDTO) {
        try{
            editorialServicio.guardarEditorial(editorialDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(editorialDTO);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping()
    public ResponseEntity<List<Editorial>> listarEditoriales(){
        try{
            List<Editorial> editoriales = editorialServicio.listarEditorial();
            return ResponseEntity.status(HttpStatus.OK).body(editoriales);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/activas")
    public ResponseEntity<List<Editorial>> listarEditorialesActivas(){
        try{
            List<Editorial> editoriales = editorialServicio.listarEditorialesActivas();
            return ResponseEntity.status(HttpStatus.OK).body(editoriales);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/inactivas")
    public ResponseEntity<List<Editorial>> listarEditorialesInactivas(){
        try{
            List<Editorial> editoriales = editorialServicio.listarEditorialesInactivas();
            return ResponseEntity.status(HttpStatus.OK).body(editoriales);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<Editorial> listarEditorial(@PathVariable String id){
        try{
            Editorial editorial = editorialServicio.buscarEditorialPorId(id);
            return ResponseEntity.status(HttpStatus.OK).body(editorial);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Editorial> modificarEditorial(@RequestBody Map<String,Object> body, @PathVariable String id) {
        try {
            String nombreEditorial = (String) body.get("nombreEditorial");
            Editorial editorial = editorialServicio.actualizarEditorial(id, nombreEditorial);
            return ResponseEntity.status(HttpStatus.OK).body(editorial);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminarEditorial(@PathVariable String id) {
        try {
            editorialServicio.eliminarEditorial(id);
            return ResponseEntity.status(HttpStatus.OK).body("Editorial eliminada");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
