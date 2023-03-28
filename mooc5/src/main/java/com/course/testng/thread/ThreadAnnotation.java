package com.course.testng.thread;

import org.testng.annotations.Test;

/**
 * @author haona
 * @ClassName ThreadAnnotation
 * @Description 多线程测试，注解方式实现
 * invocationCount---表示执行的次数
 * threadPoolSize---表示线程池内的线程个数
 * @date 13/3/2023 6:21 下午
 */
public class ThreadAnnotation {

    @Test(invocationCount = 10, threadPoolSize = 3)
    public void test1() {
//        System.out.println(1);
        System.out.printf("Thread Id : %s%n",Thread.currentThread().getId());
        //运行结果就是打印10条数据，有3个不同的线程id
    }
}
