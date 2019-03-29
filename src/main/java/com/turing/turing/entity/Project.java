package com.turing.turing.entity;

import io.swagger.annotations.ApiModel;
import lombok.*;
import org.hibernate.validator.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@ApiModel(value = "团队项目")
public class Project {
    private Integer proId;
    @NotBlank(message = "必须填写项目名字!")
    private String proName;
    @NotBlank(message = "必须填写发布人名字!")
    private String proUsername;

    private Photo photo;

}