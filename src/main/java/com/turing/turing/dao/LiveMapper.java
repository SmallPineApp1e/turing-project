package com.turing.turing.dao;

import com.turing.turing.entity.Live;
import com.turing.turing.entity.LiveExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LiveMapper {
    long countByExample(LiveExample example);

    int deleteByExample(LiveExample example);

    int deleteByPrimaryKey(Integer liveId);

    int insert(Live record);

    int insertSelective(Live record);

    List<Live> selectByExample(LiveExample example);

    Live selectByPrimaryKey(Integer liveId);

    List<Live> selectByExampleWithPhotos(LiveExample example);

    Live selectByPrimaryKeyWithPhotos(Integer liveId);

    int updateByExampleSelective(@Param("record") Live record, @Param("example") LiveExample example);

    int updateByExample(@Param("record") Live record, @Param("example") LiveExample example);

    int updateByPrimaryKeySelective(Live record);

    int updateByPrimaryKey(Live record);
}