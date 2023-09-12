package ru.pnck.testrest2dbh2.dao;

import org.springframework.stereotype.Repository;
import ru.pnck.testrest2dbh2.entity.Student;

import java.util.List;

@Repository
public interface StudentDao {

    List<Student> getAllStudents();

    Student saveStudent(Student student);

    Student getStudent(int id);

    void deleteStudent(int id);


}
