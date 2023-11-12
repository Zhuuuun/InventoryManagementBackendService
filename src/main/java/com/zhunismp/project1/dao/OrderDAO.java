package com.zhunismp.project1.dao;

import com.zhunismp.project1.entity.Order;

import java.util.List;

public interface OrderDAO {
    void save(Order order);
    void deleteOrderById(int id);
    void update(Order order);
    List<Order> findAllOrders();

    List<Order> findAllCompleteOrders();
    List<Order> findAllUnCompleteOrders();
    Order findOrderById(int id);

    void completeOrder(int id);


}
