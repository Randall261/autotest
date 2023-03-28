package com.course.httpclient;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author haona
 * @ClassName PostDemo3
 * @Description 9-6 Post方法的访问实战
 * * 基于Demo1进行优化
 * @date 15/3/2023 4:48 下午
 */
public class PostDemo3 {

    private String url;
    private ResourceBundle bundle;
    private CookieStore store;

    @BeforeTest
    public void beforeTest() {
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url");
    }

    @Test
    public void testGetCookies() throws IOException {
        String uri = bundle.getString("test.getCookies.url");
        String testUrl = this.url + uri;

        HttpGet get = new HttpGet(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        String result = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println(result);

        store = client.getCookieStore();
        List<Cookie> cookiesList = store.getCookies();

        for (Cookie cookie : cookiesList) {
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("获取到cookie的name为：" + name + ";\t获取到cookie的value为：" + value);
        }
    }

    @Test(dependsOnMethods = "testGetCookies")
    public void testPostWithCookies() throws IOException {
        String uri = bundle.getString("test.post.with.cookies");
        String testUrl = url + uri;

        HttpPost post = new HttpPost(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        //post请求需要携带cookies和参数
        JSONObject param = new JSONObject();
        param.put("name", "姓名2");
        param.put("age", "12");
        post.setHeader("content-type", "application/json");
        client.setCookieStore(store);
        StringEntity entity = new StringEntity(param.toString(), "utf-8");
        post.setEntity(entity);
        /**
         * {
         *     "description": "7-7带cookies信息的post请求",
         *     "request": {
         *       "uri": "/demo1/post3",
         *       "method": "post",
         *       "cookies": {
         *         "login": "true"
         *       },
         *       "json": {
         *         "name": "姓名2",
         *         "age": "12"
         *       }
         *     },
         *     "response": {
         *       "status": 200,
         *       "json": {
         *         "msg": "success",
         *         "code": "1"
         *       }
         *     }
         *   }
         */


        HttpResponse response = client.execute(post);
        String result = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println("返回结果：" + result);
        JSONObject resultJson = new JSONObject(result);
        String msg = (String) resultJson.get("msg");
        String code = (String) resultJson.get("code");
        Assert.assertEquals(msg, "success");
        Assert.assertEquals(code, "1");
    }
}
