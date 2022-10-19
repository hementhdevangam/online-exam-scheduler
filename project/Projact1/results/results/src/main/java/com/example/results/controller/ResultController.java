package com.example.results.controller;

import com.example.results.VO.ResponseTemplateVO;
import com.example.results.entity.Result;
import com.example.results.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/results")
public class ResultController {
    @Autowired
    private ResultService resultService;

    @PostMapping("/")
    public Result saveResult(@RequestBody Result result) {
        return resultService.saveResult(result);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getStudentWithId(@PathVariable("id") Long studentId){
        return resultService.getStudentWithId(studentId);
    }
    @PutMapping("/{id}")
    public Result updateStudentById(@PathVariable("id") Long studentId, @RequestBody Result result){
        Optional<Result>  resData=Optional.ofNullable(resultService.updateStudentById(studentId));
        if(resData.isPresent()){
            Result _result = resData.get();
            _result.setJava(result.getJava());
            _result.setKotlin(result.getKotlin());
            _result.setMysql(result.getMysql());
            return resultService.saveResult(_result);
        }
        return resultService(HttpStatus.NOT_FOUND);
    }

    private Result resultService(HttpStatus notFound) {
        return resultService(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}")
    public void deleteResultById(@PathVariable("id") Long studentId){
        resultService.deleteResultById(studentId);
    }
    @GetMapping("/")
    public List<Result> getAllResults(){
        List<Result> results = new ArrayList<>();
        return resultService.getAllResults();
    }
}
