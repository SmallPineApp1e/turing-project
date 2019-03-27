package com.turing.turing.guest.service;

import com.turing.turing.entity.Project;

import java.util.List;

/**
 * @author Jack
 * @date 2019-03-23-9:04
 */
public interface ProjectService {

    /**
     * 获取项目展示图片
     * @return
     */
    List<Project> getProjectsPhoto();

}
