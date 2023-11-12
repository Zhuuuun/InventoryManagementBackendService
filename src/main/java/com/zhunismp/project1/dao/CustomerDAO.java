package com.zhunismp.project1.dao;

import com.zhunismp.project1.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    void save(Customer customer);
    void deleteCustomerById(int id);
    void update(Customer customer);
    Customer findCustomerById(int id);
    List<Customer> findAllCustomer();
}
