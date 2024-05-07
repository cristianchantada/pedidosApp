package org.cvarela.repositories.jpaImpl;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.cvarela.configs.Repository;
import org.cvarela.models.entities.sql.Consumicion;
import org.cvarela.repositories.CrudRepositoryInterface;
import org.cvarela.repositories.RepositoryJpa;

import java.util.List;

@RepositoryJpa
@Repository
public class ConsumicionRepositoryJpaImpl implements CrudRepositoryInterface<Consumicion> {

    @Inject
    private EntityManager em;

    @Override
    public Consumicion get(int id) throws Exception {
        return em.find(Consumicion.class, id);
    }

    @Override
    public List<Consumicion> getAll() throws Exception {
        return em.createQuery("SELECT a FROM Alumno a", Consumicion.class).getResultList();
    }

    @Override
    public void save(Consumicion consumicion) throws Exception {
        if(consumicion.getId() != null && consumicion.getId() > 0){
            em.merge(consumicion);
        } else {
            em.persist(consumicion);
        }
    }

    @Override
    public void delete(int id) throws Exception {
        em.remove(get(id));
    }

}
