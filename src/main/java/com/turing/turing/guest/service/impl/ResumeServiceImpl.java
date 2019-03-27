package com.turing.turing.guest.service.impl;

import com.turing.turing.dao.ResumeMapper;
import com.turing.turing.entity.Resume;
import com.turing.turing.guest.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Jack
 * @date 2019-03-23-8:54
 */
@Service
public class ResumeServiceImpl implements ResumeService {

    @Autowired
    ResumeMapper resumeMapper;

    @Override
    public boolean setResume(Resume resume) {

        int resumes = resumeMapper.insert(resume);
        return resumes != 0;

    }


}
