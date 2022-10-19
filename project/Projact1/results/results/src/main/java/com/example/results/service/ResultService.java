package com.example.results.service;

import com.example.results.VO.ResponseTemplateVO;
import com.example.results.VO.Student;
import com.example.results.entity.Result;
import com.example.results.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ResultService {
    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Result saveResult(Result result) {
        return resultRepository.save(result);
    }

    public ResponseTemplateVO getStudentWithId(Long studentId) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Result result = resultRepository.findByStudentId(studentId);
        Student student = restTemplate.getForObject("http://localhost:3004/students/"+result.getStudentId(),Student.class);
        vo.setResult(result);
        vo.setStudent(student);
        return vo;
    }

    public void deleteResultById(Long studentId) {
    }

    public Result updateStudentById(Long studentId) {
        return resultRepository.findByStudentId(studentId);

    }

    public List<Result> getAllResults() {
        return resultRepository.findAll();
    }
}
