package com.turing.turing.guest.service;

import com.turing.turing.entity.Resume;

/**
 * @author Jack
 * @date 2019-03-23-8:54
 */
public interface ResumeService {

    /**
     * 获取所有简历
     * @return
     */
    boolean setResume(Resume resume);

}
