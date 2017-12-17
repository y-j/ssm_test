package com.digiwin.service;

import com.digiwin.pojo.TbUser;

/**
 * Created by zhangyongjie on 2017/8/30.
 */
public interface UserService {
    TbUser selectByPrimaryKey(Long id);
}
