package com.turing.turing.entity;

import io.swagger.annotations.ApiModel;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(value = "照片")
public class Photo {
    private Integer photoId;
    //图片存储路径
    private String photoLoc;
    //图片的类型
    private String photoType;

}