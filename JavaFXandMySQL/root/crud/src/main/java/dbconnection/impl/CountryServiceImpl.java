package dbconnection.impl;

import dbconnection.intface.CountryService;
import dao.impl.CountryDAOServiceImpl;
import entity.CountryEntity;

import java.util.List;


/**
 * Created by DrSwitch on 03.05.2017.
 */
public class CountryServiceImpl implements CountryService {

    private CountryDAOServiceImpl countryDAOService = new CountryDAOServiceImpl();
    @Override
    public CountryEntity getByIdCountry(int countryid) {
        return null;
    }

    @Override
    public CountryEntity addCountry(CountryEntity country) {
        countryDAOService.add(country);
        return country;
    }

    @Override
    public void updateCountry(CountryEntity country) {
        countryDAOService.update(country);
    }

    @Override
    public void deleteCountry(int countryid) {
        countryDAOService.delete(countryid);
    }

    @Override
    public List<CountryEntity> getAllCountry() {
        return countryDAOService.getAll();
    }

}
