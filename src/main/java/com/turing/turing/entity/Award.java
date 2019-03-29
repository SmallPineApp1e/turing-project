package com.turing.turing.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.*;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ApiModel(value = "团队奖项")
public class Award {
    private Integer awardId;
    @NotBlank(message = "必须填写获奖名字!")
        private String awardName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date awardTime;
    @NotBlank(message = "必须填写发布人名字!")
    private String awardUsername;

}