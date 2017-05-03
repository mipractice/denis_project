package dbconnection;

import entity.StudentEntity;

import java.util.List;

/**
 * Created by DrSwitch on 20.04.2017.
 */
public interface StudentService {
    StudentEntity getByIdStudent(int idStudent);

    StudentEntity addStudent(StudentEntity student);

    void updateStudent(StudentEntity student);

    void deleteStudent(int idStudent);

    List<StudentEntity> getAllStudent();
}
