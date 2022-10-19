package com.example.results.VO;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Student {
    @Id
    @Column(name="studentId")
    private Long studentId;
    @Column(name="studentName")
    private String studentName;


}
