package com.example.examdetails.controller;

import com.example.examdetails.model.Student;
import com.example.examdetails.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins="*")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/")
    public Student saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }
    @GetMapping("/{id}")
    public Student findStudentById(@PathVariable("id")Long studentId){
        return studentService.findStudentById(studentId);
    }
    @PutMapping("/{id}")
    public Student updateStudentById(@PathVariable("id") Long studentId, @RequestBody Student student){
        Optional<Student> studData = Optional.ofNullable(studentService.findStudentById(studentId));
        if(studData.isPresent()) {
            Student _student = studData.get();
            _student.setStudentName(student.getStudentName());
            _student.setLocation(student.getLocation());
            _student.setCenterName(student.getCenterName());
            _student.setStartTime(student.getStartTime());
            _student.setEndTime(student.getEndTime());
            _student.setRoomNo(student.getRoomNo());
            _student.setSittingNo(student.getSittingNo());
            return studentService.saveStudent(_student);
        }
        return studentService(HttpStatus.NOT_FOUND);
    }

    private Student studentService(HttpStatus notFound) {
        return studentService(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable("id") Long studentId){
        studentService.deleteStudentById(studentId);
    }

    @GetMapping("/")
    public List<Student> getAllStudents(){
        List<Student> students = new ArrayList<Student>();
        return studentService.getAllStudents();
    }
}
