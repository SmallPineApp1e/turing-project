package com.turing.turing.admin.service;

import com.turing.turing.entity.Live;

import java.util.List;

/**
 * @author Jack
 * @date 2019-03-23-19:21
 */
public interface AdminLiveService {

    /**
     * 上传生活名称
     * @return
     */
    boolean addLive(Live live);

    /**
     * 上传生活照
     * @param photoLocate
     * @param live
     * @return
     */
    boolean addLivePhoto(String photoLocate, Live live);

    /**
     * 获取生活及照片(分页)
     * @return
     */
    List<Live> getLive();

    /**
     * 删除生活及照片
     * @param liveId
     * @return
     */
    boolean deleteLive(Integer liveId, String realPath);

    /**
     * 根据id查询生活照(来到删除页面)
     * @param liveId
     * @return
     */
    Live getLiveById(Integer liveId);
}
