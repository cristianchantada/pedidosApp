package org.cvarela.services.jpaImpls;

import jakarta.inject.Inject;
import org.cvarela.configs.Service;
import org.cvarela.interceptors.TransactionalJpa;
import org.cvarela.models.entities.sql.Producto;
import org.cvarela.repositories.CrudRepositoryInterface;
import org.cvarela.repositories.RepositoryJpa;
import org.cvarela.services.ProductoService;
import org.cvarela.services.ServiceJdbcException;

import java.util.List;
import java.util.Optional;

@Service
@TransactionalJpa
public class ProductoServiceJpaImpl implements ProductoService {

    @Inject
    @RepositoryJpa
    private CrudRepositoryInterface<Producto> repository;

    @Override
    public List<Producto> getAll() {
        try {
            return repository.getAll();
        } catch (Exception throwables) {
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }

    @Override
    public Optional<Producto> get(Integer id) {
        try {
            return Optional.ofNullable(repository.get(id));
        } catch (Exception throwables) {
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }

    @Override
    public void save(Producto producto) {
        try {
            repository.save(producto);
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
