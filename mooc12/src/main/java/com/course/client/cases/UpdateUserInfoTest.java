package com.course.client.cases;

import com.course.client.config.TestConfig;
import com.course.client.model.UpdateUserInfoCase;
import com.course.client.utils.DatabaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @author haona
 * @ClassName UpdateUserInfoTest
 * @Description TODO
 * @date 21/3/2023 4:17 下午
 */
public class UpdateUserInfoTest {

    @Test(dependsOnGroups = "loginTrue", description = "登录成功后，更新用户")
    public void updateUserInfo() throws IOException {
        SqlSession sqlSession = DatabaseUtil.getSqlSession();
        UpdateUserInfoCase updateUserInfoCase = sqlSession.selectOne("updateUserInfoCase", 1);
        String result = sendRequest(updateUserInfoCase);
        System.out.println("更新用户用例：" + updateUserInfoCase);
        System.out.println("请求地址："+ TestConfig.updateUserInfoUrl);
        System.out.println("实际结果：" + result);
        Assert.assertEquals(updateUserInfoCase.getExpected(),result);
    }

    public String sendRequest(UpdateUserInfoCase updateUserInfoCase) throws IOException {
        HttpPost post = new HttpPost(TestConfig.updateUserInfoUrl);
        post.setHeader("content-type", "application/json");
        JSONObject param = new JSONObject();
        param.put("id", updateUserInfoCase.getId());
        param.put("username", updateUserInfoCase.getUsername());
        param.put("sex", "null");
        StringEntity entity = new StringEntity(param.toString(), "utf-8");
        post.setEntity(entity);
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        String result = EntityUtils.toString(response.getEntity(), "utf-8");
        return result;

    }
}
