package com.course.client.cases;

import com.course.client.config.TestConfig;
import com.course.client.model.AddUserCase;
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
 * @ClassName AddUserTest
 * @Description TODO
 * @date 20/3/2023 3:50 下午
 */
public class AddUserTest {

    @Test(dependsOnGroups = "loginTrue", description = "登录成功后，添加用户")
    public void addUser() throws IOException {
        SqlSession sqlSession = DatabaseUtil.getSqlSession();
        AddUserCase addUserCase = sqlSession.selectOne("addUserCase", 1);
        String result = sendRequest(addUserCase);
        System.out.println("添加用户用例：" + addUserCase);
        System.out.println("请求地址：" + TestConfig.addUserUrl);
        System.out.println("实际结果：" + result);
        Assert.assertEquals(addUserCase.getExpected(),result);
    }

    private String sendRequest(AddUserCase addUserCase) throws IOException {
        HttpPost post = new HttpPost(TestConfig.addUserUrl);
        JSONObject param = new JSONObject();
        param.put("username", addUserCase.getUsername());
        param.put("password", addUserCase.getPassword());
        param.put("sex", addUserCase.getSex());
        param.put("age", addUserCase.getAge());
        param.put("permission", addUserCase.getPermission());
        param.put("deleted", addUserCase.getDeleted());

        post.setHeader("content-type", "application/json");
        StringEntity entity = new StringEntity(param.toString(), "utf-8");
        post.setEntity(entity);
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        String result = EntityUtils.toString(response.getEntity(), "utf-8");
        return result;
    }
}
