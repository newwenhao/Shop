package com.reborn.shop.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Administrator on 2017/4/30.
 */
public class PropertiesUtils {
    public static Properties getJdbcProp(){
        String driver="com.mysql.jdbc.Driver";
        /**
         * 读取文件中的配置文件
         */
        InputStream inputStream = PropertiesUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        try {
            Class.forName(driver);  //加载驱动
            properties.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }

}
