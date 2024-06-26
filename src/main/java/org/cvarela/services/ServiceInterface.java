package org.cvarela.services;

import java.util.List;
import java.util.Optional;

public interface ServiceInterface<T> {

    List<T> getAll();

    Optional<T> get(Integer id);

    void save(T t);

    void delete(Integer id);
}
