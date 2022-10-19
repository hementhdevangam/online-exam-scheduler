package com.example.studentdata.controller;

import com.example.studentdata.model.Student;
import com.example.studentdata.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/")
    public Student saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }
    @GetMapping("/{id}")
    public Student findStudentById(@PathVariable("id") Long studentId){
        return studentService.findStudentById(studentId);
    }
    @PutMapping("/{id}")
    public Student updateStudentById(@PathVariable("id") Long studentId,@RequestBody Student student){
        Optional<Student> studentData = Optional.ofNullable(studentService.findStudentById(studentId));
        if(studentData.isPresent()){
            Student _student = studentData.get();
            _student.setStudentName(student.getStudentName());
            return studentService.saveStudent(_student);
        }
        return studentService(HttpStatus.NOT_FOUND);
    }

    private Student studentService(HttpStatus notFound) {
        return studentService(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}")
    private void deleteStudentById(@PathVariable("id") Long studentId){
        studentService.deleteStudentById(studentId);
    }
    @GetMapping("/")
    public List<Student> getAllStudents(){
        List<Student> students = new ArrayList<Student>();
        return studentService.getAllStudents();
    }
}
