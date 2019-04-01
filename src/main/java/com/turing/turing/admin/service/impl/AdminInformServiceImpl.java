package com.turing.turing.admin.service.impl;

import com.turing.turing.admin.service.AdminInformService;
import com.turing.turing.dao.InformMapper;
import com.turing.turing.entity.Inform;
import com.turing.turing.entity.InformExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author Jack
 * @date 2019-03-23-10:27
 */
@Service
@Transactional
public class AdminInformServiceImpl implements AdminInformService {

    @Autowired
    InformMapper informMapper;

    @Override
    public boolean addInform(Inform inform) {

        inform.setCreateTime(new Date());
        int isSuccess = informMapper.insert(inform);
        return isSuccess != 0;

    }

    @Override
    public List<Inform> getInforms() {

        List<Inform> informs = informMapper.selectByExample(null);
        return informs;

    }

    @Override
    public boolean deleteInform(Integer informId) {

        int isSuccess = informMapper.deleteByPrimaryKey(informId);
        return (isSuccess != 0);

    }

    @Override
    public boolean updateInform(Inform inform, Integer informId) {

        InformExample informExample = new InformExample();
        informExample.createCriteria().andInformIdEqualTo(informId);
        return informMapper.updateByExample(inform, informExample) != 0;

    }

    @Override
    public Inform getInformById(Integer informId) {

        Inform inform = informMapper.selectByPrimaryKey(informId);
        return inform;

    }

}
