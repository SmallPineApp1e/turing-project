package com.turing.turing.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.*;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(value = "团队成员")
public class Member {
    private Integer memberId;
    @NotBlank(message = "成员名字不能为空!")
    private String memberName;
    @Size(min=12,max=12,message="学号必须为12位!")
    private String memberStudentid;
    @Pattern(regexp =
            "^[1](([3][0-9])|([4][5,7,9])|([5][4,6,9])|([6][6])|([7][3,5,6,7,8])|([8][0-9])|([9][8,9]))[0-9]{8}$"
            , message = "手机号码格式有错!")
    private String phoneNumber;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private Date birthday;
    @NotBlank(message = "若尚未毕业, 则填暂无!")
    private String afterGraduated;
    @NotBlank(message = "专业班级不能为空!")
    private String major;
    @NotBlank(message = "学习方向不能为空!")
    private String memberDirect;
    @Size(min = 6, max = 16, message = "密码长度必须在6-16位之间!")
    private String memberPassword;
}