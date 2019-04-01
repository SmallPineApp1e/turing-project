package com.turing.turing.admin.service.impl;

import com.turing.turing.admin.service.AdminCollectResumeService;
import com.turing.turing.dao.CollectResumeMapper;
import com.turing.turing.dao.MemberMapper;
import com.turing.turing.entity.CollectResume;
import com.turing.turing.entity.CollectResumeExample;
import com.turing.turing.entity.Member;
import com.turing.turing.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author Jack
 * @date 2019-03-30-19:02
 */
@Service
@Transactional
public class AdminCollectResumeServiceImpl implements AdminCollectResumeService {

    @Autowired
    CollectResumeMapper collectResumeMapper;

    @Autowired
    MemberMapper memberMapper;

    @Override
    public List<CollectResume> getCollectResumes() {

        List<CollectResume> collectResumes = collectResumeMapper.selectByExample(null);
        return collectResumes;

    }

    @Override
    public boolean setPassInterview(String resuName, String resuMajor,String colResuStudentId,
                                    String resuNumber, String resuDirect) {
        //新添加成员
        int add_Row = memberMapper.insert(new Member(null, resuName,colResuStudentId, resuNumber, new Date(),
                "暂无", resuMajor, resuDirect, MD5Util.getHexPassword("123123")));
        //删除收藏简历表
        CollectResumeExample collectResumeExample = new CollectResumeExample();
        collectResumeExample.createCriteria().andColResuNameEqualTo(resuName);
        int delete_Row = collectResumeMapper.deleteByExample(collectResumeExample);

        return add_Row != 0 && delete_Row != 0;

    }

    @Override
    public List<CollectResume> getResumeByName(String resuName) {

        CollectResumeExample collectResumeExample = new CollectResumeExample();
        collectResumeExample.createCriteria().andColResuNameEqualTo(resuName);
        List<CollectResume> collectResumes = collectResumeMapper.selectByExample(collectResumeExample);
        return collectResumes;

    }

    @Override
    public CollectResume getColResumeById(Integer colResuId) {

        CollectResume collectResume = collectResumeMapper.selectByPrimaryKey(colResuId);
        return collectResume;

    }

    @Override
    public boolean deleteResume(Integer colResuId) {

        int row = collectResumeMapper.deleteByPrimaryKey(colResuId);
        return row != 0;

    }

}
