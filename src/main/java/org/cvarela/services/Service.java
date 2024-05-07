package org.cvarela.services;

import java.util.List;
import java.util.Optional;

public interface Service {

    List getAll();

    Optional get(Integer id);

    void save(Object o);

    void delete(Integer id);

}
