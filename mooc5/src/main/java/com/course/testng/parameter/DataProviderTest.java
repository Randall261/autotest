package com.course.testng.parameter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sun.jvm.hotspot.oops.ObjArray;

import java.lang.reflect.Method;

/**
 * @author haona
 * @ClassName DataProvider
 * @Description 参数化测试方法二，结合@DataProvider使用
 * @date 13/3/2023 5:32 下午
 */
public class DataProviderTest {

    @Test(dataProvider = "providerName")
    public void test1(String name, int age) {
        System.out.println("name=" + name + "\tage=" + age);
    }

    @DataProvider(name = "providerName")
    public Object[][] provider1() {
        Object[][] o = new Object[][]{{"姓名1", 1}, {"姓名2", 2}, {"姓名3", 3}};
        return o;
    }

    //不同方法传入不同参数
    @Test(dataProvider = "methodParam")
    public void test2(String name, int age){
        System.out.println("name=" + name + "\tage=" + age);
    }

    @Test(dataProvider = "methodParam")
    public void test3(String name, int age){
        System.out.println("name=" + name + "\tage=" + age);
    }

    @DataProvider(name = "methodParam")
    public Object[][] provider2(Method method){
        Object[][] o = null;
        if (method.getName().equals("test2")){
            o = new Object[][]{
                    {"test2的名字1",10},
                    {"test2的名字2",20}
            };
        } else if (method.getName().equals("test3")){
            o = new Object[][]{
                    {"test3的名字1",30},
                    {"test3的名字2",40}
            };
        }
        return o;
    }
}
