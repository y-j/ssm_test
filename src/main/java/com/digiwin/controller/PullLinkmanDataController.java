package com.digiwin.controller;

import com.digiwin.Utils.HttpClientTest;
import com.digiwin.pojo.Linkman;
import com.digiwin.service.PullLinkmanDataService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by zhangyongjie on 2017/8/31.
 */
@Controller
public class PullLinkmanDataController {

    @Autowired
    private PullLinkmanDataService pullLinkmanDataService;

    @RequestMapping(value = "add")
    @ResponseBody public String addLinkmanData(Linkman linkman) {
        int i = pullLinkmanDataService.insertLinkmanData(linkman);
        if (i == 1)
            return "add ok";
        return "添加出现错误";
    }

    @RequestMapping(value = "delete")
    @ResponseBody public String deleteLinkmanData(Linkman linkman) {
        if (StringUtils.isEmpty("" + linkman.getId()) ) {
            return "需要userId";
        }
        int i = pullLinkmanDataService.deleteLinkmanData(linkman.getId());
        if (i == 1)
            return "delete ok";
        return "删除出错";
    }

    @RequestMapping(value = "update")
    @ResponseBody public String updateLinkmanData(Linkman linkman) {
        if (StringUtils.isEmpty("" + linkman.getId()) ) {
            return "需要userId";
        }
        int i = pullLinkmanDataService.updateLinkmanData(linkman);
        if (i == 1)
            return "update ok";
        return "修改出错";
    }

    @RequestMapping(value = "data")
    @ResponseBody public String pullLinkmanData(String urlStr) {
        List<Linkman> linkmanList = (List<Linkman>) HttpClientTest.get(urlStr);

        long startTime = System.nanoTime();   //获取开始时间

        for (Linkman linkman: linkmanList) {
            pullLinkmanDataService.insertLinkmanData(linkman);
        }

        long endTime = System.nanoTime(); //获取结束时间

        System.out.println("程序运行时间： "+(endTime-startTime)+"ns");

        return "ok" + (endTime-startTime)/1000000000.0;
    }

    @RequestMapping(value = "batch")
    @ResponseBody public String pullLinkmanDataBatch(String urlStr, HttpServletRequest request) {

        String callback = request.getParameter("callback");
        System.out.println("str======" + callback);
        Pattern pattern = Pattern
                .compile("^([hH][tT]{2}[pP]://|[hH][tT]{2}[pP][sS]://)(([A-Za-z0-9-~]+).)+([A-Za-z0-9-~\\/])+$");
        if (StringUtils.isNotEmpty(urlStr) && pattern.matcher(urlStr).matches()) {

            List<Linkman> linkmanList = (List<Linkman>) HttpClientTest.get(urlStr);

            long startTime = System.nanoTime();   //获取开始时间

            int i = pullLinkmanDataService.insertLinkmanDataBatch(linkmanList);

            System.out.println("i === " + i);

            long endTime = System.nanoTime(); //获取结束时间

            System.out.println("程序运行时间： "+(endTime-startTime)+"ns");

            return callback + "(" + "{\"resule\" : \"ok\"}" + ")";
        }
        return "batch url error";
    }


    public static String convertJsonp(String jsonStr) {
        return "";
    }
}
