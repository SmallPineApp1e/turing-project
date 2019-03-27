package com.turing.turing.guest.service;

import com.turing.turing.entity.Live;

import java.util.List;

/**
 * @author Jack
 * @date 2019-03-23-9:01
 */
public interface LiveService {

    /**
     * 获取日常活动及照片
     * @return
     */
    List<Live> getLive();

}
