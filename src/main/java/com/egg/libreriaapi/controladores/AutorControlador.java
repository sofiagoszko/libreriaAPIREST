package com.egg.libreriaapi.controladores;

import com.egg.libreriaapi.entidades.Autor;
import com.egg.libreriaapi.modelos.AutorModificarEstadoDTO;
import com.egg.libreriaapi.servicios.AutorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/autor")
public class AutorControlador {
    @Autowired
    private AutorServicio autorServicio;

    @PostMapping()
    public ResponseEntity<Autor> crearAutor(@RequestBody Map<String,Object> body){
        try{
            String nombreAutor = (String) body.get("nombreAutor");
            Autor autor = autorServicio.guardarAutor(nombreAutor);
            return ResponseEntity.status(HttpStatus.CREATED).body(autor);

        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping()
    public ResponseEntity<List<Autor>> listarAutores(){
        try{
            List<Autor> autores = autorServicio.listarAutores();
            return ResponseEntity.status(HttpStatus.OK).body(autores);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> listarAutor(@PathVariable String id){
        try{
            Autor autor = autorServicio.buscarAutorPorId(id);
            return ResponseEntity.status(HttpStatus.OK).body(autor);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> modificarAutor(@RequestBody AutorModificarEstadoDTO autorDTO, @PathVariable String id) {
        try {
            autorServicio.actulizarAutor(autorDTO,id);
            return ResponseEntity.status(HttpStatus.OK).body(autorDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
