package com.turing.turing.entity;

import io.swagger.annotations.ApiModel;
import lombok.*;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(value = "收藏简历")
public class CollectResume {
    private Integer colResuId;
    @NotBlank(message = "必须填写名字!")
    private String colResuName;
    @Size(min=12, max=12, message="学号必须为12位")
    private String colResuStudentid;
    @Pattern(regexp =
            "^[1](([3][0-9])|([4][5,7,9])|([5][4,6,9])|([6][6])|([7][3,5,6,7,8])|([8][0-9])|([9][8,9]))[0-9]{8}$",
            message = "手机号码格式不正确!")
    private String colResuNumber;
    @NotBlank(message = "必须填写专业班级")
    private String colResuMajor;
    @NotBlank(message = "必须填写微信号/QQ号")
    private String colResuWechat;
    @NotBlank(message = "必须填写面试方向!")
    private String colResuDirect;
    @NotBlank(message = "必须填写自我评价!")
    private String colResuEvaluation;
    @NotBlank(message = "掌握技能若无,则填暂无!")
    private String colResuSkills;
    @NotBlank(message = "项目经验若无,则填暂无!")
    private String colResuExp;
    @NotBlank(message = "必须填写未来期望!")
    private String colResuExpect;
    @NotBlank(message = "其它优势若无, 则填暂无!")
    private String colResuOther;
}