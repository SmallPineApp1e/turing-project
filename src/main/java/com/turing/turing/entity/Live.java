package com.turing.turing.entity;

import io.swagger.annotations.ApiModel;
import lombok.*;
import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@ApiModel(value = "团队生活")
public class Live {
    private Integer liveId;
    @NotBlank(message = "必须填写生活名字!")
    private String liveName;
    @NotBlank(message = "必须填写发布人名字!")
    private String liveUsername;

    private List<Photo> photos;
}