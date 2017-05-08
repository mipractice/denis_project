package dbconnection.intface;

import entity.CountryEntity;

import java.util.List;

/**
 * Created by DrSwitch on 03.05.2017.
 */
public interface CountryService {

    CountryEntity getByIdCountry(int countryid);

    CountryEntity addCountry(CountryEntity country);

    void updateCountry(CountryEntity country);

    void deleteCountry(int countryid);

    List<CountryEntity> getAllCountry();
}
