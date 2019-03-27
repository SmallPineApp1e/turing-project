package com.turing.turing.guest.controller;

import com.turing.turing.entity.History;
import com.turing.turing.guest.service.HistoryService;
import com.turing.turing.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jack
 * @date 2019-03-23-9:08
 */
@RestController
@RequestMapping(value = "guestHistory")
public class HistoryController {

    @Autowired
    HistoryService historyService;

    /**
     * 获取团队历史内容
     * @return
     */
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public Msg getHistory(){

        History history = historyService.getHistory();
        return Msg.success().add("history", history);

    }

}
