package com.zhunismp.project1.controller;

import com.zhunismp.project1.entity.Customer;
import com.zhunismp.project1.response.ResponseHandler;
import com.zhunismp.project1.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public ResponseEntity<Object> getAllCustomers() {
        return ResponseHandler.responseBuilder(
                "Request successfully : from " + new Object(){}.getClass().getEnclosingMethod().getName() + "()",
                HttpStatus.OK,
                customerService.findAllCustomer()
        );
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<Object> getCustomerById(@PathVariable int customerId) {
        // get current method name : https://stackoverflow.com/questions/442747/getting-the-name-of-the-currently-executing-method

        return ResponseHandler.responseBuilder(
                    "Request successfully : from " + new Object(){}.getClass().getEnclosingMethod().getName() + "()",
                    HttpStatus.OK,
                    customerService.findCustomerById(customerId)
        );

    }

    @PostMapping("/customer/add")
    public ResponseEntity<Object> addCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);

        return ResponseHandler.responseBuilder(
                "Request successfully : from " + new Object(){}.getClass().getEnclosingMethod().getName() + "()",
                HttpStatus.OK,
                null
        );
    }

    @DeleteMapping("customer/delete/{customerId}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable int customerId) {
        customerService.deleteCustomerById(customerId);

        return ResponseHandler.responseBuilder(
                "Request successfully : from " + new Object(){}.getClass().getEnclosingMethod().getName() + "()",
                HttpStatus.OK,
                null
        );
    }

    @PutMapping("customer/update")
    public ResponseEntity<Object> updateCustomer(@RequestBody Customer customer) {
        customerService.updateCustomer(customer);

        return ResponseHandler.responseBuilder(
                "Request successfully : from " + new Object(){}.getClass().getEnclosingMethod().getName() + "()",
                HttpStatus.OK,
                null
        );
    }

}
