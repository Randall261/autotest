package com.course.testng.groups;

import org.testng.annotations.Test;

/**
 * @author haona
 * @ClassName ClassGroup
 * @Description 分组测试方法二
 * 分组测试 @Test(groups = "组名1")
 * 把 @Test 写在类上，通过groups.xml配置文件运行不同组的测试用例
 * @date 13/3/2023 3:24 下午
 */
@Test(groups = "student")
public class ClassGroups1 {

    public void stu1() {
        System.out.println("这是学生分组，stu1");
    }

    public void stu2() {
        System.out.println("这是学生分组，stu2");
    }
}
