package com.course.client.cases;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.course.client.config.TestConfig;
import com.course.client.model.GetUserListCase;
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
 * @ClassName GetUserListTest
 * @Description TODO
 * @date 21/3/2023 4:00 下午
 */
public class GetUserListTest {

    @Test(dependsOnGroups = "loginTrue", description = "登录成功后，获取用户列表")
    public void getUserList() throws IOException {
        SqlSession sqlSession = DatabaseUtil.getSqlSession();
        GetUserListCase getUserListCase = sqlSession.selectOne("getUserListCase", 1);
        JSONArray array = sendRequest(getUserListCase);
        //遍历对象数组
        array.forEach(json ->{
            System.out.println();
        });
        System.out.println("获取用户列表用例：" + getUserListCase);
        System.out.println("请求地址：" + TestConfig.getUserListUrl);
        Assert.assertEquals(1,1);
    }

    private JSONArray sendRequest(GetUserListCase getUserListCase) throws IOException {
        HttpPost post = new HttpPost(TestConfig.getUserListUrl);
        JSONObject param = new JSONObject();
        param.put("userid", getUserListCase.getId());
        param.put("username", getUserListCase.getUsername());
        param.put("sex", getUserListCase.getSex());
        param.put("age", getUserListCase.getAge());
        post.setHeader("content-type", "application/json");
        StringEntity entity = new StringEntity(param.toString(), "utf-8");
        post.setEntity(entity);
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        String result = EntityUtils.toString(response.getEntity(), "utf-8");
        JSONArray array = JSONArray.parseArray(result);
        return array;
    }


}
