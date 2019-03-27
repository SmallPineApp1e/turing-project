package com.turing.turing.entity;

import lombok.*;
import org.hibernate.validator.constraints.NotBlank;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Project {

    private Integer proId;
    @NotBlank(message = "项目名字不能为空!")
    private String proName;

    private Photo photo;

}