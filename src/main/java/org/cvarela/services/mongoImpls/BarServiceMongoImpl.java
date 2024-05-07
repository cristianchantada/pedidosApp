package org.cvarela.services.mongoImpls;

import jakarta.inject.Inject;
import org.cvarela.configs.Service;
import org.cvarela.interceptors.TransactionalMongo;
import org.cvarela.models.entities.Bar;
import org.cvarela.repositories.CrudRepositoryInterface;
import org.cvarela.repositories.RepositoryMongo;
import org.cvarela.services.BarService;
import org.cvarela.services.ServiceJdbcException;

import java.util.List;
import java.util.Optional;

@Service
@TransactionalMongo
public class BarServiceMongoImpl implements BarService {

    @Inject
    @RepositoryMongo
    private CrudRepositoryInterface<Bar> repository;

    @Override
    public List<Bar> getAll() {
        try {
            return repository.getAll();
        } catch (Exception throwables) {
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }

    @Override
    public Optional<Bar> get(Integer id) {
        try {
            return Optional.ofNullable(repository.get(id));
        } catch (Exception throwables) {
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }

    @Override
    public void save(Bar bar) {
        try {
            repository.save(bar);
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
