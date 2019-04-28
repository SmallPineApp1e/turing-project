package com.turing.turing.guest.service;

import com.turing.turing.entity.Member;

import java.util.List;

/**
 * @author Jack
 * @date 2019-03-23-9:11
 */
public interface MemberService {

    /**
     * 查找后台团队成员
     */
    List<Member> getBacksideMembers();
    /**
     * 查找前端团队成员
     */
    List<Member> getFrontsideMembers();
    /**
     * 查找AI团队成员
     */
    List<Member> getAiMembers();

}
