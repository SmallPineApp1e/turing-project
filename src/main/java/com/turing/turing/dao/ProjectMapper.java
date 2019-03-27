package com.turing.turing.dao;

import com.turing.turing.entity.Project;
import com.turing.turing.entity.ProjectExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectMapper {
    long countByExample(ProjectExample example);

    int deleteByExample(ProjectExample example);

    int deleteByPrimaryKey(Integer proId);

    int insert(Project record);

    int insertSelective(Project record);

    List<Project> selectByExample(ProjectExample example);

    Project selectByPrimaryKey(Integer proId);

    List<Project> selectByExampleWithPhoto(ProjectExample example);

    Project selectByPrimaryKeyWithPhoto(Integer proId);

    int updateByExampleSelective(@Param("record") Project record, @Param("example") ProjectExample example);

    int updateByExample(@Param("record") Project record, @Param("example") ProjectExample example);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);
}