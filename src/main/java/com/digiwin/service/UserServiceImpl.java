package com.digiwin.service;

import com.digiwin.mapper.TbUserMapper;
import com.digiwin.pojo.TbUser;
import org.apache.http.client.HttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhangyongjie on 2017/8/30.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private TbUserMapper userMapper;
    public TbUser selectByPrimaryKey(Long id) {
        TbUser tbUser = userMapper.selectByPrimaryKey(id);
        return tbUser;
    }

}
