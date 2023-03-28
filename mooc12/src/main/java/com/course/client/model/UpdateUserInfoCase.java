package com.course.client.model;

import lombok.Data;

/**
 * @author haona
 * @ClassName UpdateUserInfoCase
 * @Description TODO
 * @date 20/3/2023 4:37 下午
 */
@Data
public class UpdateUserInfoCase {
    private int id;
    private int userid;
    private String username;
    private String sex;
    private int age;
    private int permission;
    private int deleted;
    private String expected;
}
