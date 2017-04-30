package com.reborn.shop.dao;

import com.reborn.shop.model.Address;
import com.reborn.shop.model.User;
import com.reborn.shop.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/30.
 */
public class AddressJDBCDao implements IAddressDao{
    @Override
    public void add(Address address, int userId) {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "insert into t_address(name, phone, postcode, user_id) value (?, ?, ?, ?)";
        con = DBUtil.getConnection();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, address.getName());
            ps.setString(2, address.getPhone());
            ps.setString(3, address.getPostcode());
            ps.setInt(4, userId);
            /**
             * 更新
             */
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(Address address) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Address> list(int userId) {
        List<Address> address = new ArrayList<Address>();
        Address a = null;
        User u = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select t1.id as 'a_id', t1.name as 'a_name', t1.phone as 'a_phone', t1.postcode as 'a_postcode', t2.id as 'user_id', t2.nickname, t2.password, t2.username, t2.type as 'user_type' from t_address t1 LEFT join t_user t2 on (t1.user_id = t2.id ) where user_id = 1";
        con = DBUtil.getConnection();
        try {
            ps = con.prepareStatement(sql);
//            ps.setInt(1, userId);
            rs = ps.executeQuery();
            while(rs.next()){
//                System.out.print(rs.getInt("a_id"));
//                System.out.print(rs.getString("a_name"));
//                System.out.print(rs.getString("a_phone"));
//                System.out.print(rs.getString("a_postcode"));
//                System.out.print(rs.getInt("user_id"));
//                System.out.print(rs.getString("nickname"));
//                System.out.print(rs.getString("password"));
//                System.out.print(rs.getString("username"));
//                System.out.print(rs.getInt("user_type"));
//
//                System.out.println();

                a = new Address();
                a.setId(rs.getInt("a_id"));
                a.setName(rs.getString("a_name"));
                a.setPhone(rs.getString("a_phone"));
                a.setPostcode(rs.getString("a_postcode"));
                u = new User();
                u.setId(rs.getInt("user_id"));
                u.setNickname(rs.getString("nickname"));
                u.setPassword(rs.getString("password"));
                u.setUsername(rs.getString("username"));
                u.setType(rs.getInt("user_type"));
                a.setUser(u);
                address.add(a);
            }

        } catch (SQLException e) {
            System.out.println("yichan");
            e.printStackTrace();
        }finally {
            try {
                con.close();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return address;
    }

    @Override
    public Address address() {
        return null;
    }
}
