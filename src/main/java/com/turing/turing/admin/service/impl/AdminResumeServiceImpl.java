package com.turing.turing.admin.service.impl;

import com.turing.turing.admin.service.AdminResumeService;
import com.turing.turing.dao.CollectResumeMapper;
import com.turing.turing.dao.MemberMapper;
import com.turing.turing.dao.ResumeMapper;
import com.turing.turing.entity.*;
import com.turing.turing.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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
    public boolean collectResume(Resume resume) {
        //插入到收藏简历表中
        int collect_row = collectResumeMapper.insert(
                new CollectResume(null, resume.getResuName(), resume.getResuNumber(),
                resume.getResuMajor(), resume.getResuWechat(), resume.getResuDirect(), resume.getResuEvaluation(),
                resume.getResuSkills(), resume.getResuExp(), resume.getResuExpect(), resume.getResuOther()));
        //删除原来简历表当中的这个人
        int row = resumeMapper.deleteByPrimaryKey(resume.getResuId());
        return row != 0 && collect_row != 0;

    }

    @Override
    public Resume getResumeById(Integer resuId) {

        Resume resume = resumeMapper.selectByPrimaryKey(resuId);
        return resume;

    }

    @Override
    public boolean setPassInterview(String resuName, String resuMajor, String resuNumber, String resuDirect) {
        //新添加成员
        int add_Row = memberMapper.insert(new Member(null, resuName, resuNumber, new Date(),
                "暂无", resuMajor, resuDirect, MD5Util.getHexPassword("123456")));
        //删除收藏简历表
        CollectResumeExample collectResumeExample = new CollectResumeExample();
        collectResumeExample.createCriteria().andColResuNameEqualTo(resuName);
        int delete_Row = collectResumeMapper.deleteByExample(collectResumeExample);

        return add_Row != 0 && delete_Row != 0;

    }
}
