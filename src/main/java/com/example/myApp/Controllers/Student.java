package com.example.myApp.Controllers;

import jakarta.persistence.*;

@Entity
@Table
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int Grade;
    private int score;
    @Transient
    private int calculated;

    public Student() {
    }
    public Student(String name, int grade, int score) {
        this.name = name;
        Grade = grade;
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return Grade;
    }

    public void setGrade(int grade) {
        Grade = grade;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getCalculated() {
        return score*5;
    }

    public void setcalulated(int calculated) {
        this.calculated = calculated;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Grade=" + Grade +
                ", score=" + score +
                ", calculated=" + calculated +
                '}';
    }
}
