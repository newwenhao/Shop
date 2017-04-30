package com.reborn.shop.test;

import com.reborn.shop.dao.DaoFactory;
import com.reborn.shop.dao.IAddressDao;
import com.reborn.shop.dao.IUserDao;
import com.reborn.shop.model.Address;
import com.reborn.shop.model.User;

import java.util.List;

/**
 * Created by Administrator on 2017/4/30.
 */
public class TestAddress {
    private static IAddressDao addressDao = DaoFactory.getAddressDao();
    private static IUserDao userDao = DaoFactory.getUserDao();
    public static void main(String args[]){
//        testAdd();
        testList();
        testLoadUser();
    }
    public static void testAdd(){
        Address address = new Address();
        address.setName("hainansheng");
        address.setPhone("110");
        address.setPostcode("435500");
        addressDao.add(address, 1);
    }
    public static void testList(){
        List<Address> list = addressDao.list(1);
        for (Address a: list){
            System.out.println(a.getName()+", "+a.getUser().getNickname() );
        }
    }
    private static void testLoadUser(){
        User u = userDao.load(1);
        System.out.println(u.getNickname());
        for (Address a: u.getAddress()){
            System.out.println(a.getName()+", "+ a.getPhone());
        }
    }
}
