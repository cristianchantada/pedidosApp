package org.cvarela.services;

import org.cvarela.models.entities.Consumicion;

import java.util.List;
import java.util.Optional;

public interface ConsumicionService {

    List<Consumicion> getAll();

    Optional<Consumicion> get(Integer id);

    void save(Consumicion t);

    void delete(Integer id);
}
