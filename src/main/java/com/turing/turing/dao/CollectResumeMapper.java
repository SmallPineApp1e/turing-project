package com.turing.turing.dao;

import com.turing.turing.entity.CollectResume;
import com.turing.turing.entity.CollectResumeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CollectResumeMapper {
    long countByExample(CollectResumeExample example);

    int deleteByExample(CollectResumeExample example);

    int deleteByPrimaryKey(Integer colResuId);

    int insert(CollectResume record);

    int insertSelective(CollectResume record);

    List<CollectResume> selectByExample(CollectResumeExample example);

    CollectResume selectByPrimaryKey(Integer colResuId);

    int updateByExampleSelective(@Param("record") CollectResume record, @Param("example") CollectResumeExample example);

    int updateByExample(@Param("record") CollectResume record, @Param("example") CollectResumeExample example);

    int updateByPrimaryKeySelective(CollectResume record);

    int updateByPrimaryKey(CollectResume record);
}