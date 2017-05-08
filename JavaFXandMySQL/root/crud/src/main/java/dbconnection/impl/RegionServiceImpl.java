package dbconnection.impl;

import dao.impl.RegionDAOServiceImpl;
import dbconnection.intface.RegionService;
import entity.RegionEntity;

import java.util.List;

/**
 * Created by DrSwitch on 04.05.2017.
 */
public class RegionServiceImpl implements RegionService {

    private RegionDAOServiceImpl regionDAOService = new RegionDAOServiceImpl();
    @Override
    public RegionEntity getByIdRegion(int regionid) {
        return null;
    }

    @Override
    public RegionEntity addRegion(RegionEntity region) {
        regionDAOService.add(region);
        return region;
    }

    @Override
    public void updateRegion(RegionEntity region) {
        regionDAOService.update(region);
    }

    @Override
    public void deleteRegion(int regionid) {
        regionDAOService.delete(regionid);
    }

    @Override
    public List<RegionEntity> getAllRegion() {
        return regionDAOService.getAll();
    }
}
