package com.turing.turing.guest.service.impl;

import com.turing.turing.dao.AwardMapper;
import com.turing.turing.entity.Award;
import com.turing.turing.guest.service.AwardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jack
 * @date 2019-03-23-8:44
 */
@Service
public class AwardServiceImpl implements AwardService {

    @Autowired
    AwardMapper awardMapper;

    @Override
    public List<Award> getAward() {

        List<Award> awards = awardMapper.selectByExampleWithPhoto(null);
        return awards;

    }
}
