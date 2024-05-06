package org.cvarela.services;

import org.cvarela.models.entities.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {

    List<Producto> getAll();

    Optional<Producto> get(Integer id);

    void save(Producto t);

    void delete(Integer id);
}
