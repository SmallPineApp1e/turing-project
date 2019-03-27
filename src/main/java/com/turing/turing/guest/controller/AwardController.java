package com.turing.turing.guest.controller;

import com.turing.turing.entity.Award;
import com.turing.turing.guest.service.AwardService;
import com.turing.turing.util.Msg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Jack
 * @date 2019-03-23-8:41
 */
@Api("奖项展示")
@RestController
@RequestMapping(value = "/guestAward/")
public class AwardController {

    @Autowired
    AwardService awardService;

    @ApiOperation("")
    /**
     * 获取团队获奖信息
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Msg getAward(){

        List<Award> award = awardService.getAward();
        return Msg.success().add("award", award);

    }

}
