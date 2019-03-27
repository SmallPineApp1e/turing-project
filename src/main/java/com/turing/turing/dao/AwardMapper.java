package com.turing.turing.dao;

import com.turing.turing.entity.Award;
import com.turing.turing.entity.AwardExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AwardMapper {
    long countByExample(AwardExample example);

    int deleteByExample(AwardExample example);

    int deleteByPrimaryKey(Integer awardId);

    int insert(Award record);

    int insertSelective(Award record);

    List<Award> selectByExample(AwardExample example);

    Award selectByPrimaryKey(Integer awardId);

    List<Award> selectByExampleWithPhoto(AwardExample example);

    Award selectByPrimaryKeyWithPhoto(Integer awardId);

    int updateByExampleSelective(@Param("record") Award record, @Param("example") AwardExample example);

    int updateByExample(@Param("record") Award record, @Param("example") AwardExample example);

    int updateByPrimaryKeySelective(Award record);

    int updateByPrimaryKey(Award record);
}