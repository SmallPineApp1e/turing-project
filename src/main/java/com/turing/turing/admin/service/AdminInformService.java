package com.turing.turing.admin.service;

import com.turing.turing.entity.Inform;

import java.util.List;

/**
 * @author Jack
 * @date 2019-03-23-10:26
 */
public interface AdminInformService {
    /**
     * 发布通告
     * @param inform
     * @return
     */
    boolean addInform(Inform inform);

    /**
     * 获取所有通告
     * @return 所有通告的List
     */
    List<Inform> getInforms();

    /**
     * 根据id删除一条通告
     * @param informId 通告id
     * @return
     */
    boolean deleteInform(Integer informId);

    /**
     * 修改一条通告
     * @param inform
     * @return
     */
    boolean updateInform(Inform inform, Integer informId);

    /**
     * 根据id查询通告
     * @param informId
     * @return
     */
    Inform getInformById(Integer informId);
}
