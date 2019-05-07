package com.turing.turing.admin.service.impl;

import com.turing.turing.admin.service.AdminProjectService;
import com.turing.turing.dao.PhotoMapper;
import com.turing.turing.dao.ProjectMapper;
import com.turing.turing.entity.Photo;
import com.turing.turing.entity.PhotoExample;
import com.turing.turing.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

/**
 * @author Jack
 * @date 2019-03-23-16:56
 */
@Service
public class AdminProjectServiceImpl implements AdminProjectService {

    @Autowired
    ProjectMapper projectMapper;
    @Autowired
    PhotoMapper photoMapper;

    @Override
    public boolean addProject(String path, Project project) {

        Integer isProjectSuccess = projectMapper.insert(project);
        Photo photo = new Photo(null, path, project.getProName());
        Integer isPhotoSuccess = photoMapper.insert(photo);
        return (isProjectSuccess != 0 && isPhotoSuccess != 0);

    }

    @Override
    public boolean deleteProject(Integer proId, String photoLoc) {

        Project project = projectMapper.selectByPrimaryKey(proId);
        String projectName = project.getProName();
        //删除图片
        PhotoExample photoExample = new PhotoExample();
        photoExample.createCriteria().andPhotoTypeEqualTo(projectName);
        List<Photo> photos = photoMapper.selectByExample(photoExample);
        for (Photo photo :
                photos) {
            String fileName = photo.getPhotoLoc().substring(photo.getPhotoLoc().lastIndexOf("/")+1);
            //删除本地图片
          new File(photoLoc + fileName).delete();
        }
        int deletePhoto = photoMapper.deleteByExample(photoExample);
        //删除项目
        int deleteProject = projectMapper.deleteByPrimaryKey(proId);
        return deletePhoto != 0 && deleteProject != 0;


    }

    @Override
    public List<Project> getProject() {

        return projectMapper.selectByExampleWithPhoto(null);

    }

    @Override
    public Project getProjectById(Integer proId) {

        return projectMapper.selectByPrimaryKeyWithPhoto(proId);

    }
}
