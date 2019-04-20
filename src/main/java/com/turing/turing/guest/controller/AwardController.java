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
@Api(tags = {"前台获取所有奖项信息接口"})
@RestController
@RequestMapping(value = "/guestAward")
public class AwardController {


    @Autowired
    AwardService awardService;

    @ApiOperation(value = "获取所有奖项",notes ="正确码为200,错误码为100,出现错误时在extends中可以取出\"error\"的值;" +
            "awardUsername属性为上传人名称")
    /**
     * 获取团队获奖信息
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Msg getAward(){

        List<Award> award = awardService.getAward();
        return award.size() != 0 ? Msg.success().add("award", award) : Msg.fail().add("error", "没有上传任何获奖信息!");

    }

}
