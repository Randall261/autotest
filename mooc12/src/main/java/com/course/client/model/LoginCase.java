package com.course.client.model;

import lombok.Data;

/**
 * @author haona
 * @ClassName LoginCase
 * @Description 对应数据库登录用例
 * @date 20/3/2023 4:20 下午
 */

@Data
public class LoginCase {
    private int id;
    private String username;
    private String password;
    private String expected;
}
