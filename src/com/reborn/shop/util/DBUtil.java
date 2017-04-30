package com.reborn.shop.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Administrator on 2017/4/30.
 */
public class DBUtil {
    public static String url = "jdbc:mysql://localhost:3307/itat_shop?useUnicode=true&amp;amp;characterEncoding=utf-8";
    public static String username = "root";
    public static String password = "123456";
    public static String drive = "com.mysql.jdbc.Driver";
    public static Connection getConnection(){
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");  //注册数据库驱动
            con = DriverManager.getConnection(url, username, password);//获取数据库连接
            System.out.println("数据库连接成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

}
