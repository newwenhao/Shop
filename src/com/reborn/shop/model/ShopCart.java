package com.reborn.shop.model;

import java.util.List;

/**
 * Created by Administrator on 2017/4/30.
 */
public class ShopCart {
    private List<Goods> good;

    public List<Goods> getGood() {
        return good;
    }

    public void setGood(List<Goods> good) {
        this.good = good;
    }
}
