package com.example.myApp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="api/students")
public class Controller1 {
    @Autowired
    private Service service;

    @GetMapping
    public List<Student> getStudents() {
        return service.getStudents();
    }

    @GetMapping(path = "{id}")
    public Optional<Student> getStudent(@PathVariable("id") Long id) {
        return service.getStudentByID(id);
    }

    @PostMapping
    public List<Student> addStudent(@RequestBody Student student) throws Exception {
        return service.AddStudent(student);
    }

    @PutMapping(path = "{id}")
    public void updateStudent(@PathVariable("id") Long id,@RequestParam(required=false) String name,@RequestParam(required = false) Integer Grade, @RequestParam(required = false) Integer Score) throws Exception {
        service.updateStudent(id, name, Grade, Score);
    }
    @DeleteMapping(path="{id}")
    public void deleteStudent(@PathVariable("id") Long id) throws Exception {
        service.deleteStudent(id);
    }

}
