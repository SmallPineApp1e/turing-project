package com.turing.turing.admin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.turing.turing.admin.service.AdminMemberService;
import com.turing.turing.entity.Member;
import com.turing.turing.util.Msg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Jack
 * @date 2019-03-23-11:05
 */
@Api(tags = {"后台团队成员管理接口"})
@RestController
@RequestMapping(value = "/adminMember")
public class AdminMemberController {

    @Autowired
    AdminMemberService adminMemberService;

    @ApiOperation(value = "添加成员",notes = "除id外都为必填选项;只能在简历通过后进行添加,不能让成员自己手动输入添加;" +
            "正确码为200,错误码为100,出现错误时在extends中可以取出\"error\"的值")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "memberId", value = "成员id(后台自动生成)",
                    paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "memberName", value = "成员姓名",
                    paramType = "query", dataType = "string", required = true),
            @ApiImplicitParam(name = "phoneNumber", value = "成员手机号码",
                    paramType = "query", dataType = "string", required = true),
            @ApiImplicitParam(name = "birthday", value = "成员生日(后台自动生成)",
                    paramType = "query", dataType = "date-time"),
            @ApiImplicitParam(name = "afterGraduated", value = "成员毕业后去向(若没有,则填暂无)",
                    paramType = "query", dataType = "string", required = true),
            @ApiImplicitParam(name = "major", value = "成员专业班级",
                    paramType = "query", dataType = "string", required = true),
            @ApiImplicitParam(name = "memberDirect", value = "成员学习方向",
                    paramType = "query", dataType = "string", required = true),
            @ApiImplicitParam(name = "memberPassword", value = "成员密码(默认为123123)",
                    paramType = "query", dataType = "string", required = true),
    })
    @ApiIgnore
    /**
     * 添加成员
     * @param member 自动封装实体类
     * @return Msg消息
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Msg addMemeber(@ModelAttribute(value = "Member")@Valid Member member){

        boolean isSuccess = adminMemberService.addMember(member);
        if (isSuccess) {
            return Msg.success();
        }else{
            return Msg.fail().add("error", "添加失败!发生无法预知的错误!程序猿正在路上!");
        }

    }

    @ApiOperation(value = "删除一个成员", notes = "正确码为200,错误码为100,出现错误时在extends中可以取出\"error\"的值")
    @ApiImplicitParam(name = "memberId", value = "成员id", paramType = "path", dataType = "int", required = true)
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

    @ApiOperation(value = "获取所有团队成员", notes = "分页显示;每页显示5条,分页条连续显示3页")
    @ApiImplicitParam(name = "pn", value = "分页参数", paramType = "query", dataType = "int")
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

    @ApiOperation(value = "修改团队成员信息", notes = "正确码为200,错误码为100,出现错误时在extends中可以取出\"error\"的值")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "memberId", value = "成员id",
                    paramType = "path", dataType = "int", required = true),
            @ApiImplicitParam(name = "memberName", value = "成员姓名",
                    paramType = "query", dataType = "string", required = true),
            @ApiImplicitParam(name = "phoneNumber", value = "成员手机号码",
                    paramType = "query", dataType = "string", required = true),
            @ApiImplicitParam(name = "birthday", value = "成员生日(格式yyyy-MM-dd)",
                    paramType = "query", dataType = "string", required = true),
            @ApiImplicitParam(name = "afterGraduated", value = "成员毕业后去向(若没有,则填暂无)",
                    paramType = "query", dataType = "string", required = true),
            @ApiImplicitParam(name = "major", value = "成员专业班级",
                    paramType = "query", dataType = "string", required = true),
            @ApiImplicitParam(name = "memberDirect", value = "成员学习方向",
                    paramType = "query", dataType = "string", required = true),
            @ApiImplicitParam(name = "memberPassword", value = "成员密码",
                    paramType = "query", dataType = "string", required = true),
    })
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
            msg.setCode(100);
            msg.setMsg("修改失败");
            result.getAllErrors().forEach(objectError -> msg.add(objectError.getCode()
                    , objectError.getDefaultMessage()));
            return msg;
        }else{
            boolean isSuccess = adminMemberService.updateMember(member, memberId);
            return isSuccess ? Msg.success() : Msg.fail();
        }

    }

    @ApiOperation(value = "获取一个团队成员", notes = "来到修改删除页面")
    @ApiImplicitParam(name = "memberId", value = "成员id", paramType = "path", dataType = "int", required = true)
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
