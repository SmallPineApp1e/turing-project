package com.turing.turing.guest.controller;

import com.turing.turing.entity.History;
import com.turing.turing.guest.service.HistoryService;
import com.turing.turing.util.Msg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jack
 * @date 2019-03-23-9:08
 */
@Api(tags = {"前台获取团队历史内容接口"})
@RestController
@RequestMapping(value = "/guestHistory")
public class HistoryController {

    @Autowired
    HistoryService historyService;

    @ApiOperation(value = "获取团队历史内容",notes = "正确码为200,错误码为100,出现错误时在extends中可以取出\"error\"的值")
    /**
     * 获取团队历史内容
     * @return
     */
    @RequestMapping(value = "",method = RequestMethod.GET)
    public Msg getHistory(){

        History history = historyService.getHistory();
        return history!=null ? Msg.success().add("history", history):Msg.fail().add("error", "尚未填写团队历史介绍");

    }

}
