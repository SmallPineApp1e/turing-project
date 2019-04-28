package com.turing.turing.guest.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.turing.turing.entity.Member;
import com.turing.turing.guest.service.MemberService;
import com.turing.turing.util.Msg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Jack
 * @date 2019-03-23-9:11
 */
@Api(tags = {"前台获取团队所有成员信息接口"})
@RestController
@CrossOrigin
@RequestMapping(value = "/guestMember")
public class MemberController {

    @Autowired
    MemberService memberService;


    @ApiOperation(value = "获取后台成员信息", notes = "没有返回成员的密码;采用了分页;每页显示5条数据,分页条连续显示3页")
    /**
     * 获取后台成员通讯录(分页)
     */
    @RequestMapping(value = "/backside", method = RequestMethod.GET)
    public Msg getBacksideMember(@RequestParam(value = "pn",defaultValue = "1") Integer pn){

        PageHelper.startPage(pn, 5);
        List<Member> members = memberService.getBacksideMembers();
        PageInfo pageInfo = new PageInfo(members, 3);
        return Msg.success().add("pageInfo", pageInfo);

    }
    @ApiOperation(value = "获取后台成员信息", notes = "没有返回成员的密码;采用了分页;每页显示5条数据,分页条连续显示3页")
    /**
     * 获取前端成员通讯录(分页)
     */
    @RequestMapping(value = "/frontside", method = RequestMethod.GET)
    public Msg getFrontSideMember(@RequestParam(value = "pn",defaultValue = "1") Integer pn){

        PageHelper.startPage(pn, 5);
        List<Member> members = memberService.getFrontsideMembers();
        PageInfo pageInfo = new PageInfo(members, 3);
        return Msg.success().add("pageInfo", pageInfo);

    }
    @ApiOperation(value = "获取后台成员信息", notes = "没有返回成员的密码;采用了分页;每页显示5条数据,分页条连续显示3页")
    /**
     * 获取人工智能成员通讯录(分页)
     */
    @RequestMapping(value = "/ai", method = RequestMethod.GET)
    public Msg getAiMember(@RequestParam(value = "pn",defaultValue = "1") Integer pn){
        List<Member> members = memberService.getAiMembers();
        PageHelper.startPage(pn, 5);
        PageInfo pageInfo = new PageInfo(members, 3);
        return Msg.success().add("pageInfo", pageInfo);

    }

}
