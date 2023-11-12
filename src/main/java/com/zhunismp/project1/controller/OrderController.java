package com.zhunismp.project1.controller;

import com.zhunismp.project1.entity.Order;
import com.zhunismp.project1.response.ResponseHandler;
import com.zhunismp.project1.services.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public ResponseEntity<Object> getAllOrders() {
        return ResponseHandler.responseBuilder(
                "Request successfully : from " + new Object(){}.getClass().getEnclosingMethod().getName() + "()",
                HttpStatus.OK,
                orderService.findAllOrder()
        );
    }

    @GetMapping("/completeOrders")
    public ResponseEntity<Object> getAllCompleteOrders() {
        return ResponseHandler.responseBuilder(
                "Request successfully : from " + new Object(){}.getClass().getEnclosingMethod().getName() + "()",
                HttpStatus.OK,
                orderService.findAllCompleteOrders()
        );
    }

    @GetMapping("/unCompleteOrders")
    public ResponseEntity<Object> getAllUnCompleteOrders() {
        return ResponseHandler.responseBuilder(
                "Request successfully : from " + new Object(){}.getClass().getEnclosingMethod().getName() + "()",
                HttpStatus.OK,
                orderService.findAllUnCompleteOrders()
        );
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<Object> getOrderById(@PathVariable @Valid int orderId) {
        return ResponseHandler.responseBuilder(
                "Request successfully : from " + new Object(){}.getClass().getEnclosingMethod().getName() + "()",
                HttpStatus.OK,
                orderService.findOrderById(orderId)
        );
    }

    @PostMapping("order/add")
    public ResponseEntity<Object> updateOrder(@RequestBody @Valid Order order) {
        orderService.saveOrder(order);

        return ResponseHandler.responseBuilder(
                "Request successfully : from " + new Object(){}.getClass().getEnclosingMethod().getName() + "()",
                HttpStatus.OK,
                null
        );
    }

    @DeleteMapping("order/delete/{orderId}")
    public ResponseEntity<Object> deleteOrderById(@PathVariable int orderId) {
        orderService.deleteOrderById(orderId);

        return ResponseHandler.responseBuilder(
                "Request successfully : from " + new Object(){}.getClass().getEnclosingMethod().getName() + "()",
                HttpStatus.OK,
                null
        );
    }

    @PutMapping("order/complete/{orderId}")
    public ResponseEntity<Object> completeOrder(@PathVariable int orderId) {
        orderService.completeOrder(orderId);

        return ResponseHandler.responseBuilder(
                "Request successfully : from " + new Object(){}.getClass().getEnclosingMethod().getName() + "()",
                HttpStatus.OK,
                null
        );
    }
}
