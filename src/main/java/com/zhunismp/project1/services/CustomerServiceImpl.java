package com.zhunismp.project1.services;

import com.zhunismp.project1.dao.CustomerDAO;
import com.zhunismp.project1.entity.Customer;
import com.zhunismp.project1.exception.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerDAO customerDAO;

    @Autowired
    public CustomerServiceImpl(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    @Transactional
    public void saveCustomer(Customer customer) {
        customerDAO.save(customer);
    }

    @Override
    @Transactional
    public void deleteCustomerById(int id) {
        if(customerDAO.findCustomerById(id) == null) throw new CustomerNotFoundException("Customer doesn't exists for id : " + id);
        customerDAO.deleteCustomerById(id);
    }

    @Override
    @Transactional
    public void updateCustomer(Customer customer) {
        customerDAO.update(customer);
    }

    @Override
    public Customer findCustomerById(int id) {
        if(customerDAO.findCustomerById(id) == null) throw new CustomerNotFoundException("Customer doesn't exists for id : " + id);
        return customerDAO.findCustomerById(id);
    }

    @Override
    public List<Customer> findAllCustomer() {
        return customerDAO.findAllCustomer();
    }


}
