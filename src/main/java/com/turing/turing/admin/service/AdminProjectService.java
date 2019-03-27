package com.turing.turing.admin.service;

import com.turing.turing.entity.Project;

import java.util.List;

/**
 * @author Jack
 * @date 2019-03-23-16:56
 */
public interface AdminProjectService {
    /**
     * 添加项目
     * @param path 图片的路径
     * @param project 项目
     * @return
     */
   boolean addProject(String path, Project project);

    /**
     * 根据id删除一个项目
     * @param proId 项目id
     * @return
     */
   boolean deleteProject(Integer proId, String realPath);

    /**
     * 查询所有项目
     * @return
     */
    List<Project> getProject();

    /**
     * 根据id查询一个项目(来到删除页面)
     * @param proId
     * @return
     */
    Project getProjectById(Integer proId);
}
