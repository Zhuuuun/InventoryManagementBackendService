package com.zhunismp.project1.controller;

import com.zhunismp.project1.entity.Order;
import com.zhunismp.project1.exception.OrderNotFoundException;
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
                orderService.findAll()
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
        Order buff = orderService.findById(orderId);
        if(buff == null) throw new OrderNotFoundException("Order doesn't exists with id : " + orderId);

        return ResponseHandler.responseBuilder(
                "Request successfully : from " + new Object(){}.getClass().getEnclosingMethod().getName() + "()",
                HttpStatus.OK,
                buff
        );
    }

    @PostMapping("order/add")
    public ResponseEntity<Object> updateOrder(@RequestBody @Valid Order order) {
        if(orderService.findById(order.getId()) == null) throw new OrderNotFoundException("Order doesn't exists with id : " + order.getId());
        orderService.save(order);

        return ResponseHandler.responseBuilder(
                "Request successfully : from " + new Object(){}.getClass().getEnclosingMethod().getName() + "()",
                HttpStatus.OK,
                null
        );
    }

    @DeleteMapping("order/delete/{orderId}")
    public ResponseEntity<Object> deleteOrderById(@PathVariable int orderId) {
        if(orderService.findById(orderId) == null) throw new OrderNotFoundException("Order doesn't exists with id : " + orderId);
        orderService.deleteById(orderId);

        return ResponseHandler.responseBuilder(
                "Request successfully : from " + new Object(){}.getClass().getEnclosingMethod().getName() + "()",
                HttpStatus.OK,
                null
        );
    }

//    @PutMapping("order/complete/{orderId}")
//    public ResponseEntity<Object> completeOrder(@PathVariable int orderId) {
//        if(orderService.findById(orderId) == null) throw new OrderNotFoundException("Order doesn't exists with id : " + orderId);
//        orderService.completeOrder(orderId);
//
//        return ResponseHandler.responseBuilder(
//                "Request successfully : from " + new Object(){}.getClass().getEnclosingMethod().getName() + "()",
//                HttpStatus.OK,
//                null
//        );
//    }
}
