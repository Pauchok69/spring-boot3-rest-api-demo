package com.andy.springboot3restapidemo.controller;

import com.andy.springboot3restapidemo.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    @GetMapping("student")
    public Student getStudent() {
        return new Student(1, "John", "Doe");
    }

    @GetMapping("students")
    public List<Student> getStudents() {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(1, "John", "Doe"));
        students.add(new Student(2, "Jane", "Doe"));
        students.add(new Student(3, "Boris", "Doe"));

        return students;
    }

    @GetMapping("students/{id}/{first-name}/{last-name}")
    public Student getStudentByPathVariable(
            @PathVariable("id") int studentId,
            @PathVariable("first-name") String studentFirstName,
            @PathVariable("last-name") String studentLastName
    ) {
        return new Student(studentId, studentFirstName, studentLastName);
    }

    @GetMapping("students/query")
    public Student getStudentByQueryVariable(@RequestParam(defaultValue = "89898") int id) {
        return new Student(id, "John", "Doe");
    }
}
