package com.egg.libreriaapi.repositorios;

import com.egg.libreriaapi.entidades.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

public interface EditorialRespositorio extends JpaRepository<Editorial, String>{
    List<Editorial> findByEditorialActivaTrue();
    List<Editorial> findByEditorialActivaFalse();
}
