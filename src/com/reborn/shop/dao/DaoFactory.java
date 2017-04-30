package com.reborn.shop.dao;

/**
 * Created by Administrator on 2017/4/30.
 */
public class DaoFactory {
    public static IAddressDao getAddressDao(){
        return new AddressJDBCDao();
    }

    public static IUserDao getUserDao() {
        return new UserJDBCDao();
    }
}
