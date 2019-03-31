package com.turing.turing.admin.service;

import com.turing.turing.entity.CollectResume;

import java.util.List;

/**
 * @author Jack
 * @date 2019-03-30-19:02
 */
public interface AdminCollectResumeService {

    /**
     * 获取所有收藏的简历
     * @return
     */
    List<CollectResume> getCollectResumes();

    /**
     * 面试通过
     * @param resuName
     * @param resuMajor
     * @param resuNumber
     * @param resuDirect
     * @return
     */
    boolean setPassInterview(String resuName, String resuMajor, String resuNumber, String resuDirect);

    /**
     * 根据名字搜寻第一轮通过的简历
     * @param resuName
     * @return
     */
    List<CollectResume> getResumeByName(String resuName);

    /**
     * 查询某一份一轮通过简历的详情
     * @param colResuId
     * @return
     */
    CollectResume getColResumeById(Integer colResuId);

    /**
     * 删除不通过的简历
     * @param colResuId
     * @return
     */
    boolean deleteResume(Integer colResuId);
}
