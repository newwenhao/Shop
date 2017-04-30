package com.reborn.shop.dao;

import com.reborn.shop.model.Address;

import java.util.List;

/**
 * Created by Administrator on 2017/4/30.
 */
public interface IAddressDao {
    public void add(Address address, int userId);
    public void update(Address address);
    public void delete(int id);
    public List<Address> list(int userId);
    public Address address();
}
