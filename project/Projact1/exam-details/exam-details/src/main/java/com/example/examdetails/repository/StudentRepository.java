package com.example.examdetails.repository;

import com.example.examdetails.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    Student findByStudentId(Long studentId);
}
