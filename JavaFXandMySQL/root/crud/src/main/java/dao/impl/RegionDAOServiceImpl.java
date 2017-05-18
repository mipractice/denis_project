package dao.impl;

import dao.AbstractDAOImpl;
import entity.CountryEntity;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by DrSwitch on 04.05.2017.
 */
public class RegionDAOServiceImpl<RegionEntity> extends AbstractDAOImpl{

    public List<RegionEntity> getRegionsInContry(CountryEntity country) {
        TypedQuery<RegionEntity> typedQuery = this.entityManager.createNamedQuery("RegionsInCountry.find", entity);
        typedQuery.setParameter("country", country);
        return typedQuery.getResultList();
    }
}
