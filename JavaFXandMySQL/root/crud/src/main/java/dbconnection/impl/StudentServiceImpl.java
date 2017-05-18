package dbconnection.impl;

import dao.impl.StudentDAOServiceImpl;
import dbconnection.intface.StudentService;
import entity.StudentEntity;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import java.util.List;

/**
 * Created by DrSwitch on 13.04.2017.
 */
public class StudentServiceImpl implements StudentService {

    private EntityManager entityManager = Persistence.createEntityManagerFactory("CRUD").createEntityManager();
    private StudentDAOServiceImpl studentDAOService = new StudentDAOServiceImpl();

    public StudentEntity getByIdStudent(int idstudent) {
        return this.entityManager.find(StudentEntity.class, idstudent);
    }

    public StudentEntity addStudent(StudentEntity student) {
        studentDAOService.add(student);
        return student;
    }

    public void updateStudent(StudentEntity student) {
        studentDAOService.update(student);
    }

    public void deleteStudent(int idStudent) {
        studentDAOService.delete(idStudent);

    }

    public List<StudentEntity> getAllStudent(){
        return studentDAOService.getAll();
    }
}
