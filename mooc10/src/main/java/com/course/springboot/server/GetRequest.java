package com.course.springboot.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author haona
 * @ClassName GetRequest
 * @Description TODO
 * @date 16/3/2023 3:19 下午
 */
@RestController
@Api(value = "/",description = "这是GetRequest类的全部接口")
public class GetRequest {

    @RequestMapping(value = "/demo1/get4", method = RequestMethod.GET)
//    @ResponseBody
    @ApiOperation(value = "获取cookies信息的get请求",httpMethod = "GET")
    public String testGetCookies(HttpServletResponse response) {
//        HttpServletRequest 用来装请求信息的类
//        HttpServletResponse 用来装响应信息的类
        Cookie cookie = new Cookie("login", "true");
        response.addCookie(cookie);
        return "9-2 Mock一个返回Cookies信息的请求";
    }

    //7-6带cookies信息的get请求
    @RequestMapping(value = "/demo1/get3", method = RequestMethod.GET)
    @ApiOperation(value = "携带cookies信息的get请求",httpMethod = "GET")
    public String testGetWithCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (Objects.isNull(cookies)) {
            return "缺少cookie信息";
        }
        for (Cookie cookie :
                cookies) {
            if (cookie.getName().equals("login") && cookie.getValue().equals("true")) {
                return "携带cookie信息正确";
            }
        }
        return "携带cookie信息错误！";
    }

    //带参数的get请求例子

    /**
     * 第一种实现方式 url：localhost:8888/get/param1?start=value&end=value
     */
    @RequestMapping(value = "/get/param1", method = RequestMethod.GET)
    @ApiOperation(value = "携带参数的get请求 Demo1",httpMethod = "GET")
    public Map<String, Integer> testGetWithParam1(@RequestParam Integer start, @RequestParam Integer end) {
        Map<String, Integer> map = new HashMap<>();
        map.put("商品1", 1);
        map.put("商品2", 2);
        map.put("商品3", 3);
        return map;
    }

    /**
     * 第二种实现方式 url：localhost:8888/get/param2/{start}/{end}
     */
    @RequestMapping(value = "/get/param2/{start}/{end}", method = RequestMethod.GET)
    @ApiOperation(value = "携带参数的get请求 Demo2",httpMethod = "GET")
    public Map<String, Integer> testGetWithParam2(@PathVariable Integer start, @PathVariable Integer end) {
        Map<String, Integer> map = new HashMap<>();
        map.put("商品4", 4);
        map.put("商品5", 5);
        map.put("商品6", 6);
        map.put("商品7", 7);
        return map;
    }
}
