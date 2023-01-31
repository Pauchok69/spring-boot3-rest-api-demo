package com.andy.springboot3restapidemo.controller;

import com.andy.springboot3restapidemo.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    @GetMapping("student")
    public ResponseEntity<Student> getStudent() {
        Student student = new Student(1, "John", "Doe");

        return ResponseEntity
                .ok()
                .header("custom-header", "Foo")
                .body(student);
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

    @PostMapping("students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student) {
        System.out.println("student.getId() = " + student.getId());
        System.out.println("student.getFirstName() = " + student.getFirstName());
        System.out.println("student.getLastName() = " + student.getLastName());

        return student;
    }

    @PutMapping("students/{id}/update")
    public Student updateStudent(@PathVariable("id") int studentId, @RequestBody Student student) {
        System.out.println("studentId = " + studentId);
        System.out.println("student = " + student);

        return student;
    }
}
