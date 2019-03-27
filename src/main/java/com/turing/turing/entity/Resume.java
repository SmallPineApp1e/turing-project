package com.turing.turing.entity;

import lombok.*;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Resume {
    private Integer resuId;
    @NotBlank(message = "必须填写名字!")
    private String resuName;
    @Pattern(regexp =
            "^[1](([3][0-9])|([4][5,7,9])|([5][4,6,9])|([6][6])|([7][3,5,6,7,8])|([8][0-9])|([9][8,9]))[0-9]{8}$",
            message = "手机号码格式不正确!")
    private String resuNumber;
    @NotBlank(message = "必须填写专业班级")
    private String resuMajor;
    @NotBlank(message = "必须填写微信号/QQ号")
    private String resuWechat;
    @NotBlank(message = "必须填写面试方向!")
    private String resuDirect;
    @NotBlank(message = "必须填写自我评价!")
    private String resuEvaluation;
    @NotBlank(message = "掌握技能若无,则填暂无!")
    private String resuSkills;
    @NotBlank(message = "项目经验若无,则填暂无!")
    private String resuExp;
    @NotBlank(message = "必须填写未来期望!")
    private String resuExpect;
    @NotBlank(message = "其它优势若无, 则填暂无!")
    private String resuOther;
}