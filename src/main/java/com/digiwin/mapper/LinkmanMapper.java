package com.digiwin.mapper;

import com.digiwin.pojo.Linkman;
import com.digiwin.pojo.LinkmanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LinkmanMapper {

    //    批插入
    int insertLinkmanBatch(List<Linkman> linkmen);

    int countByExample(LinkmanExample example);

    int deleteByExample(LinkmanExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Linkman record);

    int insertSelective(Linkman record);

    List<Linkman> selectByExample(LinkmanExample example);

    Linkman selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Linkman record, @Param("example") LinkmanExample example);

    int updateByExample(@Param("record") Linkman record, @Param("example") LinkmanExample example);

    int updateByPrimaryKeySelective(Linkman record);

    int updateByPrimaryKey(Linkman record);
}