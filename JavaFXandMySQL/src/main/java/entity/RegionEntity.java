package entity;

import javax.persistence.*;

/**
 * Created by DrSwitch on 30.04.2017.
 */
@Entity
@Table(name = "region", schema = "infostudent2", catalog = "")
public class RegionEntity {
    private int regionid;
    private String regionname;
    private int countryid;

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

    @Basic
    @Column(name = "countryid")
    public int getCountryid() {
        return countryid;
    }

    public void setCountryid(int countryid) {
        this.countryid = countryid;
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
}
