package com.zhunismp.project1.services;

import com.zhunismp.project1.entity.Customer;

import java.util.List;

public interface CustomerService {
    void saveCustomer(Customer customer);
    void deleteCustomerById(int id);
    void updateCustomer(Customer customer);
    Customer findCustomerById(int id);
    List<Customer> findAllCustomer();

}
