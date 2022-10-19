package com.example.examdetails.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="students")
public class Student {
    @Id
    private Long studentId;

    @Column(name="studentName")
    private String studentName;

    @Column(name="location")
    private String location;

    @Column(name="centerName")
    private String centerName;

    @Column(name="startTime")
    private String startTime;

    @Column(name="endTime")
    private String endTime;

    @Column(name="roomNo")
    private Long roomNo;

    @Column(name="sittingNo")
    private String sittingNo;

    public Student(){

    }

    public Student(Long studentId, String studentName, String location, String centerName, String startTime, String endTime, Long roomNo, String sittingNo) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.location = location;
        this.centerName = centerName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.roomNo = roomNo;
        this.sittingNo = sittingNo;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Long getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(Long roomNo) {
        this.roomNo = roomNo;
    }

    public String getSittingNo() {
        return sittingNo;
    }

    public void setSittingNo(String sittingNo) {
        this.sittingNo = sittingNo;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", location='" + location + '\'' +
                ", centerName='" + centerName + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", roomNo=" + roomNo +
                ", sittingNo='" + sittingNo + '\'' +
                '}';
    }
}
