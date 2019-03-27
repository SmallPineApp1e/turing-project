package com.turing.turing.admin.service.impl;

import com.turing.turing.admin.service.AdminMemberService;
import com.turing.turing.dao.MemberMapper;
import com.turing.turing.entity.Member;
import com.turing.turing.entity.MemberExample;
import com.turing.turing.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jack
 * @date 2019-03-23-11:08
 */
@Service
public class AdminMemberServiceImpl implements AdminMemberService {

    @Autowired
    MemberMapper memberMapper;

    @Override
    public boolean addMember(Member member) {

        Integer isSuccess = memberMapper.insert(member);
        return isSuccess != 0;

    }

    @Override
    public boolean deleteMember(Integer memberId) {

        Integer isSuccess = memberMapper.deleteByPrimaryKey(memberId);
        return isSuccess != 0;

    }

    @Override
    public List<Member> getMembers() {

        List<Member> members = memberMapper.selectByExample(null);
        return members;

    }

    @Override
    public boolean updateMember(Member member, Integer memberId) {

        String password = member.getMemberPassword();
        String hexPassword = MD5Util.getHexPassword(password);
        member.setMemberPassword(hexPassword);
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andMemberIdEqualTo(memberId);
        int row = memberMapper.updateByExample(member, memberExample);
        return row != 0;

    }

    @Override
    public Member getMemberById(Integer memberId) {

        return memberMapper.selectByPrimaryKey(memberId);

    }
}
