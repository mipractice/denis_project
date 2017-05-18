package entity;

import javax.persistence.*;

/**
 * Created by DrSwitch on 30.04.2017.
 */
@Entity
@Table(name = "student", schema = "infostudent2")
@NamedQueries({
        @NamedQuery(name = "StudentDAOServiceImpl.getAll", query = "SELECT c from StudentEntity c"),
        @NamedQuery(name = "StudentEntity.getAll", query = "SELECT c from StudentEntity c"),
        @NamedQuery(name = "StudentDAOServiceImpl.find", query = "SELECT c from StudentEntity c WHERE c.id = :id")
})

public class StudentEntity {
    private String fio;
    private String address;
    private int studentid;
    private int cityid;
    private CityEntity city;

    @Basic
    @Column(name = "fio")
    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Id
    @Column(name = "studentid")
    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentEntity that = (StudentEntity) o;

        if (studentid != that.studentid) return false;
        if (cityid != that.cityid) return false;
        if (fio != null ? !fio.equals(that.fio) : that.fio != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = fio != null ? fio.hashCode() : 0;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + studentid;
        result = 31 * result + cityid;
        return result;
    }

    public StudentEntity() {
    }

    public StudentEntity(int studentid, String fio, String address, CityEntity city) {
        this.fio = fio;
        this.address = address;
        this.studentid = studentid;
        this.city = city;
    }

    @ManyToOne
    @JoinColumn(name = "cityid")
    public CityEntity getCity() {
        return city;
    }

    public void setCity(CityEntity city) {
        this.city = city;
    }
}
