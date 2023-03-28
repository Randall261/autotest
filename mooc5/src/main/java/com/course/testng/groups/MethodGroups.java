package com.course.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

/**
 * @author haona
 * @ClassName MethodGroups
 * @Description 分组测试方法一
 * 通过 @BeforeGroups("组名") @AfterGroups("组名") 指定某个组执行前后需要运行的内容
 * @date 13/3/2023 12:49 上午
 */
public class MethodGroups {

    @Test(groups = "111111")
    public void test1(){
        System.out.println("这是Group1的测试用例1");
    }

    @Test(groups = "111111")
    public void test2(){
        System.out.println("这是Group1的测试用例2");
    }

    @Test(groups = "222222")
    public void test3(){
        System.out.println("这是Group2的测试用例1");
    }

    @Test(groups = "222222")
    public void test4(){
        System.out.println("这是Group2的测试用例2");
    }

    @BeforeGroups("111111")
    public void beforeGroups1(){
        System.out.println("在Group1之前运行");
    }

    @AfterGroups("111111")
    public void afterGroups1(){
        System.out.println("在Group1之后运行");
    }


}
