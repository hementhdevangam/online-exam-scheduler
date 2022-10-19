package com.example.studentdata.repository;

import com.example.studentdata.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
    Student findByStudentId(Long studentId);
}
