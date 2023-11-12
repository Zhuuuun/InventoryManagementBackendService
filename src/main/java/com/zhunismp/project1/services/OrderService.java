package com.zhunismp.project1.services;

import com.zhunismp.project1.entity.Order;

import java.util.List;

public interface OrderService {
    void saveOrder(Order order);
    void deleteOrderById(int id);
    void updateOrder(Order order);
    List<Order> findAllOrder();
    List<Order> findAllCompleteOrders();
    List<Order> findAllUnCompleteOrders();

    Order findOrderById(int id);

    void completeOrder(int id);
}
