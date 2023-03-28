package com.course.testng.groups;

import org.testng.annotations.Test;

/**
 * @author haona
 * @ClassName ClassGroups2
 * @Description 分组测试方法二
 * 分组测试 @Test(groups = "组名2")
 * 把 @Test 写在类上，通过groups.xml配置文件运行不同组的测试用例
 * @date 13/3/2023 4:05 下午
 */
@Test(groups = "teacher")
public class ClassGroups2 {

    public void teacher1() {
        System.out.println("这是老师分组，teacher1");
    }

    public void teacher2() {
        System.out.println("这是老师分组，teacher2");
    }
}

