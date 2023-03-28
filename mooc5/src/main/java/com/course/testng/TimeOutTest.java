package com.course.testng;

import org.testng.annotations.Test;

/**
 * @author haona
 * @ClassName TimeOutTest
 * @Description TODO
 * @date 13/3/2023 11:44 下午
 */
public class TimeOutTest {

    @Test(timeOut = 3000)
    public void test1() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("没有超时，测试通过");
    }

    @Test(timeOut = 2000)
    public void test2() throws InterruptedException {
        Thread.sleep(3000);
    }
}
