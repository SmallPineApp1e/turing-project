package com.turing.turing.guest.controller;

import com.turing.turing.entity.Inform;
import com.turing.turing.guest.service.InformService;
import com.turing.turing.util.Msg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jack
 * @date 2019-03-23-9:06
 */
@Api(tags = {"前台获取最新通告接口"})
@RestController
@RequestMapping(value = "/guestInform")
public class InformController {

    @Autowired
    InformService informService;

    @ApiOperation(value = "获取最新通告", notes = "username为发布通告的成员名字")
    /**
     * 获取最新通告
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Msg getInform(){

        Inform inform = informService.getInform();
        return Msg.success().add("inform",inform);

    }

}
