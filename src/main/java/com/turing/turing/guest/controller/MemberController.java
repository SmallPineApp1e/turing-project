package com.turing.turing.guest.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.turing.turing.entity.Member;
import com.turing.turing.guest.service.MemberService;
import com.turing.turing.util.Msg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Jack
 * @date 2019-03-23-9:11
 */
@Api(tags = {"前台获取团队所有成员信息接口"})
@RestController
@RequestMapping(value = "/guestMember")
public class MemberController {

    @Autowired
    MemberService memberService;

    @ApiOperation(value = "获取成员信息", notes = "没有返回成员的密码;采用了分页;每页显示5条数据,分页条连续显示3页")
    /**
     * 获取成员通讯录(分页)
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Msg getMember(@RequestParam(value = "pn",defaultValue = "1") Integer pn){

        PageHelper.startPage(pn, 5);
        List<Member> members = memberService.getMembers();
        PageInfo pageInfo = new PageInfo(members, 3);
        return Msg.success().add("pageInfo", pageInfo);

    }

}
