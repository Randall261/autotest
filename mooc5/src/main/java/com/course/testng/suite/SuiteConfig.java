package com.course.testng.suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

/**
 * @author haona
 * @ClassName SuiteConfig
 * @Description TODO
 * @date 12/3/2023 10:54 下午
 */
public class SuiteConfig {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("在BeforeClass之前运行的内容");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("在AfterClass之前运行的内容");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("在每个用例之前运行的内容");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("在每个用例之后运行的内容");
    }
}
