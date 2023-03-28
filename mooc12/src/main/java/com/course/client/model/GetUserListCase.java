package com.course.client.model;

import lombok.Data;

/**
 * @author haona
 * @ClassName GetUserListCase
 * @Description TODO
 * @date 20/3/2023 4:37 下午
 */
@Data
public class GetUserListCase {
    private int id;
    private String username;
    private String sex;
    private int age;
    private String expected;
}
