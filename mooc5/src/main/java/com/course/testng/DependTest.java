package com.course.testng;

import org.testng.annotations.Test;

/**
 * @author haona
 * @ClassName DependTest
 * @Description 依赖测试 @Test(dependsOnMethods = {"被依赖的方法名"})
 * @date 13/3/2023 4:50 下午
 */
public class DependTest {

    @Test
    public void test1() {
        System.out.println("test1 run");
        throw new RuntimeException();
    }

    //如果被依赖的方法出现异常，则依赖它的方法会被忽略，不执行
    @Test(dependsOnMethods = {"test1"})
    public void test2() {
        System.out.println("test2 run");
    }
}
