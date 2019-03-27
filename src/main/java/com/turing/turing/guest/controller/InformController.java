package com.turing.turing.guest.controller;

import com.turing.turing.guest.service.InformService;
import com.turing.turing.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jack
 * @date 2019-03-23-9:06
 */
@RestController
@RequestMapping(value = "/guestInform")
public class InformController {

    @Autowired
    InformService informService;


    /**
     * 获取最新通告
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Msg getInform(){

        return Msg.success().add("inform",informService.getInform());

    }

}
