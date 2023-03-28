package com.course.springboot.server;

import com.course.springboot.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * @author haona
 * @ClassName PostRequest
 * @Description TODO
 * @date 16/3/2023 11:11 下午
 */
@RestController
@Api(description = "这是PostRequest类中的全部接口")
public class PostRequest {

    private static Cookie cookie;

    @RequestMapping(value = "/demo2/post1", method = RequestMethod.POST)
    @ApiOperation(value = "获取cookies信息的post请求", httpMethod = "POST")
    public String login(HttpServletResponse response,
                        @RequestParam(value = "userName", required = true) String name,
                        @RequestParam(value = "passWord", required = true) String pwd) {
        if (name.equals("姓名1") && pwd.equals("123456")) {
            cookie = new Cookie("login", "true");
            response.addCookie(cookie);
            return "登录成功！";
        }
        return "登录失败";
    }

    @RequestMapping(value = "/demo2/post2", method = RequestMethod.POST)
    @ApiOperation(value = "获取用户列表", httpMethod = "POST")
    public String getUserList(HttpServletRequest request,
                              @RequestBody User user) {
        Cookie[] cookies = request.getCookies();
        if (!Objects.isNull(cookies)) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("login") && cookie.getValue().equals("true")) {
                    if (user.getUserName().equals("姓名1") && user.getPassWord().equals("123456")) {
                        user.setName("user1");
                        user.setSex("female");
                        return user.toString();
                    } else {
                        return "输入用户名密码有误";
                    }
                } else {
                    return "cookie信息有误";
                }
            }
        }
        return "缺少cookie信息";
    }
}
