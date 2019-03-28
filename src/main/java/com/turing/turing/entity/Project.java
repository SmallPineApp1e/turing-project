package com.turing.turing.entity;

import lombok.*;
import org.hibernate.validator.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Project {
    private Integer proId;
    @NotBlank(message = "必须填写项目名字!")
    private String proName;
    @NotBlank(message = "必须填写发布人名字!")
    private String proUsername;

    private Photo photo;

}