package com.turing.turing.entity;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Photo {
    private Integer photoId;
    //图片存储路径
    private String photoLoc;
    //图片的类型
    private String photoType;

}