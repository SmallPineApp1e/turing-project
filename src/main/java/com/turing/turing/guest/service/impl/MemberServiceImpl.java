package com.turing.turing.guest.service.impl;

import com.turing.turing.dao.MemberMapper;
import com.turing.turing.entity.Member;
import com.turing.turing.entity.MemberExample;
import com.turing.turing.guest.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<Member> getFrontsideMembers() {

        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andMemberDirectLike("%前端%");
        List<Member> members = memberMapper.selectByExampleWithoutPassword(memberExample);
        return members;

    }
    @Override
    public List<Member> getBacksideMembers() {

        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andMemberDirectLike("%后台%");
        List<Member> members = memberMapper.selectByExampleWithoutPassword(memberExample);
        return members;

    }
    @Override
    public List<Member> getAiMembers() {

        List<Member> members = memberMapper.selectByExampleWithoutPassword(null);
        System.out.println(members.size());
        List<Member> aiMembers = new ArrayList<>();
        for (Member member :
                members) {
            if("计算机视觉".equals(member.getMemberDirect()) || "自然语言处理".equals(member.getMemberDirect())){
                aiMembers.add(member);
            }
        }
        return aiMembers;

    }

}
