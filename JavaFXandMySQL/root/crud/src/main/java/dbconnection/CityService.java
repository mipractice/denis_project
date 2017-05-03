package dbconnection;

import entity.CityEntity;

import java.util.List;

/**
 * Created by DrSwitch on 22.04.2017.
 */
public interface CityService {
    CityEntity getByIdCity(long idcity);

    CityEntity addStudent(CityEntity city);

    void updateStudent(CityEntity city);

    void deleteStudent(long idcity);

    List<CityEntity> getAllcity();
}
