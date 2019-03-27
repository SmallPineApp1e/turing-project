package com.turing.turing.admin.service.impl;

import com.turing.turing.admin.service.AdminHistoryService;
import com.turing.turing.dao.HistoryMapper;
import com.turing.turing.entity.History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Jack
 * @date 2019-03-23-23:14
 */
@Service
public class AdminHistoryServiceImpl implements AdminHistoryService {

    @Autowired
    HistoryMapper historyMapper;

    @Override
    public boolean updateHistory(Integer hisId, History history) {

        history.setEditTime(new Date());
        int row = historyMapper.updateByPrimaryKey(history);
        return row != 0 ;

    }

    @Override
    public History getHistory() {

        List<History> histories = historyMapper.selectByExample(null);
        return histories.get(0);

    }

    @Override
    public History getHistoryById(Integer hisId) {

        History history = historyMapper.selectByPrimaryKey(hisId);
        return history;

    }
}
