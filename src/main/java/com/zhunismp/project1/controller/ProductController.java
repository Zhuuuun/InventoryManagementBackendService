package com.zhunismp.project1.controller;

import com.zhunismp.project1.entity.Product;
import com.zhunismp.project1.exception.ProductNotFoundException;
import com.zhunismp.project1.response.ResponseHandler;
import com.zhunismp.project1.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity<Object> getAllProducts() {
        return ResponseHandler.responseBuilder(
                "Request successfully : from " + new Object(){}.getClass().getEnclosingMethod().getName() + "()",
                HttpStatus.OK,
                productService.findAll()
        );
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<Object> getProductById(@PathVariable int productId) {
        Product buff = productService.findById(productId);
        if(buff == null) throw new ProductNotFoundException("Product doesn't exists with id : " + productId);

        return ResponseHandler.responseBuilder(
                "Request successfully : from " + new Object(){}.getClass().getEnclosingMethod().getName() + "()",
                HttpStatus.OK,
                buff
        );
    }

    @PostMapping("/product/add")
    public ResponseEntity<Object> addProduct(@RequestBody @Valid Product product) {
        Product buff = productService.save(product);

        return ResponseHandler.responseBuilder(
                "Request successfully : from " + new Object(){}.getClass().getEnclosingMethod().getName() + "()",
                HttpStatus.CREATED,
                buff
        );
    }

    @DeleteMapping("/product/delete/{productId}")
    public ResponseEntity<Object> deleteProductById(@PathVariable int productId) {
        if(productService.findById(productId) == null) throw new ProductNotFoundException("Product doesn't exists with id : " + productId);
        productService.deleteById(productId);

        return ResponseHandler.responseBuilder(
                "Request successfully : from " + new Object(){}.getClass().getEnclosingMethod().getName() + "()",
                HttpStatus.OK,
                null
        );
    }

    @PutMapping("/product/update")
    public ResponseEntity<Object> updateProduct(@RequestBody @Valid Product product) {
        if(productService.findById(product.getId()) == null) throw new ProductNotFoundException("Product doesn't exists with id : " + product.getId());
        Product buff = productService.save(product);

        return ResponseHandler.responseBuilder(
                "Request successfully : from " + new Object(){}.getClass().getEnclosingMethod().getName() + "()",
                HttpStatus.OK,
                buff
        );
    }

}
