package com.turing.turing.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Jack
 * @date 2019-04-27-8:50
 */
@Controller
public class PageController {

    @RequestMapping("/index")
    public String pageIndex(){
        return "index";
    }

    @RequestMapping("/about")
    public String pageAbout(){
        return "about";
    }

    @RequestMapping("/login")
    public String pageLogin(){
        return "login";
    }

    @RequestMapping("/backside")
    public String pageBackside(){
        return "backside";
    }

    @RequestMapping("/frontside")
    public String pageFrontside(){
        return "frontside";
    }

    @RequestMapping("/ai")
    public String pageAi(){
        return "ai";
    }

    @RequestMapping("/postResume")
    public String pagePostResume(){
        return "postResume";
    }

    @RequestMapping("/backStage")
    public String pageBackStage(){return "backStage";}

}
