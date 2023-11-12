package com.zhunismp.project1.dao;

import com.zhunismp.project1.entity.Customer;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
    private final EntityManager entityManager;

    @Autowired
    public CustomerDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Customer customer) {
        entityManager.persist(customer);
    }


    @Override
    public void deleteCustomerById(int id) {
        entityManager.remove(entityManager.find(Customer.class,id));
    }


    @Override
    public void update(Customer customer) {
        entityManager.merge(customer);
    }

    @Override
    public Customer findCustomerById(int id) {
        return entityManager.find(Customer.class,id);
    }

    @Override
    public List<Customer> findAllCustomer() {
        return entityManager.createQuery("from Customer", Customer.class).getResultList();
    }

}
