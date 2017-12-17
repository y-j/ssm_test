package com.digiwin.Utils;

import com.alibaba.druid.support.json.JSONParser;
import com.alibaba.fastjson.JSON;
import com.digiwin.pojo.Linkman;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * Created by zhangyongjie on 2017/8/31.
 */
public class HttpClientTest {

    public static Object get(String urlStr) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        List<Linkman> linkmanList = null;
        try {
            // 创建httpget.
            HttpGet httpget = new HttpGet(urlStr);
            System.out.println("executing request " + httpget.getURI());
            // 执行get请求.
            CloseableHttpResponse response = httpclient.execute(httpget);
            try {
                // 获取响应实体
                HttpEntity entity = response.getEntity();
                System.out.println("--------------------------------------");
                // 打印响应状态
                System.out.println(response.getStatusLine());
                if (entity != null) {
                    // 打印响应内容长度
                    System.out.println("Response content length: " + entity.getContentLength());

                    String str =  EntityUtils.toString(entity);
                    // 打印响应内容
                    System.out.println("Response content: " + str);
                    linkmanList = JSON.parseArray(str, Linkman.class);
                    System.out.println("结果" + linkmanList);
                }
                System.out.println("------------------------------------");
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭连接,释放资源
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return linkmanList;
        }
    }
}
