package com.turing.turing.guest.controller;

import com.turing.turing.entity.Project;
import com.turing.turing.guest.service.ProjectService;
import com.turing.turing.util.Msg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Jack
 * @date 2019-03-23-8:40
 */
@Api(tags = {"前台获取所有团队项目信息"})
@RestController
@RequestMapping(value = "/guestProject")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @ApiOperation(value = "获取项目名称及图片", notes = "没有进行分页;" +
            "正确码为200,错误码为100,出现错误时在extends中可以取出\"error\"的值")
    /**
     * 获取项目名称及图片
     */
    @RequestMapping(value = "",method = RequestMethod.GET)
    public Msg getProjectsPhoto(){

        List<Project> projectsPhoto = projectService.getProjectsPhoto();
        return projectsPhoto.size()!=0?Msg.success().add("projectsPhoto", projectsPhoto):
                Msg.fail().add("error","没有查出任何项目!");

    }

}
