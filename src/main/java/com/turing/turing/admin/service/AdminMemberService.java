package com.turing.turing.admin.service;

import com.turing.turing.entity.Member;

import java.util.List;

/**
 * @author Jack
 * @date 2019-03-23-11:07
 */

public interface AdminMemberService {

    /**
     * 添加团队成员
     * @param member
     * @return
     */
    boolean addMember(Member member);

    /**
     * 根据id删除团队成员
     * @param memberId 成员唯一id
     * @return
     */
    boolean deleteMember(Integer memberId);

    /**
     * 获取全部团队成员信息(包括密码)
     * @return
     */
    List<Member> getMembers();

    /**
     * 更新团队成员信息
     * @return
     */
    boolean updateMember(Member member, Integer memberId);

    /**
     * 根据Id查询某个成员的id
     * @return
     */
    Member getMemberById(Integer memberId);
}
