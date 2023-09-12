package ru.pnck.testrest2dbh2.dao;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.pnck.testrest2dbh2.entity.Student;

import java.util.List;

@Slf4j
@Repository
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Student> getAllStudents() {
        var query = entityManager.createQuery("select s from Student s");
        var allStudents = query.getResultList();
        log.info("getAllStudents: " + allStudents);
        return allStudents;
    }

    @Override
    public Student saveStudent(Student student) {
        return entityManager.merge(student);
    }

    @Override
    public Student getStudent(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public void deleteStudent(int id) {
        entityManager.createQuery("delete from Student where id=:studentId")
                .setParameter("studentId", id)
                .executeUpdate();
    }
}
