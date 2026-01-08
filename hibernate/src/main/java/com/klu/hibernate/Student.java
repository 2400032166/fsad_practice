package com.klu.hibernate;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    public Student() {}

    public Student(String name) {
        this.name = name;
    }

    // getters & setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
