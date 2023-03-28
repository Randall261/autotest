package com.course.springboot.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author haona
 * @ClassName SampleController
 * @Description TODO
 * @date 15/3/2023 6:56 下午
 */
@Controller
@EnableAutoConfiguration
public class SampleController {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World";
    }

    public static void main(String[] args) {
        SpringApplication.run(SampleController.class,args);
    }
}
