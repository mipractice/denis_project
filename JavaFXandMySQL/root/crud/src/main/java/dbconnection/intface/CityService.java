package dbconnection.intface;

import entity.CityEntity;

import java.util.List;

/**
 * Created by DrSwitch on 22.04.2017.
 */
public interface CityService {
    CityEntity getByIdCity(int idcity);

    CityEntity addCity(CityEntity city);

    void updateCity(CityEntity city);

    void deleteCity(int idcity);

    List<CityEntity> getAllcity();
}
