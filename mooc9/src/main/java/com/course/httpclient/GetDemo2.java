package com.course.httpclient;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author haona
 * @ClassName Demo2
 * @Description 9-3 配置优化方法
 * 基于Demo1进行优化
 * @date 14/3/2023 11:54 下午
 */
public class GetDemo2 {

    private String url;
    private ResourceBundle bundle;
    private CookieStore store;//用来存储cookie信息的变量

    @BeforeTest
    public void beforeTest() {
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url");
    }

    @Test
    public void testGetCookies() throws IOException {
        String result;
        String uri = bundle.getString("test.getCookies.url");
        String testUrl = this.url + uri;

        HttpGet get = new HttpGet(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println(result);

        this.store = client.getCookieStore();
        List<Cookie> cookieList = store.getCookies();

        for (Cookie cookie :
                cookieList) {
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookie name=" + name + ";\tcookie value=" + value);
        }
    }

    @Test(dependsOnMethods = "testGetCookies")
    public void testGetWithCookies() throws IOException {
        String uri = bundle.getString("test.get.with.cookies");
        String testUrl = this.url + uri;
        HttpGet get = new HttpGet(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        client.setCookieStore(this.store);
        HttpResponse response = client.execute(get);
        int code = response.getStatusLine().getStatusCode();
        System.out.println("code：" + code);
        if (code == 200) {
            String result = EntityUtils.toString(response.getEntity(), "utf-8");
            System.out.println("状态码200，返回结果为：" + result);
        }
    }
}
