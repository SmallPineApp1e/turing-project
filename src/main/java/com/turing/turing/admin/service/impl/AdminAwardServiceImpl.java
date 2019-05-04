package com.turing.turing.admin.service.impl;

import com.turing.turing.admin.service.AdminAwardService;
import com.turing.turing.dao.AwardMapper;
import com.turing.turing.entity.Award;
import com.turing.turing.entity.AwardExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jack
 * @date 2019-03-23-11:16
 */
@Service
public class AdminAwardServiceImpl implements AdminAwardService {

    @Autowired
    AwardMapper awardMapper;

    @Override
    public boolean addAward(Award award) {

        int isSuccess = awardMapper.insert(award);
        return isSuccess != 0;

    }

    @Override
    public boolean updateAward(Award award, Integer awardId) {

        AwardExample awardExample = new AwardExample();
        awardExample.createCriteria().andAwardIdEqualTo(awardId);
        return awardMapper.updateByExample(award, awardExample) != 0;

    }

    @Override
    public boolean deleteAward(Integer awardId) {

        int isSuccess = awardMapper.deleteByPrimaryKey(awardId);
        return isSuccess != 0;

    }

    @Override
    public List<Award> getAwards() {

        AwardExample awardExample = new AwardExample();
        awardExample.setOrderByClause("award_time desc");
        List<Award> awards = awardMapper.selectByExample(awardExample);
        return awards;

    }

    @Override
    public Award getAwardById(Integer awardId) {

        Award award = awardMapper.selectByPrimaryKey(awardId);
        return award;

    }
}
