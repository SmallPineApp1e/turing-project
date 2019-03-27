package com.turing.turing.guest.service;

import com.turing.turing.entity.Member;

import java.util.List;

/**
 * @author Jack
 * @date 2019-03-23-9:11
 */
public interface MemberService {

    /**
     * 查找所有团队成员
     */
    List<Member> getMembers();

}
