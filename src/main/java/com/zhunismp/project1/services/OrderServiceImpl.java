package com.zhunismp.project1.services;

import com.zhunismp.project1.dao.OrderDAO;
import com.zhunismp.project1.entity.Order;
import com.zhunismp.project1.exception.OrderNotFoundException;
import org.hibernate.TypeMismatchException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderDAO orderDAO;

    public OrderServiceImpl(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Override
    @Transactional
    public void saveOrder(Order order) {
        orderDAO.save(order);
    }

    @Override
    @Transactional
    public void deleteOrderById(int id) {
        if(orderDAO.findOrderById(id) == null) throw new OrderNotFoundException("Order doesn't exist for order id : " + id);
        orderDAO.deleteOrderById(id);
    }

    @Override
    @Transactional
    public void updateOrder(Order order) {
        orderDAO.update(order);
    }

    @Override
    public List<Order> findAllOrder() {
        return orderDAO.findAllOrders();
    }

    @Override
    public List<Order> findAllCompleteOrders() {
        return orderDAO.findAllCompleteOrders();
    }

    @Override
    public List<Order> findAllUnCompleteOrders() {
        return orderDAO.findAllUnCompleteOrders();
    }

    @Override
    public Order findOrderById(int id) {
        if(orderDAO.findOrderById(id) == null) throw new OrderNotFoundException("Order doesn't exist for order id : " + id);
        return orderDAO.findOrderById(id);
    }

    @Override
    @Transactional
    public void completeOrder(int id) {
        if(orderDAO.findOrderById(id) == null) throw new OrderNotFoundException("Order doesn't exist for order id : " + id);
        orderDAO.completeOrder(id);
    }


}
