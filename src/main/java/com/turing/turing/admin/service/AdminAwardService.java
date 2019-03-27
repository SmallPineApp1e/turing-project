package com.turing.turing.admin.service;

import com.turing.turing.entity.Award;

import java.text.ParseException;
import java.util.List;

/**
 * @author Jack
 * @date 2019-03-23-11:15
 */
public interface AdminAwardService {
    /**
     * 添加获奖情况
     * @param award
     * @return
     * @throws ParseException
     */
    boolean addAward(Award award);

    /**
     * 修改获奖情况
     * @param award
     * @param awardId
     * @return
     */
    boolean updateAward(Award award,Integer awardId);

    /**
     * 根据id删除获奖情况
     * @param awardId
     * @return
     */
    boolean deleteAward(Integer awardId);

    /**
     * 获取所有奖项
     * @return
     */
    List<Award> getAwards();

    /**
     * 根据id获取其中一个奖项
     * @param awardId
     * @return
     */
    Award getAwardById(Integer awardId);
}
