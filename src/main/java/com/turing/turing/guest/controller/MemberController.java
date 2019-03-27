package com.turing.turing.guest.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.turing.turing.entity.Member;
import com.turing.turing.guest.service.MemberService;
import com.turing.turing.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Jack
 * @date 2019-03-23-9:11
 */
@RestController
@RequestMapping(value = "/guestMember")
public class MemberController {

    @Autowired
    MemberService memberService;

    /**
     * 获取成员通讯录(分页)
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Msg getMember(@RequestParam(value = "pn",defaultValue = "1") Integer pn){

        PageHelper.startPage(pn, 5);
        List<Member> members = memberService.getMembers();
        PageInfo pageInfo = new PageInfo(members, 3);
        return Msg.success().add("pageInfo", pageInfo);

    }

}
