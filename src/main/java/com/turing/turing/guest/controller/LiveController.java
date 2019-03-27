package com.turing.turing.guest.controller;

import com.turing.turing.entity.Live;
import com.turing.turing.guest.service.LiveService;
import com.turing.turing.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Jack
 * @date 2019-03-23-9:00
 */
@RestController
@RequestMapping(value = "/guestLive")
public class LiveController {

    @Autowired
    LiveService liveService;

    /**
     * 获取团队日常活动及照片
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Msg getLive(){

        List<Live> live = liveService.getLive();
        return Msg.success().add("live",live);

    }

}