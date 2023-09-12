package ru.pnck.testthymeleafwebapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pnck.testthymeleafwebapp.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
