package com.course.mybatis.controller;

import com.course.mybatis.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author haona
 * @ClassName Demo1
 * @Description TODO
 * @date 18/3/2023 3:17 下午
 */
@RestController
@Api(value = "v1", description = "11-2 使用mybatis+SpringBoot完成第一个查询demo")
@RequestMapping("v1")
public class Demo1 {

    //执行sql语句的对象
    @Autowired
    private SqlSessionTemplate template;

    /**
     * 这里的路径需要与mapper中的id保持一致
     */
    @RequestMapping(value = "/getUserCount", method = RequestMethod.GET)
    @ApiOperation(value = "获取用户数", httpMethod = "GET")
    public int getUserCount() {
        return template.selectOne("getUserCount");
    }

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    @ApiOperation(value = "新增用户", httpMethod = "POST")
    public int addUser(@RequestBody User user){
        return template.insert("addUser",user);
    }

    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    @ApiOperation(value = "修改用户", httpMethod = "POST")
    public int updateUser(@RequestBody User user){
        return template.update("updateUser",user);
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    @ApiOperation(value = "删除用户",httpMethod = "GET")
    public int deleteUser(@RequestParam int id){
        return template.delete("deleteUser",id);
    }
}
















