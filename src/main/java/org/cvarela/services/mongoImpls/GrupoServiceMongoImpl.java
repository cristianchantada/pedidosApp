package org.cvarela.services.mongoImpls;

import jakarta.inject.Inject;
import org.cvarela.configs.Service;
import org.cvarela.interceptors.TransactionalMongo;
import org.cvarela.models.entities.Grupo;
import org.cvarela.repositories.CrudRepositoryInterface;
import org.cvarela.repositories.RepositoryJpa;
import org.cvarela.services.GrupoService;
import org.cvarela.services.ServiceJdbcException;

import java.util.List;
import java.util.Optional;

@Service
@TransactionalMongo
public class GrupoServiceMongoImpl implements GrupoService {

    @Inject
    @RepositoryJpa
    private CrudRepositoryInterface<Grupo> repository;
    
    @Override
    public List<Grupo> getAll() {
        try {
            return repository.getAll();
        } catch (Exception throwables) {
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }

    @Override
    public Optional<Grupo> get(Integer id) {
        try {
            return Optional.ofNullable(repository.get(id));
        } catch (Exception throwables) {
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }

    @Override
    public void save(Grupo grupo) {
        try {
            repository.save(grupo);
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
