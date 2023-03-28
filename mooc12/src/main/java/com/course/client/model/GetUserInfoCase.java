package com.course.client.model;

import lombok.Data;

/**
 * @author haona
 * @ClassName GetUserInfoCase
 * @Description TODO
 * @date 20/3/2023 4:36 下午
 */
@Data
public class GetUserInfoCase {
    private int id;
    private int userid;
    private String expected;
}
