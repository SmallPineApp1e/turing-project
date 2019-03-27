package com.turing.turing.guest.service.impl;

import com.turing.turing.dao.InformMapper;
import com.turing.turing.entity.Inform;
import com.turing.turing.guest.service.InformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jack
 * @date 2019-03-23-9:06
 */
@Service
public class InformServiceImpl implements InformService {

    @Autowired
    InformMapper informMapper;

    @Override
    public Inform getInform() {

        List<Inform> informs = informMapper.selectByExample(null);
        Inform latestInform = informs.get(informs.size()-1);
        return latestInform;

    }

}
