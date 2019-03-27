package com.turing.turing.guest.service.impl;

import com.turing.turing.dao.ProjectMapper;
import com.turing.turing.entity.Project;
import com.turing.turing.guest.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jack
 * @date 2019-03-23-9:04
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectMapper projectMapper;

    @Override
    public List<Project> getProjectsPhoto() {

        List<Project> projects = projectMapper.selectByExampleWithPhoto(null);
        return projects;

    }

}
