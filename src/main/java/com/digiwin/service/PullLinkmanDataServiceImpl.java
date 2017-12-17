package com.digiwin.service;

import com.digiwin.mapper.LinkmanMapper;
import com.digiwin.pojo.Linkman;
import com.digiwin.pojo.LinkmanExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhangyongjie on 2017/8/31.
 */
@Service
public class PullLinkmanDataServiceImpl implements PullLinkmanDataService {

    @Autowired
    private LinkmanMapper linkmanMapper;

    public int insertLinkmanData(Linkman linkman) {
        return linkmanMapper.insert(linkman);
    }

    public int insertLinkmanDataBatch(List<Linkman> linkmen) {
        return linkmanMapper.insertLinkmanBatch(linkmen);
    }

    public int deleteLinkmanData(Long id) {
        LinkmanExample linkmanExample = new LinkmanExample();
        LinkmanExample.Criteria criteria = linkmanExample.createCriteria();
        criteria.andIdEqualTo(id);
        return linkmanMapper.deleteByExample(linkmanExample);
    }

    public int updateLinkmanData(Linkman linkman) {
        return linkmanMapper.updateByPrimaryKeySelective(linkman);
    }
}
