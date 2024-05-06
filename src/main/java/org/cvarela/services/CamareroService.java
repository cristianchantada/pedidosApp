package org.cvarela.services;

import org.cvarela.models.entities.Camarero;

import java.util.List;
import java.util.Optional;

public interface CamareroService {

    List<Camarero> getAll();

    Optional<Camarero> get(Integer id);

    void save(Camarero t);

    void delete(Integer id);
}
