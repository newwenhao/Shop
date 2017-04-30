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
public class UserJDBCDao implements IUserDao {
    @Override
    public User load(int id) {
        List<Address> address = new ArrayList<Address>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;
        Address a = null;

        con = DBUtil.getConnection();
        String sql = "select * from t_user where id = ?";
        con = DBUtil.getConnection();
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                u = new User();
                u.setId(rs.getInt("id"));
                u.setNickname(rs.getString("nickname"));
                u.setPassword(rs.getString("password"));
                u.setType(rs.getInt("type"));
                u.setUsername(rs.getString("username"));
            }
            sql = "select * from t_address where user_id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                a = new Address();
                a.setId(rs.getInt("id"));
                a.setName(rs.getString("name"));
                a.setPhone(rs.getString("phone"));
                a.setPostcode(rs.getString("postcode"));
                address.add(a);
            }
            u.setAddress(address);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                ps.close();
                con.close();
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return u;
    }
}
