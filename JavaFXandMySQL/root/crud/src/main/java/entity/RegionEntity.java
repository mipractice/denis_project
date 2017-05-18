package entity;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.util.Collection;

/**
 * Created by DrSwitch on 30.04.2017.
 */
@Entity
@Table(name = "region", schema = "infostudent2")
@NamedQueries({
        @NamedQuery(name = "RegionDAOServiceImpl.getAll", query = "SELECT c from RegionEntity c"),
        @NamedQuery(name = "RegionEntity.getAll", query = "SELECT c from RegionEntity c"),
        @NamedQuery(name = "RegionDAOServiceImpl.find", query = "SELECT c from RegionEntity c WHERE c.id = :id"),
        @NamedQuery(name = "RegionsInCountry.find", query = "SELECT c from RegionEntity c WHERE c.country = :country")
})
public class RegionEntity {
    private int regionid;
    private String regionname;
    private int countryid;
    private CountryEntity country;
    private Collection<CityEntity> cities;

    @Id
    @Column(name = "regionid")
    public int getRegionid() {
        return regionid;
    }

    public void setRegionid(int regionid) {
        this.regionid = regionid;
    }

    @Basic
    @Column(name = "regionname")
    public String getRegionname() {
        return regionname;
    }

    public void setRegionname(String regionname) {
        this.regionname = regionname;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegionEntity that = (RegionEntity) o;

        if (regionid != that.regionid) return false;
        if (countryid != that.countryid) return false;
        if (regionname != null ? !regionname.equals(that.regionname) : that.regionname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = regionid;
        result = 31 * result + (regionname != null ? regionname.hashCode() : 0);
        result = 31 * result + countryid;
        return result;
    }

    public RegionEntity() {
    }

    public RegionEntity(int regionid, String regionname, CountryEntity country) {
        this.regionid = regionid;
        this.regionname = regionname;
        this.country = country;
    }

    @Override
    public String toString() {
        return regionname;
    }

    @ManyToOne
    @JoinColumn(name="countryid")
    public CountryEntity getCountry() {
        return country;
    }

    public void setCountry(CountryEntity country) {
        this.country = country;
    }

    @OneToMany(mappedBy = "region")
    public Collection<CityEntity> getCities() {
        return cities;
    }

    public void setCities(Collection<CityEntity> cities) {
        this.cities = cities;
    }

}
