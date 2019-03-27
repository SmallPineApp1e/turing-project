package com.turing.turing.dao;

import com.turing.turing.entity.History;
import com.turing.turing.entity.HistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HistoryMapper {
    long countByExample(HistoryExample example);

    int deleteByExample(HistoryExample example);

    int deleteByPrimaryKey(Integer hisId);

    int insert(History record);

    int insertSelective(History record);

    List<History> selectByExample(HistoryExample example);

    History selectByPrimaryKey(Integer hisId);

    int updateByExampleSelective(@Param("record") History record, @Param("example") HistoryExample example);

    int updateByExample(@Param("record") History record, @Param("example") HistoryExample example);

    int updateByPrimaryKeySelective(History record);

    int updateByPrimaryKey(History record);
}