package dbconnection.intface;

import entity.CountryEntity;
import entity.RegionEntity;

import java.util.List;

/**
 * Created by DrSwitch on 04.05.2017.
 */
public interface RegionService {
    RegionEntity getByIdRegion(int regionid);

    RegionEntity addRegion(RegionEntity region);

    void updateRegion(RegionEntity region);

    void deleteRegion(int regionid);

    List<RegionEntity> getAllRegion();

    List<RegionEntity> getRegionsInCountry(CountryEntity country);
}
