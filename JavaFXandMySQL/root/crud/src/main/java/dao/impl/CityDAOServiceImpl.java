package dao.impl;

import dao.AbstractDAOImpl;
import entity.RegionEntity;

import javax.persistence.TypedQuery;
import javax.swing.plaf.synth.Region;
import java.util.List;

/**
 * Created by DrSwitch on 05.05.2017.
 */
public class CityDAOServiceImpl<CityEntity> extends AbstractDAOImpl{

    public List<CityEntity> getCitiesInRegion(RegionEntity region) {
        TypedQuery<CityEntity> typedQuery = this.entityManager.createNamedQuery("CitiesInRegion.find", entity);
        typedQuery.setParameter("region", region);
        return typedQuery.getResultList();
    }
}
