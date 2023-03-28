package com.course.client.utils;

import com.course.client.model.InterfaceName;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author haona
 * @ClassName ConfigFile
 * @Description TODO
 * @date 20/3/2023 3:52 下午
 */
public class ConfigFile {

    private static ResourceBundle bundle = ResourceBundle.getBundle("application", Locale.CHINA);

    public static String getUrl(InterfaceName name) {
        String address = bundle.getString("test.url");
        String uri = "";
        String testUrl = "";

        if (name.equals(InterfaceName.LOGIN)) {
            uri = bundle.getString("login.uri");
        }
        if (name.equals(InterfaceName.ADDUSERINFO)) {
            uri = bundle.getString("addUser.uri");
        }
        if (name.equals(InterfaceName.UPDATEUSERINFO)) {
            uri = bundle.getString("updateUserInfo.uri");
        }
        if (name.equals(InterfaceName.GETUSERINFO)) {
            uri = bundle.getString("getUserInfo.uri");
        }
        if (name.equals(InterfaceName.GETUSERLIST)) {
            uri = bundle.getString("getUserList.uri");
        }
        testUrl = address + uri;
        return testUrl;
    }
}
