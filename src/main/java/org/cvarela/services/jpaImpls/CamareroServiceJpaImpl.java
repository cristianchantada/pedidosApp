package org.cvarela.services.jpaImpls;

import jakarta.inject.Inject;
import org.cvarela.configs.Service;
import org.cvarela.interceptors.TransactionalJpa;
import org.cvarela.models.entities.sql.Camarero;
import org.cvarela.repositories.CrudRepositoryInterface;
import org.cvarela.repositories.RepositoryJpa;
import org.cvarela.services.ServiceInterface;
import org.cvarela.services.ServiceJdbcException;

import java.util.List;
import java.util.Optional;

@Service
@TransactionalJpa
public class CamareroServiceJpaImpl implements ServiceInterface<Camarero> {

    @Inject
    @RepositoryJpa
    private CrudRepositoryInterface<Camarero> repository;

    @Override
    public List<Camarero> getAll() {
        try {
            return repository.getAll();
        } catch (Exception throwables) {
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }

    @Override
    public Optional<Camarero> get(Integer id) {
        try {
            return Optional.ofNullable(repository.get(id));
        } catch (Exception throwables) {
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }

    @Override
    public void save(Camarero camarero) {
        try {
            repository.save(camarero);
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
