package com.example.myApp.Controllers;

import jakarta.persistence.Transient;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    private Repository repo;
    public List<Student> getStudents() {
        return repo.findAll();
    }
    public Optional<Student> getStudentByID(Long id) {
        return repo.findById(id);
    }
    public List<Student> AddStudent(Student student) throws Exception {
        Optional<Student> optionalstudentName = repo.findByName(student.getName());
        if (optionalstudentName.isPresent()) {
            throw new Exception("Student name already exists");
        }
        repo.save(student);
        return repo.findAll();
    }
    public void deleteStudent(Long id) throws Exception {
        boolean exists = repo.existsById(id);
        if (!exists) {
            throw new Exception("Student ID DOES NOT exist");
        }
        repo.deleteById(id);
    }
    @Transactional
    public void updateStudent(Long id,String name, Integer Grade, Integer Score) throws Exception {
        Student student = repo.findById(id).orElseThrow(() -> new Exception("No existence!"));

        if(name!=null && !name.isEmpty()){
            student.setName(name);
            if(Grade!=null) {
                student.setGrade(Grade);
            }
            if(Score!=null) {
                student.setScore(Score);
            }
            student.setcalulated(student.getCalculated());
        }

    }

}
