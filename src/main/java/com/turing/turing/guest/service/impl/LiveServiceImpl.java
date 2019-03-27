package com.turing.turing.guest.service.impl;

import com.turing.turing.dao.LiveMapper;
import com.turing.turing.entity.Live;
import com.turing.turing.guest.service.LiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jack
 * @date 2019-03-23-9:01
 */
@Service
public class LiveServiceImpl implements LiveService {

    @Autowired
    LiveMapper liveMapper;


    @Override
    public List<Live> getLive() {

        List<Live> lives = liveMapper.selectByExampleWithPhotos(null);
        return lives;

    }
}
