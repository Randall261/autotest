package com.course.testng.suite;

import org.testng.annotations.Test;

/**
 * @author haona
 * @ClassName PayTest
 * @Description 测试套件的使用，通过testng.xml配置文件配置用例的运行顺序
 * @date 12/3/2023 11:01 下午
 */
public class AliTest {

    @Test
    public void loginAli() {
        System.out.println("支付宝登录成功");
    }
}
