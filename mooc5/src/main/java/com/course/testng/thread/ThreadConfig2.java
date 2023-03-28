package com.course.testng.thread;

import org.testng.annotations.Test;

/**
 * @author haona
 * @ClassName ThreadConfig
 * @Description 多线程测试，thread.xml配置文件实现
 * @date 13/3/2023 7:06 下午
 */
public class ThreadConfig2 {

    @Test
    public void test4() {
        System.out.printf("Thread Id : %s%n", Thread.currentThread().getId());
    }

    @Test
    public void test5() {
        System.out.printf("Thread Id : %s%n", Thread.currentThread().getId());
    }

    @Test
    public void test6() {
        System.out.printf("Thread Id : %s%n", Thread.currentThread().getId());
    }
}
