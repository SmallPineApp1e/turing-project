package com.turing.turing.guest.service.impl;

import com.turing.turing.dao.HistoryMapper;
import com.turing.turing.entity.History;
import com.turing.turing.guest.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Jack
 * @date 2019-03-23-9:09
 */
@Service
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    HistoryMapper historyMapper;

    @Override
    public History getHistory(){

        return historyMapper.selectByPrimaryKey(1);

    }

}
