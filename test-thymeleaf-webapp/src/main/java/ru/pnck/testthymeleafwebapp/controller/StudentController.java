package ru.pnck.testthymeleafwebapp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.pnck.testthymeleafwebapp.dao.StudentRepository;
import ru.pnck.testthymeleafwebapp.entity.Student;

@Slf4j
@Controller
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping({"/list", "/"})
    public ModelAndView getAllStudents() {
        log.info("/list -> connection");
        var mav = new ModelAndView("list-students");
        mav.addObject("students", studentRepository.findAll());
        return mav;
    }

    @GetMapping("/addStudentForm")
    public ModelAndView addStudentForm() {
        var mav = new ModelAndView("add-student-form");
        var student = new Student();
        mav.addObject("student", student);
        return mav;
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute Student student) {
        studentRepository.save(student);
        return "redirect:/list";
    }

    @GetMapping("/showUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam Long studentId) {
        var mav = new ModelAndView("add-student-form");
        var optionalStudent = studentRepository.findById(studentId);
        var student = optionalStudent.orElseGet(Student::new);
        mav.addObject("student", student);
        return mav;
    }

    @GetMapping("/deleteStudent")
    public String deleteStudent(@RequestParam Long studentId){
        studentRepository.deleteById(studentId);
        return "redirect:/list";
    }
}
