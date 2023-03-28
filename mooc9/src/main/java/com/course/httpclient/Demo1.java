package com.course.httpclient;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @author haona
 * @ClassName Demo1
 * @Description 9-1 HttpClient简介及第一个demo
 * @date 14/3/2023 5:52 下午
 */
public class Demo1 {

    @Test
    public void test1() throws IOException {
        System.out.println(1);
        String result = null;

        HttpGet get = new HttpGet("http://www.baidu.com");

        //用来执行get方法
        HttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println(result);
    }
}
