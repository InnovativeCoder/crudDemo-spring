package dev.jerry.cruddemo.dao;

import dev.jerry.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String theLastName);

    void updateStudent(Student theStudent);

    void delete(Integer id);

    int deleteAll();
}
