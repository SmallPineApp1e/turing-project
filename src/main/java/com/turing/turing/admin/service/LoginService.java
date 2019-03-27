package com.turing.turing.admin.service;

import com.turing.turing.entity.Member;

import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * @author Jack
 * @date 2019-03-23-9:26
 */
public interface LoginService {
    /**
     * 登陆校验
     * @param username  用户名
     * @param password  密码
     * @return
     */
    List<Member> isLoginSuccess(String username, String password) throws NoSuchAlgorithmException;

}
