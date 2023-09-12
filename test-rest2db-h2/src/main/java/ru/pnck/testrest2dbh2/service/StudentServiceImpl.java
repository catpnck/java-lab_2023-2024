package ru.pnck.testrest2dbh2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.pnck.testrest2dbh2.dao.StudentDao;
import ru.pnck.testrest2dbh2.entity.Student;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    @Transactional
    public List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }

    @Transactional
    @Override
    public Student saveStudent(Student student) {
        return studentDao.saveStudent(student);
    }

    @Transactional
    @Override
    public Student getStudent(int id) {
        return studentDao.getStudent(id);
    }

    @Transactional
    @Override
    public void deleteStudent(int id) {
        studentDao.deleteStudent(id);
    }
}
