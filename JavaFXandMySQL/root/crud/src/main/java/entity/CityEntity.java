package entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by DrSwitch on 30.04.2017.
 */
@Entity
@Table(name = "city", schema = "infostudent2")
@NamedQueries({
        @NamedQuery(name = "CityDAOServiceImpl.getAll", query = "SELECT c from CityEntity c"),
        @NamedQuery(name = "CityEntity.getAll", query = "SELECT c from CityEntity c")
})

//тут нада поискать более изящное решение у названия запроса
public class CityEntity {
    private int cityid;
    private String cityname;
    private int regionid;
    private Collection<StudentEntity> students;

    @Id
    @Column(name = "cityid")
    public int getCityid() {
        return cityid;
    }

    public void setCityid(int cityid) {
        this.cityid = cityid;
    }

    @Basic
    @Column(name = "cityname")
    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    @Basic
    @Column(name = "regionid")
    public int getRegionid() {
        return regionid;
    }

    public void setRegionid(int regionid) {
        this.regionid = regionid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CityEntity that = (CityEntity) o;

        if (cityid != that.cityid) return false;
        if (regionid != that.regionid) return false;
        if (cityname != null ? !cityname.equals(that.cityname) : that.cityname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cityid;
        result = 31 * result + (cityname != null ? cityname.hashCode() : 0);
        result = 31 * result + regionid;
        return result;
    }

    @Override
    public String toString() {
        return cityname;
    }

    public CityEntity() {
    }

    public CityEntity(int cityid, String cityname) {
        this.cityid = cityid;
        this.cityname = cityname;
    }

    @OneToMany(mappedBy = "city")
    public Collection<StudentEntity> getStudents() {
        return students;
    }

    public void setStudents(Collection<StudentEntity> students) {
        this.students = students;
    }

}
