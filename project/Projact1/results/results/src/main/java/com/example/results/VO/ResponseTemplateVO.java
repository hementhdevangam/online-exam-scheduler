package com.example.results.VO;

import com.example.results.entity.Result;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ResponseTemplateVO {
    private Result result;
    private Student student;


}
