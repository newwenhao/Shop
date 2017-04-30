package com.reborn.shop.model;

/**
 * Created by Administrator on 2017/4/30.
 */
public class Goods {
    private int id;
    private String name;
    private double price;
    private String introduce;
    private String image;
    private int stock;
    private Category categoty;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Category getCategoty() {
        return categoty;
    }

    public void setCategoty(Category categoty) {
        this.categoty = categoty;
    }
}
