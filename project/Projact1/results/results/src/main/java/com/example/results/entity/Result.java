package com.example.results.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "results")
public class Result {
    @Id
    @Column(name="studentId")
    private Long studentId;

    @Column(name="java")
    private Long java;

    @Column(name="kotlin")
    private Long kotlin;

    @Column(name="mysql")
    private Long mysql;



    public Result(Long studentId, Long java, Long kotlin, Long mysql) {
        this.studentId = studentId;
        this.java = java;
        this.kotlin = kotlin;
        this.mysql = mysql;
    }
    public Result(){

    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getJava() {
        return java;
    }

    public void setJava(Long java) {
        this.java = java;
    }

    public Long getKotlin() {
        return kotlin;
    }

    public void setKotlin(Long kotlin) {
        this.kotlin = kotlin;
    }

    public Long getMysql() {
        return mysql;
    }

    public void setMysql(Long mysql) {
        this.mysql = mysql;
    }



    @Override
    public String toString() {

        return "Result{" +
                "studentId=" + studentId +
                ", java=" + java +
                ", kotlin=" + kotlin +
                ", mysql=" + mysql +
                '}';
    }
}
