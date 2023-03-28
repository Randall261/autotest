package com.course.testng.parameter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @author haona
 * @ClassName ParamTest
 * @Description 参数化测试方法一，通过param.xml配置文件传入参数，结合@Parameters使用
 * @date 13/3/2023 4:58 下午
 */
public class ParamTest {

    @Test
    @Parameters({"s1", "s2"})
    public void test1(String s1, String s2) {
        System.out.println("参数s1=" + s1 + "\t参数s2=" + s2);
    }
}
