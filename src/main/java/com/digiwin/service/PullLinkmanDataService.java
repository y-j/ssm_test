package com.digiwin.service;

import com.digiwin.pojo.Linkman;

import java.util.List;

/**
 * Created by zhangyongjie on 2017/8/31.
 */
public interface PullLinkmanDataService {

    public int insertLinkmanData(Linkman linkman);

    public int insertLinkmanDataBatch(List<Linkman> linkmen);

    public int deleteLinkmanData(Long id);

    public int updateLinkmanData(Linkman linkman);
}
