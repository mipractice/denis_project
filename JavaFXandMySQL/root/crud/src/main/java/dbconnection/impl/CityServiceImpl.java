package dbconnection.impl;

import dao.impl.CityDAOServiceImpl;
import dbconnection.intface.CityService;
import entity.CityEntity;
import entity.RegionEntity;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by DrSwitch on 22.04.2017.
 */
public class CityServiceImpl implements CityService {

    private CityDAOServiceImpl cityDAOService = new CityDAOServiceImpl();
    public CityEntity getByIdCity(int idcity) {
        return null;
    }

    public CityEntity addCity(CityEntity city) {
        cityDAOService.add(city);
        return city;
    }

    public void updateCity(CityEntity city) {
        cityDAOService.update(city);
    }

    public void deleteCity(int idcity) {
        cityDAOService.delete(idcity);
    }

    public List<CityEntity> getAllcity() {
        return cityDAOService.getAll();
    }

    public List<CityEntity> getCitiesInRegion(RegionEntity region) {
        return cityDAOService.getCitiesInRegion(region);
    }

}
