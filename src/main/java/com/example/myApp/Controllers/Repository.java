package com.example.myApp.Controllers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Student, Long> {

    @Query("SELECT s FROM Student s where s.name=?1")
    Optional<Student> findByName(String name);
}
