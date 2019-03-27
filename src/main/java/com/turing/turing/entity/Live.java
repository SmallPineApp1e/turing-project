package com.turing.turing.entity;

import lombok.*;
import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Live {

    private Integer liveId;
    @NotBlank(message = "必须填写本次活动名称")
    private String liveName;

    private List<Photo> photo;

}