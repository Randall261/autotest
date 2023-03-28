package com.course.client.model;

import lombok.Data;

/**
 * @author haona
 * @ClassName AddUserCase
 * @Description TODO
 * @date 20/3/2023 4:34 下午
 */

@Data
public class AddUserCase {
    private int id;
    private String username;
    private String password;
    private String sex;
    private int age;
    private int permission;
    private int deleted;
    private String expected;
}
