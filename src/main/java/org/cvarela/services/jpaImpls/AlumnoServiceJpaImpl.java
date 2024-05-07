package org.cvarela.services.jpaImpls;

import jakarta.inject.Inject;
import org.cvarela.configs.Service;
import org.cvarela.interceptors.TransactionalJpa;
import org.cvarela.models.entities.sql.Alumno;
import org.cvarela.repositories.CrudRepositoryInterface;
import org.cvarela.repositories.RepositoryJpa;
import org.cvarela.services.AlumnoService;
import org.cvarela.services.ServiceJdbcException;

import java.util.List;
import java.util.Optional;

@Service
@TransactionalJpa
public class AlumnoServiceJpaImpl implements AlumnoService {

    @Inject
    @RepositoryJpa
    private CrudRepositoryInterface<Alumno> repository;

    @Override
    public List<Alumno> getAll() {
        try {
            return repository.getAll();
        } catch (Exception throwables) {
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }

    @Override
    public Optional<Alumno> get(Integer id) {
        try {
            return Optional.ofNullable(repository.get(id));
        } catch (Exception throwables) {
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }

    @Override
    public void save(Alumno alumno) {
        try {
            repository.save(alumno);
        } catch (Exception throwables) {
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            repository.delete(id);
        } catch (Exception throwables) {
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }

}
