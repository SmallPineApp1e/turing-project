package com.turing.turing.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Inform {

    private Integer informId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    @NotBlank(message = "通知内容不能为空!")
    private String informInfo;
    @NotBlank(message = "发布人姓名不能为空!")
    private String username;

}