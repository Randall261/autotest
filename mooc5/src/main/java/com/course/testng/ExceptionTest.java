package com.course.testng;

import org.testng.annotations.Test;

/**
 * @author haona
 * @ClassName ExceptionTest
 * @Description 什么时候会用到异常测试？
 * 在我们期望结果为某一个异常的时候，比如：传入某些不合法的参数，程序需要抛出异常
 * 异常测试 @Test(expectedExceptions = RuntimeException.class)
 * @date 13/3/2023 4:25 下午
 */
public class ExceptionTest {

    @Test(expectedExceptions = RuntimeException.class)
    public void exceptionFail(){
        System.out.println("测试不通过的异常测试");
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void exceptionSuccess(){
        System.out.println("测试通过的异常测试");
        throw new RuntimeException();
    }

}
