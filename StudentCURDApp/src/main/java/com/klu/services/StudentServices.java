package com.klu.services;

import java.util.List;

import com.klu.model.Student;

public interface StudentServices {
  String getWelcomeMessage();
  Student createStudent(Student student);
  Student getStudentById(int id);
  List<Student>getAllStudents();
  Student updateStudent(int id,Student student);
  String deleteStudent(int id);
  List<Student>searchStudent(String name,String course);

}