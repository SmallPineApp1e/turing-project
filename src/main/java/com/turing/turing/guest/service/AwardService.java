package com.turing.turing.guest.service;

import com.turing.turing.entity.Award;

import java.util.List;

/**
 * @author Jack
 * @date 2019-03-23-8:43
 */

public interface AwardService {

    /**
     * 获取团队获奖信息
     * @return
     */
    List<Award> getAward();


}
