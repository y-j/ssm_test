package com.digiwin.controller;

import com.digiwin.pojo.TbUser;
import com.digiwin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhangyongjie on 2017/8/30.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "test")
    @ResponseBody public TbUser getAll() {
        TbUser tbUser = userService.selectByPrimaryKey((long) 1);
        System.out.println("=====" + tbUser);
        return tbUser;
    }
}
