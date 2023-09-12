package ru.pnck.testrest2dbh2.service;

import ru.pnck.testrest2dbh2.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    Student saveStudent(Student student);

    Student getStudent(int id);

    void deleteStudent(int id);
}
