package com.fankf.sign.composite;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 *
 * @author fan
 * @create 2020-07-06 21:32
 * @description
 * @see
 */
public class OrderSplitTest {
    public static void main(String[] args) {
        Order v0 = JSON.parseObject("{\"money\":100}", Order.class);
        Order v1 = JSON.parseObject("{\"money\":101}", Order.class);
        Order v2 = JSON.parseObject("{\"money\":102}", Order.class);
        Order v3 = JSON.parseObject("{\"money\":103}", Order.class);
        Order v4 = JSON.parseObject("{\"money\":104}", Order.class);

        // 规则 v0 先合并 v1 ,返回结果后续依次合并到v4
        Order result0 = mergeOrders(Arrays.asList(v1, v0));
        Order result1 = mergeOrders(Arrays.asList(v2, result0));
        Order result2 = mergeOrders(Arrays.asList(v3, result1));
        Order result3 = mergeOrders(Arrays.asList(v4, result2));


        System.out.println(result3);

        List<Order> orders = new ArrayList<>();
        splitOrders(result3,orders);
        System.out.println(orders);


    }

    private static Order mergeOrders(List<Order> orders) {
        Order var0 = new Order();
        List<Order> orders1 = new ArrayList<>();
        orders.forEach(order -> {
            orders1.add(order);
            var0.setMoney(var0.getMoney() + order.getMoney());
        });
        var0.setOrders(orders1);
        return var0;
    }

    private static void splitOrders(Order order, List<Order> result) {
        List<Order> orders = order.getOrders();
        orders.forEach(var0 -> {
            if (var0.getOrders() != null) {
                splitOrders(var0, result);
            } else {
                result.add(var0);
            }
            order.setMoney(order.getMoney() - var0.getMoney());
        });
    }
}