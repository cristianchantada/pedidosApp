package org.cvarela.services;

import org.cvarela.models.entities.Alumno;

import java.util.List;
import java.util.Optional;

public interface AlumnoService {

    List<Alumno> getAll();

    Optional<Alumno> get(Integer id);

    void save(Alumno t);

    void delete(Integer id);
}
