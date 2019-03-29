package com.turing.turing.entity;

import io.swagger.annotations.ApiModel;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(value = "收藏简历")
public class CollectResume {
    private Integer colResuId;

    private String colResuName;

    private String colResuNumber;

    private String colResuMajor;

    private String colResuWechat;

    private String colResuDirect;

    private String colResuEvaluation;

    private String colResuSkills;

    private String colResuExp;

    private String colResuExpect;

    private String colResuOther;

}