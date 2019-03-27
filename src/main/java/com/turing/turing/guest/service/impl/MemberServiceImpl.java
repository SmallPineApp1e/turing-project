package com.turing.turing.guest.service.impl;

import com.turing.turing.dao.MemberMapper;
import com.turing.turing.entity.Member;
import com.turing.turing.guest.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jack
 * @date 2019-03-23-9:13
 */
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberMapper memberMapper;

    @Override
    public List<Member> getMembers() {

        List<Member> members = memberMapper.selectByExampleWithoutPassword(null);
        return members;

    }

}
