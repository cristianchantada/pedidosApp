package org.varelacasas.services;

import jakarta.inject.Inject;
import org.varelacasas.configs.Service;
import org.varelacasas.interceptors.TransactionalJpa;
import org.varelacasas.models.entities.Consumicion;
import org.varelacasas.repositories.CrudRepositoryInterface;
import org.varelacasas.repositories.RepositoryJpa;

import java.util.List;
import java.util.Optional;

@Service
@TransactionalJpa
public class ConsumicionServiceJpaImpl implements ConsumicionService {

    @Inject
    @RepositoryJpa
    private CrudRepositoryInterface<Consumicion> repository;

    @Override
    public List<Consumicion> getAll() {
        try {
            return repository.getAll();
        } catch (Exception throwables) {
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }

    @Override
    public Optional<Consumicion> get(Integer id) {
        try {
            return Optional.ofNullable(repository.get(id));
        } catch (Exception throwables) {
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }

    @Override
    public void save(Consumicion bar) {
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
