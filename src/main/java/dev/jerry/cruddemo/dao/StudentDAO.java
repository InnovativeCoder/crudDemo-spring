package dev.jerry.cruddemo.dao;

import dev.jerry.cruddemo.entity.Student;

public interface StudentDAO {
    void save(Student theStudent);

    Student findById(Integer id);
}
