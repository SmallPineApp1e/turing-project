package com.turing.turing.admin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.turing.turing.admin.service.AdminMemberService;
import com.turing.turing.entity.Member;
import com.turing.turing.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Jack
 * @date 2019-03-23-11:05
 */
@RestController
@RequestMapping(value = "/adminMember")
public class AdminMemberController {

    @Autowired
    AdminMemberService adminMemberService;

    /**
     * 添加成员
     * @param member 自动封装实体类
     * @return Msg消息
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Msg addMemeber(@ModelAttribute(value = "Member")@Valid Member member){

        boolean isSuccess = adminMemberService.addMember(member);
        if (isSuccess) {
            return Msg.success().add("Info", "添加成功");
        }else{
            return Msg.fail().add("Info", "添加失败!发生无法预知的错误!程序猿正在路上!");
        }

    }

    /**
     * 根据id删除成员
     * @param memberId 成员id
     * @return
     */
    @RequestMapping(value = "/{memberId}", method = RequestMethod.DELETE)
    public Msg deleteMember(@PathVariable Integer memberId){

        boolean isSuccess = adminMemberService.deleteMember(memberId);
        return isSuccess ? Msg.success():Msg.fail().add("error", "数据库无此成员信息");

    }

    /**
     * 获取所有团队成员(分页)
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Msg getAllMembers(@RequestParam(value = "pn", defaultValue = "1")Integer pn){
        PageHelper.startPage(pn, 5);
        List<Member> members = adminMemberService.getMembers();
        PageInfo pageInfo = new PageInfo(members, 3);
        return Msg.success().add("pageInfo", pageInfo);

    }

    /**
     * 修改成员信息
     * @param member
     * @param memberId
     * @return
     */
    @RequestMapping(value = "/{memberId}", method = RequestMethod.PUT)
    public Msg updateMember(@ModelAttribute(value = "member")@Valid Member member, BindingResult result,
                            @PathVariable Integer memberId){

        if (result.hasErrors()) {
            Msg msg = new Msg();
            msg.setCode(200);
            msg.setMsg("修改失败");
            result.getAllErrors().forEach(objectError -> msg.add(objectError.getCode()
                    , objectError.getDefaultMessage()));
            return msg;
        }else{
            boolean isSuccess = adminMemberService.updateMember(member, memberId);
            return isSuccess ? Msg.success() : Msg.fail();
        }

    }

    /**
     * 根据id查询某个成员(来到修改删除页面)
     * @return
     */
    @RequestMapping(value = "/{memberId}", method = RequestMethod.GET)
    public Msg getMemberById(@PathVariable Integer memberId){

        Member member = adminMemberService.getMemberById(memberId);
        return Msg.success().add("member", member);

    }


}
