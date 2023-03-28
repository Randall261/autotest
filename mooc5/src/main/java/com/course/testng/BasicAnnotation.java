package com.course.testng;

import org.testng.annotations.*;

/**
 * @author haona
 * @ClassName BasicAnnotation
 * @Description TODO
 * @date 12/3/2023 10:30 下午
 */
public class BasicAnnotation {

    @Test
    public void testCase1() {
        System.out.println("这是---@Test---测试用例1");
    }

    @Test
    public void testCase2() {
        System.out.println("这是---@Test---测试用例2");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("---@BeforeMethod---环绕在每一个@Test方法之前运行");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("---@AfterMethod---环绕在每一个@Test方法之后运行");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("---@BeforeClass---在类之前运行");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("---@AfterClass---在类之后运行");
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("---@BeforeSuite---测试套件在@BeforeClass之前运行");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("---@AfterSuite---测试套件在@AfterClass之后运行");
    }
}

