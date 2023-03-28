package com.course.client.cases;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.course.client.config.TestConfig;
import com.course.client.model.GetUserInfoCase;
import com.course.client.utils.DatabaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @author haona
 * @ClassName GetUserInfoTest
 * @Description TODO
 * @date 21/3/2023 3:50 下午
 */
public class GetUserInfoTest {

    @Test(dependsOnGroups = "loginTrue", description = "登录成功后，添加用户")
    public void getUserInfo() throws IOException {
        SqlSession sqlSession = DatabaseUtil.getSqlSession();
        GetUserInfoCase getUserInfoCase = sqlSession.selectOne("getUserInfoCase",1);
        System.out.println("获取用户信息用例：" + getUserInfoCase);
        System.out.println("请求地址：" + TestConfig.getUserInfoUrl);
        JSONArray array = sendRequest(getUserInfoCase);
        JSONObject value = array.getJSONObject(0);
        /*array.forEach(json ->{
            System.out.println("遍历对象数组中的每一个对象");
            System.out.println(json);//JSONObject
        });*/
        Assert.assertEquals(value.getIntValue("id"), getUserInfoCase.getUserid());
    }

    private JSONArray sendRequest(GetUserInfoCase getUserInfoCase) throws IOException {
        HttpPost post = new HttpPost(TestConfig.getUserInfoUrl);
        JSONObject param = new JSONObject();
        param.put("id", getUserInfoCase.getUserid());
        post.setHeader("content-type", "application/json");
        StringEntity entity = new StringEntity(param.toString(), "utf-8");
        post.setEntity(entity);
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        //response：：：HTTP/1.1 200  [Content-Type: application/json;charset=UTF-8, Transfer-Encoding: chunked, Date: Fri, 24 Mar 2023 08:50:46 GMT] org.apache.http.conn.BasicManagedEntity@4e31276e
        String result = EntityUtils.toString(response.getEntity(), "utf-8");
        //[{"id":6,"username":"adduser2","password":"123456","sex":"male","age":10,"permission":0,"deleted":0}]
        JSONArray array = JSONArray.parseArray(result);
        return array;
    }
}
