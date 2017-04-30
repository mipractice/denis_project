package bdconnection;

import entity.CityEntity;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by DrSwitch on 22.04.2017.
 */
public class CityServiceImpl implements CityService{

    private EntityManager entityManager = Persistence.createEntityManagerFactory("CRUD").createEntityManager();

    public CityEntity getByIdCity(long idcity) {
        return null;
    }

    public CityEntity addStudent(CityEntity city) {
        return null;
    }

    public void updateStudent(CityEntity city) {

    }

    public void deleteStudent(long idcity) {

    }

    public List<CityEntity> getAllcity() {
        TypedQuery<CityEntity> cityTypedQuery = entityManager.createNamedQuery("CityEntity.getAll", CityEntity.class);
        return cityTypedQuery.getResultList();
    }
}
