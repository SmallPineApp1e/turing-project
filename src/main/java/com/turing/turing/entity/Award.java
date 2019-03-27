package com.turing.turing.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Award {

    private Integer awardId;
    @NotBlank(message = "奖项名字不能为空!")
    private String awardName;
    @NotNull(message = "获奖时间不能为空!")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date awardTime;

    private Photo photo;

}