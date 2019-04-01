package com.turing.turing.admin.service.impl;

import com.turing.turing.admin.service.AdminResumeService;
import com.turing.turing.dao.CollectResumeMapper;
import com.turing.turing.dao.MemberMapper;
import com.turing.turing.dao.ResumeMapper;
import com.turing.turing.entity.CollectResume;
import com.turing.turing.entity.Resume;
import com.turing.turing.entity.ResumeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Jack
 * @date 2019-03-23-23:00
 */
@Service
@Transactional
public class AdminResumeServiceImpl implements AdminResumeService {

    @Autowired
    ResumeMapper resumeMapper;
    @Autowired
    CollectResumeMapper collectResumeMapper;
    @Autowired
    MemberMapper memberMapper;

    @Override
    public boolean deleteResume(Integer resuId) {

        int row = resumeMapper.deleteByPrimaryKey(resuId);
        return row != 0;

    }

    @Override
    public List<Resume> getResumes() {
        List<Resume> resumes = resumeMapper.selectByExample(null);
        return resumes;
    }

    @Override
    public List<Resume> getResumeByName(String resuName) {

        ResumeExample resumeExample = new ResumeExample();
        resumeExample.createCriteria().andResuNameEqualTo(resuName);
        List<Resume> resumes = resumeMapper.selectByExample(resumeExample);
        return resumes;

    }

    @Override
    public boolean collectResume(Integer resuId) {
        Resume resume = resumeMapper.selectByPrimaryKey(resuId);
        if(resume==null){
            return false;
        }
        //插入到收藏简历表中
        int collect_row = collectResumeMapper.insert(new CollectResume(resume.getResuId(), resume.getResuName(),
                resume.getResuStudentid(),resume.getResuNumber(),resume.getResuMajor(),resume.getResuWechat(),
                resume.getResuDirect(),resume.getResuEvaluation(),resume.getResuSkills(),resume.getResuExp(),
                resume.getResuExpect(),resume.getResuOther()));
        //删除原来简历表当中的这个人
        int row = resumeMapper.deleteByPrimaryKey(resuId);
        return row != 0 && collect_row != 0;

    }

    @Override
    public Resume getResumeById(Integer resuId) {

        Resume resume = resumeMapper.selectByPrimaryKey(resuId);
        return resume;

    }


}
