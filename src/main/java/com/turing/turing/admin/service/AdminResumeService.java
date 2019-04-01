package com.turing.turing.admin.service;

import com.turing.turing.entity.Resume;

import java.util.List;

/**
 * @author Jack
 * @date 2019-03-23-23:00
 */
public interface AdminResumeService {

    /**
     * 根据id删除简历
     * @param resuId
     * @return
     */
    boolean deleteResume(Integer resuId);

    /**
     * 获得所有简历
     * @return
     */
    List<Resume> getResumes();

    /**
     * 根据名字获取简历
     * @param resuName 名字
     * @return
     */
    List<Resume> getResumeByName(String resuName);

    /**
     * 收藏简历
     * @return
     */
    boolean collectResume(Integer resuId);

    /**
     * 根据Id查询简历
     * @param resuId
     * @return
     */
    Resume getResumeById(Integer resuId);


}
