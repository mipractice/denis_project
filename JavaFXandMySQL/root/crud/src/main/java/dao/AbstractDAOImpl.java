package dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by DrSwitch on 03.05.2017.
 */
public abstract class AbstractDAOImpl<T> implements DAO<T>{

    @PersistenceContext
    protected EntityManager entityManager = Persistence.createEntityManagerFactory("CRUD").createEntityManager();
    protected Class<? extends AbstractDAOImpl> type = getClass();
    protected Class<T> entity;
    protected String persistentClass = type.getSimpleName();


    @Override
    public T getById(int id) {
        TypedQuery<T> find = entityManager.createNamedQuery(persistentClass + ".find", entity);
        find.setParameter("id", id);
        find.getResultList();
        return find.getSingleResult();

    }

    @Override
    public T add(T domain) {
        this.entityManager.getTransaction().begin();
        this.entityManager.clear();
        this.entityManager.merge(domain);
        this.entityManager.getTransaction().commit();
        return domain;
    }

    @Override
    public void update(T domain) {

        this.entityManager.getTransaction().begin();
        this.entityManager.merge(domain);
        this.entityManager.getTransaction().commit();
    }

    @Override
    public void delete(int id) {
        this.entityManager.getTransaction().begin();
        this.entityManager.clear();
        this.entityManager.remove(getById(id));
        this.entityManager.getTransaction().commit();
    }

    @Override
    public List<T> getAll() {
        TypedQuery<T> typedQuery = this.entityManager.createNamedQuery(persistentClass + ".getAll", entity);
        return typedQuery.getResultList();
    }


}
