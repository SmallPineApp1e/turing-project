package com.turing.turing.admin.controller;

import com.turing.turing.admin.service.LoginService;
import com.turing.turing.entity.Member;
import com.turing.turing.util.DateFormat;
import com.turing.turing.util.Msg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * @author Jack
 * @date 2019-03-23-8:40
 */
@Api(tags = {"后台登陆接口"})
@RestController
@CrossOrigin
@RequestMapping(value = "/adminLogin")
public class LoginController {

    @Autowired
    LoginService loginService;

    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @ApiOperation(value = "成员登陆", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "password",paramType = "query", dataType = "String",
                    required = true, value = "密码"),
            @ApiImplicitParam(name = "username",paramType = "query", dataType = "String",
                    required = true, value = "用户名")
    })
    /**
     * 成员登陆
     * @param username
     * @param password
     * @param request
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Msg login(@RequestParam("username") String username
            , @RequestParam("password") String password, HttpServletRequest request){

        try {
            List<Member> members = loginService.isLoginSuccess(username, password);
            if (members.size()!=0){
                Member member = members.get(0);
                request.getSession().setAttribute("member", member);
                logger.info(member.getMemberName()+"于"+ DateFormat.getNowTime()+"登陆了后台管理！");
                return Msg.success().add("member", member);
            }else{
                return Msg.fail().add("error", "用户名或密码错误!");
            }
        } catch (NoSuchAlgorithmException e) {
            return Msg.fail().add("error","服务器发生未知错误!程序猿小哥哥马上处理!");
        }
    }

    @RequestMapping(value = "",method = RequestMethod.GET)
    public Msg getLoginMember(HttpServletRequest request){

        Member member = (Member) request.getSession().getAttribute("member");
        return Msg.success().add("member",member);

    }

}
