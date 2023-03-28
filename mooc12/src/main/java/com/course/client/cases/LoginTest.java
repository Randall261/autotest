package com.course.client.cases;

import com.course.client.config.TestConfig;
import com.course.client.model.InterfaceName;
import com.course.client.model.LoginCase;
import com.course.client.utils.ConfigFile;
import com.course.client.utils.DatabaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.course.client.config.TestConfig.*;

/**
 * @author haona
 * @ClassName LoginTest
 * @Description TODO
 * @date 20/3/2023 3:51 下午
 */
public class LoginTest {

    @BeforeTest(groups = "loginTrue", description = "测试准备工作，获取HttpClient对象")
    public void beforeTest() {
        loginUrl = ConfigFile.getUrl(InterfaceName.LOGIN);
        addUserUrl = ConfigFile.getUrl(InterfaceName.ADDUSERINFO);
        getUserInfoUrl = ConfigFile.getUrl(InterfaceName.GETUSERINFO);
        getUserListUrl = ConfigFile.getUrl(InterfaceName.GETUSERLIST);
        updateUserInfoUrl = ConfigFile.getUrl(InterfaceName.UPDATEUSERINFO);
        TestConfig.defaultHttpClient = new DefaultHttpClient();
    }
    @Test(groups = "loginTrue",description = "登录成功")
    public void loginTrue() throws IOException {
        SqlSession sqlSession = DatabaseUtil.getSqlSession();
        LoginCase loginCase = sqlSession.selectOne("loginCase", 1);
        //登录用例：LoginCase(id=1, username=user1, password=123456, expected=null)
        System.out.println("登录用例：" + loginCase);
        //请求地址：http://localhost:8890/v1/login
        System.out.println("请求地址：" + loginUrl);

        String result = sendRequest(loginCase);
        System.out.println("实际结果：" + result);
        Assert.assertEquals(loginCase.getExpected(),result);
    }

    @Test(groups = "loginFalse",description = "登录失败")
    public void loginFalse() throws IOException {
        SqlSession sqlSession = DatabaseUtil.getSqlSession();
        LoginCase loginCase = sqlSession.selectOne("loginCase",2);
        System.out.println("登录用例：" + loginCase);
        System.out.println("请求地址：" + loginUrl);
        String result = sendRequest(loginCase);
        System.out.println("实际结果：" + result);
        Assert.assertEquals(loginCase.getExpected(),result);
    }

    private String sendRequest(LoginCase loginCase) throws IOException {
        HttpPost post = new HttpPost(loginUrl);
        JSONObject param = new JSONObject();
        param.put("username", loginCase.getUsername());
        param.put("password", loginCase.getPassword());
        post.setHeader("content-type", "application/json");
        StringEntity entity = new StringEntity(param.toString(), "utf-8");
        post.setEntity(entity);
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        String result = EntityUtils.toString(response.getEntity(),"utf-8");
        return result;
    }
}
