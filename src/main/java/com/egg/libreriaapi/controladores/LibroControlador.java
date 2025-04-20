package com.egg.libreriaapi.controladores;

import com.egg.libreriaapi.modelos.LibroCreateDTO;
import com.egg.libreriaapi.modelos.LibroListarActivosDTO;
import com.egg.libreriaapi.servicios.LibroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libro")
public class LibroControlador {
    @Autowired
    private LibroServicio libroServicio;

    @PostMapping()
    public ResponseEntity<Object> crearLibro(@RequestBody LibroCreateDTO libroDTO) {
        try{
            libroServicio.crearLibro(libroDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(libroDTO);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/activos")
    public ResponseEntity<List<LibroListarActivosDTO>> listarLibrosActivos(){
        try{
            List<LibroListarActivosDTO> libros = libroServicio.listarLibroActivos();
            return ResponseEntity.status(HttpStatus.OK).body(libros);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
