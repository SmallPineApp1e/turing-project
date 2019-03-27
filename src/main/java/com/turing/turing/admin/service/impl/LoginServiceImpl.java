package com.turing.turing.admin.service.impl;

import com.turing.turing.admin.service.LoginService;
import com.turing.turing.dao.MemberMapper;
import com.turing.turing.entity.Member;
import com.turing.turing.entity.MemberExample;
import com.turing.turing.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * @author Jack
 * @date 2019-03-23-9:29
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    MemberMapper memberMapper;

    @Override
    public List<Member> isLoginSuccess(String username, String password) throws NoSuchAlgorithmException {

        //获得加密后的密码
        String hexPassword = MD5Util.getHexPassword(password);
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andMemberNameEqualTo(username).andMemberPasswordEqualTo(hexPassword);
        List<Member> members = memberMapper.selectByExample(memberExample);
        return members;

    }
}
