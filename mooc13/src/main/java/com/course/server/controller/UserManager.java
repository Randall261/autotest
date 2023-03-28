package com.course.server.controller;

import com.course.server.model.User;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author haona
 * @ClassName UserManager
 * @Description 服务端接口
 * test.url=http://localhost:8888
 * #获取指定用户信息接口
 * getUserInfo.uri=/v1/getUserInfo
 * @date 21/3/2023 11:01 下午
 */
@Log4j
@RestController
@Api(value = "v1", description = "用户管理系统")
@RequestMapping("v1")
public class UserManager {
    // * #登录接口
    // * login.uri=/v1/login
    @Autowired
    private SqlSessionTemplate template;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public boolean login(@RequestBody User user) {
        //用户名密码登录
        int i = template.selectOne("login", user);
        if (i > 0) {
            return true;
        }
        return false;
    }

    // * #添加用户接口
    // * addUser.uri=/v1/addUser
    @RequestMapping("/addUser")
    public boolean add(@RequestBody User user) {
        int i = template.insert("addUser", user);
        if (i > 0) {
            return true;
        }
        return false;
    }

    // * #更新用户信息接口
    // * updateUserInfo.uri=/v1/updateUserInfo
    @RequestMapping("/updateUserInfo")
    public boolean update(@RequestBody User user) {
        int i = template.update("updateUser", user);
        if (i > 0) {
            return true;
        }
        return false;
    }

    // * #获取用户列表接口
    // * getUserList.uri=/v1/getUserList
    @RequestMapping("/getUserList")
    public List<User> getList(@RequestBody User user){
        List<User> userList = template.selectList("getUserList",user);
        return userList;
    }
}
