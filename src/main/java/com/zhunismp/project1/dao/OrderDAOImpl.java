package com.zhunismp.project1.dao;

import com.zhunismp.project1.entity.Order;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDAOImpl implements OrderDAO {
    private final EntityManager entityManager;

    @Autowired
    public OrderDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Order order) {
        entityManager.persist(order);
    }

    @Override
    public void deleteOrderById(int id) {
        entityManager.remove(entityManager.find(Order.class,id));
    }

    @Override
    public void update(Order order) {
        entityManager.merge(order);
    }

    @Override
    public List<Order> findAllOrders() {
        return entityManager.createQuery("from Order order by orderDateTime", Order.class).getResultList();
    }

    @Override
    public List<Order> findAllCompleteOrders() {
        return entityManager.createQuery("from Order where status = 0 order by orderDateTime", Order.class).getResultList();
    }

    @Override
    public List<Order> findAllUnCompleteOrders() {
        return entityManager.createQuery("from Order where status = 1 order by orderDateTime", Order.class).getResultList();
    }

    @Override
    public Order findOrderById(int id) {
        return entityManager.find(Order.class,id);
    }

    @Override
    public void completeOrder(int id) {
        Order order = entityManager.find(Order.class,id);
        order.setStatus(0);

        entityManager.merge(order);
    }

}
