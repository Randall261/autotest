package com.course.extent;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

/**
 * @author haona
 * @ClassName Demo1
 * @Description 输出测试报告ExtentReport，结合extent.xml配置文件
 * 添加监听器com.vimalselvam.testng.listener.ExtentTestNgFormatter
 * @date 14/3/2023 10:50 上午
 */
public class Demo1 {

    @Test
    public void test1() {
        Assert.assertEquals(1, 2);
    }

    @Test
    public void test2() {
        Assert.assertEquals(1, 1);
    }

    @Test
    public void test3() {
        Reporter.log("日志打印～～～～～");
        throw new RuntimeException("运行时异常");
    }
}
