package com.turing.turing.admin.service;

import com.turing.turing.entity.History;

/**
 * @author Jack
 * @date 2019-03-23-23:10
 */
public interface AdminHistoryService {

    /**
     * 修改团队历史内容
     * @param hisId
     * @param history
     * @return
     */
    boolean updateHistory(Integer hisId, History history);

    /**
     * 获取团队历史内容
     * @return
     */
    History getHistory();

    /**
     * 根据id获取团队历史介绍(来到修改页面)
     * @param hisId
     * @return
     */
    History getHistoryById(Integer hisId);
}
