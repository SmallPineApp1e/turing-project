package com.turing.turing.admin.controller;

import com.turing.turing.admin.service.LoginService;
import com.turing.turing.entity.Member;
import com.turing.turing.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * @author Jack
 * @date 2019-03-23-8:40
 */
@RestController
@RequestMapping(value = "/adminLogin")
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Msg login(@RequestParam("username") String username
            , @RequestParam("password") String password, HttpServletRequest request){

        try {
            List<Member> members = loginService.isLoginSuccess(username, password);
            if (members.size()!=0){
                Member member = members.get(0);
                request.getSession().setAttribute("member", member);
                return Msg.success().add("member", member);
            }else{
                return Msg.fail().add("error", "用户名或密码错误!");
            }
        } catch (NoSuchAlgorithmException e) {
            return Msg.fail().add("error","服务器发生未知错误!程序猿小哥哥马上处理!");
        }

    }

}
