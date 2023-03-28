package com.course.testng;

import org.testng.annotations.Test;

/**
 * @author haona
 * @ClassName IgnoreTest
 * @Description 忽略测试 @Test(enabled = false)，在不需要执行的用例上加这个属性
 * @date 13/3/2023 12:45 上午
 */
public class IgnoreTest {

    @Test
    public void ignoreTest1() {
        System.out.println("用例1 执行！");
    }

    //enabled = false的用例不会执行
    @Test(enabled = false)
    public void ignoreTest2() {
        System.out.println("用例2 执行！");
    }

    @Test(enabled = true)
    public void ignoreTest3() {
        System.out.println("用例3 执行！");
    }
}
