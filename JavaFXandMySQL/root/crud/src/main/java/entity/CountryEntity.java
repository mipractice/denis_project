package entity;

import javax.persistence.*;

/**
 * Created by DrSwitch on 30.04.2017.
 */
@Entity
@Table(name = "country", schema = "infostudent2", catalog = "")
public class CountryEntity {
    private int countryid;
    private String countryname;

    @Id
    @Column(name = "countryid")
    public int getCountryid() {
        return countryid;
    }

    public void setCountryid(int countryid) {
        this.countryid = countryid;
    }

    @Basic
    @Column(name = "countryname")
    public String getCountryname() {
        return countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CountryEntity that = (CountryEntity) o;

        if (countryid != that.countryid) return false;
        if (countryname != null ? !countryname.equals(that.countryname) : that.countryname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = countryid;
        result = 31 * result + (countryname != null ? countryname.hashCode() : 0);
        return result;
    }
}
