package com.course.server.model;

import lombok.Data;

/**
 * @author haona
 * @ClassName User
 * @Description TODO
 * @date 21/3/2023 10:59 下午
 */
@Data
public class User {
    private int id;
    private String username;
    private String password;
    private String sex;
    private int age;
    private int permission;
    private int deleted;
}
