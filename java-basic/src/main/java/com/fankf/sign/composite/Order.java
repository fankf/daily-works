package com.fankf.sign.composite;

import java.util.List;

/**
 * @author fan
 * @create 2020-07-06 21:28
 * @description
 * @see
 */
public class Order {

    private int money;
    private List<Order> orders;

    public Order() {
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }
}
