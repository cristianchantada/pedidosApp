package org.cvarela.repositories.jpaImpl;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.cvarela.configs.Repository;
import org.cvarela.models.entities.sql.Camarero;
import org.cvarela.repositories.CrudRepositoryInterface;
import org.cvarela.repositories.RepositoryJpa;

import java.util.List;

@RepositoryJpa
@Repository
public class CamareroRepositoryJpaImpl implements CrudRepositoryInterface<Camarero> {

    @Inject
    private EntityManager em;

    @Override
    public Camarero get(int id) throws Exception {
        return em.find(Camarero.class, id);
    }

    @Override
    public List<Camarero> getAll() throws Exception {
        return em.createQuery("SELECT c FROM Camarero c", Camarero.class).getResultList();
    }

    @Override
    public void save(Camarero camarero) throws Exception {
        if(camarero.getId() != null && camarero.getId() > 0){
            em.merge(camarero);
        } else {
            em.persist(camarero);
        }
    }

    @Override
    public void delete(int id) throws Exception {
        em.remove(get(id));
    }

}
